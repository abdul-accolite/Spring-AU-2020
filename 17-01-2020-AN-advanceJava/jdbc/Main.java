 package jdbc;

/*procedure in sql.
 * CREATE DEFINER=`root`@`localhost` PROCEDURE `new_procedure`()
	 BEGIN
	 	select * from employee inner join programmer on employee.id=programmer.id; 
	 END
*/
/*
 * 
create database assignment;
use assignment;
create table employee(id INT NOT NULL PRIMARY KEY, nameEmp varchar(15), age int);
insert into employee values(1,"abdul",21);
insert into employee values(2,"ebdul",23);
insert into employee values(3,"dbdul",24);
insert into employee values(4,"asd",25);
insert into employee values(5,"er",26);
insert into employee values(6,"bve",27);
insert into employee values(7,"jtd",28);
insert into employee values(8,"seg",29);
create table programmer(id INT NOT NULL PRIMARY KEY, nameProg varchar(15), project varchar(15));
insert into programmer values(1,"abdul","morgan");
insert into programmer values(2,"ebdul","intern");
insert into programmer values(3,"dbdul","morgan");
insert into programmer values(4,"asd","stanley");
insert into programmer values(5,"er","ms");
insert into programmer values(6,"bve","fed");
insert into programmer values(7,"jtd","ex");
insert into programmer values(8,"seg","couch");
CALL new_procedure();

*/
import java.sql.*;

public class Main {

	public static void main(String[] args) {		
		try {
			
			Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/assignment","root","hfsqs15786");
			
		
			Statement myStmt = myConn.createStatement();
			 
	
			ResultSet result = myStmt.executeQuery("CALL new_procedure();");
			
			
			
			
			
			while (result.next()) {
				String string1 = result.getString("id");
				String string2 = result.getString("nameProg"); 
				String string3 = result.getString("project");
				System.out.println(string1 + ", " + string2+" ,"+string3);
				
				
				
			}
			
			myConn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
