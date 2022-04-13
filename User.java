import java.util.Scanner;
import java.sql.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class User {
	//public static void main (String[] args) {
		//createAccount("Admin","123");
		//System.out.println(login("Admin", "123"));
	//}
	
	public static boolean login(String userName, String password) {
		userName = userName.toLowerCase();
		Connection myConn;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Scramble", "root", "admin123");
			Statement mystmt = myConn.createStatement();
			ResultSet myRs = mystmt.executeQuery("Select * from Users");
			while (myRs.next()) {
				if (myRs.getString("Username").equals(userName) && myRs.getString("password").equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean createAccount(String userName, String password) {
		userName = userName.toLowerCase();
		Connection myConn;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Scramble", "root", "admin123");
			Statement mystmt = myConn.createStatement();
			ResultSet myRs = mystmt.executeQuery("select * from Users where UserName = '" + userName + "' and password = '" + password + "'");
			if(myRs.getFetchSize() == 0) {
				mystmt.executeUpdate("insert into Users (UserName, Password) Values ('" + userName + "', '" + password + "')");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
