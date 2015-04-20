package project;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bandarmadani on 4/16/15.
 */
public class DatabaseLayer {

   // user@xx.xxx.xx.xx



    static final String driver="com.mysql.jdbc.Driver";

//    static final String uri="jdbc:mysql://69.28.92.36/simon.ist.rit.edu/networx_ser";
//    static final String userID= "330User";
//    static final String userPW="330Password";

    private static final String uri = "jdbc:mysql://delalaty.com/484PROJECT";
    private static final String userID = "iste722";
    private static final String userPW = "password";

    static Connection conn=null;

    private Map<String, PreparedStatement> hashMapPS;


    public DatabaseLayer(){
       hashMapPS = new HashMap<String, PreparedStatement>();


    }


    public boolean getConnected(){

        boolean conStatus = false;

        try{
            Class.forName( driver);
            System.out.println("driver loaded! Yes!!!");

            conn= DriverManager.getConnection(uri, userID, userPW);
            System.out.println(" I feel such a connection with this DB.");


            if (conn != null) {
                System.out.println("We made it, take control of database now!");
                conStatus= true;

            }
            else {
                System.out.println("Failed to make connection!");
                conStatus=false;
            }

        }

        catch(SQLException e) {
            System.err.println("SQL Error(s) as follows:");
            while (e != null) {
                System.err.println("  SQL Return Code: " + e.getSQLState());
                System.err.println("  Error Message: " + e.getMessage());
                System.err.println("  Vendor Message: " + e.getErrorCode());
                e = e.getNextException();
            }
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e) {
            System.err.println(e);
        }  // end try-catch
        return conStatus;

    }

    /**
     * to prepare the statment and save it in hash table
     * @param _sql
     * @param _listValue
     * @return
     */
    public PreparedStatement prepare (String _sql, ArrayList<String> _listValue){

        PreparedStatement psmt = null;

        try {
            if (hashMapPS.containsKey(_sql)) {
                psmt = hashMapPS.get(_sql);
            }else {
                psmt = conn.prepareStatement(_sql);
                hashMapPS.put(_sql, psmt);
            }
            // check if the arryList have value if not we just execute qurey to retrive all table data.
            if(!(_listValue.isEmpty())) {
                for (int i = 0; i < _listValue.size(); i++) {
                    psmt.setString(i + 1, _listValue.get(i));
                }
            }// End IF if(!(_listValue.isEmpty()))

        }catch (SQLException sqlE){

        }catch (Exception e){

        }

        return psmt;
    }


    /**
     * to recive the SQL and value then proccess to feach the result.
     * @param _strSQL
     * @param _ListOfValues
     * @return
     */
    public ArrayList<ArrayList<String>> getData(String _strSQL, ArrayList<String> _ListOfValues ){ // TODO we need to add the String and arraylist with passing value.

        // to hoald all reset from query in 2d arralist include the columns name for the first arra
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        // to hold the resutl from table and add it to the 2D array.
        ArrayList<String> result = new ArrayList<String>();

        PreparedStatement psmt = null;
        ResultSet rs = null;

        try {
            psmt= prepare(_strSQL, _ListOfValues);
            rs = psmt.executeQuery();
            if(rs.isBeforeFirst()){
            ResultSetMetaData rsmd=rs.getMetaData();

               int colCount= rsmd.getColumnCount();
                for(int i=1;i<colCount;i++){
                    result.add(rsmd.getColumnName(i).toString());
                }

                results.add(result); // add the column name to the value.

                while (rs.next()) {
                    result = new ArrayList<String>();
                    for (int column = 1; column <= colCount; column++) {
                        result.add(rs.getString(column));
                    }
                    results.add(result);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    /**
     * to set for update delete insert.
     * @param _strSQL
     * @param _values
     * @return
     */
    public boolean setData(String _strSQL, ArrayList<String> _values) { // TODO add the coustome exception in this part

        boolean queryStatuse = false;
        int affectedRows = 0;

        try {
            PreparedStatement prs = prepare(_strSQL, _values);
            Statement statement = conn.createStatement();
            affectedRows = prs.executeUpdate();

            if (affectedRows > 0) {
                queryStatuse = true;
            } else queryStatuse = false;


        } catch (SQLException e) {// TODO add the coustome exception in this part
            e.printStackTrace();

        }
        return  queryStatuse;
    }




    public static void main(String[] args) {
        DatabaseLayer ts = new DatabaseLayer();
        ts.getConnected();




        Person person = new Person();
        person.setPaperId(1);
        person.setCommentId(1);
        person.setKeyword("database");
        System.out.println(person.viewPaper());
        System.out.println(person.viewComments());
        System.out.println(person.showPapers());



        System.out.println("Insering comment");
        Student st = new Student();
        st.setPaperId(2);
        st.setPersonId(6);
        st.setComment("coment Num 6");
        System.out.println(st.insertComment());

        /* to read eliment from 2D array */

        String sql= "SELECT * FROM 484PROJECT.papers; ";

        ArrayList<String> valueList= new ArrayList<String>();
        ArrayList<ArrayList<String>> result = ts.getData(sql, valueList);
        System.out.println(result);

        for(ArrayList<String> ar: result){
            System.out.println( "first array "+ ar);
            int i=0;
            for(String str:ar){
                System.out.println("interrier array "+ar.get(i));
                i++;
            }
        }







        //insert INTO `484PROJECT`.`student` (`fName`, `lName`, `psswordk`) VALUES ('b1', 'm1', '123');
//        sql = "INSERT INTO `484PROJECT`.`student` ( `fName`, `lName`, `psswordk`, `email`)" +
//                " VALUES ( ?, ?, ?, ?);";
//        valueList.add("Bandar02");
//        valueList.add("Madani02");
//        valueList.add("123");
//        valueList.add("bhm9041@rit.edu");

//        boolean resutlStatuse = ts.setData(sql,valueList);
//
//        System.out.println("the Update is: "+resutlStatuse);


    }

}
