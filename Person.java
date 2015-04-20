package project;


import java.util.ArrayList;




/**
 * @author Harsh
 *
 */
/**
 * @author Harsh
 *
 */
/**
 * @author Harsh
 *
 */
public class Person {
	private int paperId;
	private String title;
	private String p_abstract;
	private String citation;
	private int personId;
	//public int facultyId;
	private String fName;
	private String lName;
	private String password;
	private String email;
	private String keyword;
	private int commentId;
	private String comment;
	private DatabaseLayer obj;

	public Person(){
		obj = new DatabaseLayer();

	}
	public Person(int personId, String fName, String lName, String password,
			String email) {
		this.personId = personId;
		this.fName = fName;
		this.lName = lName;
		this.password = password;
		this.email = email;
	}
	
	public DatabaseLayer getConnection(){
		obj = new DatabaseLayer();
		return obj;
	}
	
	public int getPaperId() {
		return paperId;
	}
	public void setPaperId(int paperId) {
		this.paperId = paperId; 
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getP_abstract() {
		return p_abstract;
	}
	public void setP_abstract(String p_abstract) {
		this.p_abstract = p_abstract;
	}
	public String getCitation() {
		return citation;
	}
	public void setCitation(String citation) {
		this.citation = citation;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	/**
	 * show the list of papers using keyword
	 * 
	 * @return
	 */
	public ArrayList<ArrayList<String>> showPapers(){
		ArrayList<String> values = new ArrayList<String>();
		values.add(keyword);
		String query = "SELECT * FROM paper_keywords WHERE keyword = ?" ;
		return obj.getData(query,values);
	}
	
	/**
	 * view a particular paper using id
	 * 
	 * @return
	 */
	public ArrayList<ArrayList<String>> viewPaper(){

		ArrayList<String> values = new ArrayList<String>();
		values.add(String.valueOf(paperId));
		String query = "SELECT * FROM papers where id= ? ";
		ArrayList<ArrayList<String>> arrayLists = obj.getData(query,values);
		return arrayLists;
	}
	
	/**
	 * @return
	 */
	public ArrayList<ArrayList<String>> viewComments(){
		ArrayList<String> values = new ArrayList<String>();
		values.add(String.valueOf(commentId));
		String query = "SELECT * FROM Comments WHERE commentId = ?" ;

		return obj.getData(query,values);
	}
	
	
	
	
	
}
