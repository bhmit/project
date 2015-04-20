package project;

import java.util.ArrayList;


public class Student extends Person {

	DatabaseLayer obj;

	public Student() {
		// TODO Auto-generated constructor stub
		obj = new DatabaseLayer();
	}
	/**
	 * @return
	 */
	public boolean insertComment(){

		ArrayList<String> values = new ArrayList<String>();
		values.add(String.valueOf(getPaperId()));
		values.add(String.valueOf(getPersonId()));
		values.add(String.valueOf(getComment()));

		String query = "INSERT INTO `484PROJECT`.`Comments` (`paperID`, `studentID`, `Comment`) VALUES (?, ?, ?)";



		return obj.setData(query,values);
	}
	
}
