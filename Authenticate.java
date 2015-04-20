import java.util.ArrayList;

public class Authenticate {

	// authenticate user using the credentials
	public String authenticateUser(String username, String password)
			throws CException {

		ArrayList<ArrayList<String>> resultSet;

		String userType = null;

		DatabaseClass p1 = new DatabaseClass();
		ArrayList<String> list = new ArrayList<String>();

		p1.getConnected();

		String username1 = "'" + username + "'";
		String password1 = "'" + password + "'";

		String query = "select studentID from student where fName ="
				+ username1 + " and password =" + password1;

		try {
			resultSet = p1.getData(query, list);

			if (resultSet.isEmpty()) {

				String query1 = "select id from faculty where fName ="
						+ username1 + " and password=" + password1;
				resultSet = p1.getData(query1, list);

				if (resultSet.isEmpty()) {
					System.out
							.println("You entered a wrong username or password");
				} else {
					userType = "faculty";
					System.out.println("Welcome Proffessor " + username);
				}
			} else {
				userType = "student";
				System.out.println("Welcome Student " + username);

			}

		} catch (Exception e) {
			throw new CException(e,
					"There was an error in authenticating the user!");
		}
		return userType;
	}

	// get the user ID
	public int getUserID(String userType, String username) throws CException {

		DatabaseClass db = new DatabaseClass();
		int userID = 0;
		ArrayList<String> values = new ArrayList<String>();
		values.add(String.valueOf(username));
		String query = "SELECT id FROM " + userType + " where fname = ? ";
		ArrayList<ArrayList<String>> arrayLists = db.getData(query, values);

		for (ArrayList<String> ar : arrayLists) {
			// System.out.println( "first array "+ ar);
			int i = 0;
			for (String str : ar) {
				userID = Integer.parseInt(ar.get(i));
				i++;
			}
		}

		return userID;

	}

}