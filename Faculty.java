package project;

import java.util.ArrayList;


public class Faculty extends Person{
	private int facultyId;
	private  DatabaseLayer obj;


	public Faculty() {
		// TODO Auto-generated constructor stub
		obj  = new DatabaseLayer();
	}

	public int getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	
	/**
	 * insert comment to paper
	 * @return
	 */
	public boolean insertComment(){
		ArrayList<String> values = new ArrayList<String>();
		values.add(String.valueOf(getPaperId()));
		values.add(String.valueOf(getPersonId()));
		values.add(String.valueOf(getComment()));
		String query = "INSERT INTO comments (paperId,"
				+ " PersonId, Comment) VALUES (?,?,?)";
		return obj.setData(query,values);
		//return false;
	}

	/**
	 * to crete new paper
	 * @return
	 */
	public boolean createPaper(){
		ArrayList<String> values = new ArrayList<String>();
		values.add(String.valueOf(getTitle()));
		values.add(getP_abstract());
		values.add(getCitation());
		String query = "INSERT INTO paper (title, abstract, citation) VALUES (?,?,?)";
		return obj.setData(query,values);
	}

	/**
	 * to edit paaper
	 * @return
	 */
	public boolean editPaper(){
		ArrayList<String> values = new ArrayList<String>();
		values.add(getP_abstract());
		values.add(String.valueOf(getPaperId()));
		String query = "UPDATE papers SET abstract = ? WHERE id = ?";
		return obj.setData(query,values);
	}

	/**
	 * to delet
	 * @return
	 */
	public boolean deletePaper(){
		//TODO from Bandar Add sql string to delete.
		String id = String.valueOf(getPaperId());
		String query = "Delete from papers where id = ?";
		ArrayList<String> values = new ArrayList<String>();
		values.add(id);
		return obj.setData(query,values);
	}
	
}
