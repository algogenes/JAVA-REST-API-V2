package knew.newnew;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import org.json.JSONObject;

public class AccessDB {
	Connection conn = null;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3308/restapi";
   
    /**
     * @param args the command line arguments
     * @throws ClassNotFoundException 
     */
    
    public int getLastId() throws ClassNotFoundException {
    	int getId = 0;
    	try{
            // Step 1: Allocate a database 'Connection' object
           	
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected");
            Statement stmt = conn.createStatement();
            String strSelect = "select userId, getID from userdata order by 1 desc limit 1;";
            System.out.println("The SQL statement is: " + strSelect + "\n");  // Echo for debugging
            ResultSet rset = stmt.executeQuery(strSelect);
            int rowCount = 0;
            
            while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                getId = rset.getInt("getID");
                int userId = rset.getInt("userId");
                System.out.println("getId" + getId);
                System.out.println("userId" + userId);
                ++rowCount;
            }
            }
           catch(SQLException ex) {
            ex.printStackTrace();
         } 
    	
		return getId;
		
    }
    
    public int manageUser(String user, String password){
        int valid = 0;
        try{
        	
        	//Class.forName("com.mysql.jdbc.Driver");
        	
         // Step 1: Allocate a database 'Connection' object
         conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
         System.out.println("Connected");
         
         Statement stmt = conn.createStatement();
            String USER = "";
            String PASSWORD = "";
            String test = "";
            int rowCount = 0;
           
            String strSelect = "select password from users where username = \'"+user+"\'";
            //System.out.println("The SQL statement is: " + strSelect + "\n"); // Echo For debugging
            ResultSet rset = stmt.executeQuery(strSelect);

            if (rset.next() == false) {
                System.out.println("Access denied, user doesnt exist");
                } 
             else {
                do {
                PASSWORD = rset.getString("password");
                } while (rset.next());
            
            if(password.equalsIgnoreCase(PASSWORD)){
                valid = 1;
            }
            else{
                valid = 0;
            }
            }
         
         }
        catch(SQLException ex) {
         ex.printStackTrace();
      } 
        return valid;
    }
    
    public void addPerson(String NAME, String SPORT, int AGE, int ID) throws ClassNotFoundException {
    	
    	AccessDB obj2 = new AccessDB();
    	ID = obj2.getLastId() + 1;
    	System.out.println("After getLastID method new GetID is " + ID);
        try{
         // Step 1: Allocate a database 'Connection' object
        	
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
         System.out.println("Connected");
         Statement stmt = conn.createStatement();
         String sqlInsert = "insert into userdata (name, sport, age, getID) VALUES(\'"+NAME+"\',\'"+SPORT+"\', \'"+AGE+"\', \'"+ID+"\');";
         System.out.println("The SQL statement is: " + sqlInsert + "\n");  // Echo for debugging
         int countInserted = stmt.executeUpdate(sqlInsert);
         System.out.println(countInserted + " records inserted.\n");
         }
        catch(SQLException ex) {
         ex.printStackTrace();
      } 
    // code to be executed
  }
    
    public void updatePerson(int Id, Scanner inputObj) {
        try{
         // Step 1: Allocate a database 'Connection' object
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected");
            
            Statement stmt = conn.createStatement();
            int rowCount = 0;
            int ID;
            String SURNAME = "";
            String FIRSTNAME = "";
            String DOB = "";
            String EMAIL = "";
            String MOBILE_NO = "";
            String test = "";
            String strSelect = "select ID, SURNAME, FIRSTNAME, DOB, EMAIL, MOBILE_NO from person where ID = \'"+Id+"\'";
            System.out.println("The SQL statement is: " + strSelect + "\n"); // Echo For debugging
            ResultSet rset = stmt.executeQuery(strSelect);
            
             if (rset.next() == false) {
                System.out.println("Record with ID " + Id + " doesnt exist");
                } 
             else {
                do {
                ID = rset.getInt("ID");
                SURNAME = rset.getString("SURNAME");
                FIRSTNAME = rset.getString("FIRSTNAME");
                DOB = rset.getString("DOB");
                EMAIL = rset.getString("EMAIL");
                MOBILE_NO = rset.getString("MOBILE_NO");
                System.out.println("ID, \t SURNAME, \t FIRSTNAME, \t DOB, \t EMAIL, \t MOBILE_NO ");
                System.out.println(ID + ",\t " + SURNAME + ",\t " + FIRSTNAME + ",\t " + DOB + ",\t " + EMAIL + ",\t " + MOBILE_NO);
                ++rowCount;
                } while (rset.next());
                
            inputObj.nextLine();
            System.out.println("Enter surname or press \"n\" to skip");
            test = inputObj.nextLine();
            if(test.equalsIgnoreCase("n")){
            }
            else{
                SURNAME = test;
            }
            System.out.println("Enter FIRSTNAME or press \"n\" to skip");
            test = inputObj.nextLine();
            if(test.equalsIgnoreCase("n")){
            }
            else{
                FIRSTNAME = test;
            }
            System.out.println("Enter DOB or press \"n\" to skip");
            test = inputObj.nextLine();
            if(test.equalsIgnoreCase("n")){
            }
            else{
                DOB = test;
            }
            System.out.println("Enter EMAIL or press \"n\" to skip");
            test = inputObj.nextLine();
            if(test.equalsIgnoreCase("n")){
            }
            else{
                EMAIL = test;
            }
            System.out.println("Enter MOBILE_NO or press \"n\" to skip");
            test = inputObj.nextLine();
            if(test.equalsIgnoreCase("n")){
            }
            else{
                MOBILE_NO = test;
            }
         String strUpdate = "update person set SURNAME = \'"+SURNAME+"\', FIRSTNAME = \'"+FIRSTNAME+"\', DOB = \'"+DOB+"\', EMAIL = \'"+EMAIL+"\', MOBILE_NO = \'"+MOBILE_NO+"\' where ID = \'"+Id+"\'";
         System.out.println("The SQL statement is: " + strUpdate + "\n");  // Echo for debugging
         int countUpdated = stmt.executeUpdate(strUpdate);
         System.out.println(countUpdated + " records affected.\n");
         }
            }
            
        catch(SQLException ex) {
         ex.printStackTrace();
        }  
         // Step 5: Close conn and stmt - Done automatically by try-with-resources
    // code to be executed
        }
    
    public void removePerson(int Id, Scanner inputObj){
        try{
            // Step 1: Allocate a database 'Connection' object
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected");
            Statement stmt = conn.createStatement();
            int rowCount = 0;
            int ID;
            String SURNAME = "";
            String FIRSTNAME = "";
            String DOB = "";
            String EMAIL = "";
            String MOBILE_NO = "";
            int delete = 0;
            String strSelect = "select ID, SURNAME, FIRSTNAME, DOB, EMAIL, MOBILE_NO from person where ID = \'"+Id+"\'";
            System.out.println("The SQL statement is: " + strSelect + "\n"); // Echo For debugging
            ResultSet rset = stmt.executeQuery(strSelect);
            
             if (rset.next() == false) {
                System.out.println("Record with ID " + Id + " doesnt exist");
                } 
             else {
                do {
                ID = rset.getInt("ID");
                SURNAME = rset.getString("SURNAME");
                FIRSTNAME = rset.getString("FIRSTNAME");
                DOB = rset.getString("DOB");
                EMAIL = rset.getString("EMAIL");
                MOBILE_NO = rset.getString("MOBILE_NO");
                System.out.println("ID, \t SURNAME, \t FIRSTNAME, \t DOB, \t EMAIL, \t MOBILE_NO ");
                System.out.println(ID + ",\t " + SURNAME + ",\t " + FIRSTNAME + ",\t " + DOB + ",\t " + EMAIL + ",\t " + MOBILE_NO);
                ++rowCount;
                } while (rset.next());
            
            System.out.println("Are you sure you want to delete this record, enter 1 to proceed and 2 to cancel");
            delete = inputObj.nextInt();
            if(delete == 1){
                String sqlDelete = "delete from person where ID = \'"+Id+"\'";
                System.out.println("The SQL statement is: " + sqlDelete + "\n");  // Echo for debugging
                int countDeleted = stmt.executeUpdate(sqlDelete);
                System.out.println(countDeleted + " records deleted.\n");
            }
            else{
                System.out.println("Cancelling delete operation");  //
            }
         }
        }
        catch(SQLException ex) {
         ex.printStackTrace();
      } 
    }
    
    public void getPerson() throws ClassNotFoundException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected");
            Statement stmt = conn.createStatement();
            String strSelect = "select ID, SURNAME, FIRSTNAME, DOB, EMAIL, MOBILE_NO from person";
            System.out.println("The SQL statement is: " + strSelect + "\n"); // Echo For debugging
            ResultSet rset = stmt.executeQuery(strSelect);
            int rowCount = 0;
            System.out.println("ID, \t SURNAME, \t FIRSTNAME, \t DOB, \t EMAIL, \t MOBILE_NO ");
            while(rset.next()) {   // Move the cursor to the next row, return false if no more row
            int ID = rset.getInt("ID");
            String SURNAME = rset.getString("SURNAME");
            String FIRSTNAME = rset.getString("FIRSTNAME");
            String DOB = rset.getString("DOB");
            String EMAIL = rset.getString("EMAIL");
            String MOBILE_NO = rset.getString("MOBILE_NO");
            System.out.println(ID + ",\t " + SURNAME + ",\t " + FIRSTNAME + ",\t " + DOB + ",\t " + EMAIL + ",\t " + MOBILE_NO);
            ++rowCount;
         }
        }
        catch(SQLException e){
            System.err.println(e);
        }
    // code to be executed
  }
    
    public String getPersonB(int ID) throws ClassNotFoundException {
    	String newData = "";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           
            JSONObject data = new JSONObject();
            
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected");
            Statement stmt = conn.createStatement();
            String strSelect = "select name, sport, age, getID from userdata where getID = \'"+ID+"\'";
            System.out.println("The SQL statement is: " + strSelect + "\n"); // Echo For debugging
            ResultSet rset = stmt.executeQuery(strSelect);
            int rowCount = 0;
             
            System.out.println("name, \t sport, \t age, \t getID");
                 
                 if (rset.next()) {
                	 
                	 do {
                	 //while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                         String NAME = rset.getString("name");
                         String SPORT = rset.getString("sport");
                         int age = rset.getInt("age");
                         int getId = rset.getInt("getID");
                         System.out.println(ID + ",\t " + NAME + ",\t " + SPORT + ",\t " + age + ",\t " + getId);
                         ++rowCount;
                         
                         data.put("mName", NAME);
                         data.put("mAge", age);
                         data.put("mSport", SPORT);
                         data.put("mGetId", getId);
                         
                          newData = data.toString();
                	 }
                         while(rset.next());	 
                	} else {
                		newData = "No results found";
                	}
        }
        catch(SQLException e){
            System.err.println(e);
        }
        
        return newData;
    // code to be executed
  }
    
    public static void main(String[] args) throws ClassNotFoundException {
            //Class.forName("com.mysql.jdbc.Driver");
            Scanner inputObj = new Scanner(System.in);
            AccessDB myObj = new AccessDB();
            int validUser = 0;
            int input;
            String surname;
            String firstname;
            String dob;
            String email;
            String mobile_no;
            int Id;
            String username;
            String password;
            
            System.out.println("Please enter your username\n");
            username = inputObj.nextLine();
            System.out.println("Please enter your password \n");
            password = inputObj.nextLine();
            
            validUser = myObj.manageUser(username, password);
            if(validUser == 1){
                do{
              System.out.println("Hi this is a simple DB application in JAVA \n");
              System.out.println("Please choose your preferred action \n");
              System.out.println("1: VIEW RECORD(S): ");
              System.out.println("2: UPDATE RECORD: ");
              System.out.println("3: DELETE RECORD: ");
              System.out.println("4: ADD RECORD: ");
              System.out.println("5: EXIT: ");
              input = inputObj.nextInt();
          
              switch(input){
              case 1: System.out.println("Your option is VIEW RECORD");
                      myObj.getPerson();
              break;
              case 2: System.out.println("Your option is UPDATE RECORD");
                      System.out.println("Please enter ID of record to update");
                      Id = inputObj.nextInt();
                      myObj.updatePerson(Id, inputObj);
              break;
              case 3: System.out.println("Your option is DELETE RECORD");
                      System.out.println("Please enter ID of record to delete");
                      Id = inputObj.nextInt();
                      myObj.removePerson(Id, inputObj);
              break;
              case 4: System.out.println("Your option is ADD RECORD");
                      System.out.println("ENTER SURNAME");
                      inputObj.nextLine();
                      surname = inputObj.nextLine();
                      System.out.println(surname);
                      System.out.println("ENTER FIRSTNAME \n");
                      firstname = inputObj.nextLine();
                      System.out.println("ENTER DATE OF BIRTH E.G 2000-O2-01 \n");
                      dob = inputObj.nextLine();
                      System.out.println("ENTER EMAIL \n");
                      email = inputObj.nextLine();
                      System.out.println("ENTER PHONE NUMBER \n");
                      mobile_no = inputObj.nextLine();
                      //myObj.addPerson(surname, firstname, dob, email, mobile_no);
              break;
              case 5: System.out.println("The program will exit");
              break;
              default:System.out.println("The selected option is invalid, please try again");
          }   
          }
          while(input!=5);
            }
            else{
                System.out.println("Sorry you cant use this system, access denied \n");
            }
            
          
        // TODO code application logic here
    }
}
