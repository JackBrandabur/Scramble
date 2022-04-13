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
		/*userName = userName.toLowerCase();
		try {
			Scanner fileReader = new Scanner(new File("UserInfo.txt"));
			while (fileReader.hasNextLine()) {
				if (fileReader.nextLine().equals(userName + " " + password)) {
					return true;
				}
			}
			System.out.println("Username or password incorrect.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;*/
		userName = userName.toLowerCase();
		Connection myConn;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Scramble", "root", "admin123");
			Statement mystmt = myConn.createStatement();
			ResultSet myRs = mystmt.executeQuery("select * from Users where UserName = '" + userName + "' and password = '" + password + "'");
			if(!(myRs.toString().equals(""))) {
				return true;
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
		/*try {
			Scanner fileReader = new Scanner(new File("UserInfo.txt"));
			while (fileReader.hasNextLine()) {
				if (fileReader.nextLine().equals(userName + " " + password)) {
					System.out.println("Account already exists");
					return false;
				}
			}
		} catch (FileNotFoundException e) {
			File userInfo = new File("UserInfo.txt");
		}
		try {
			FileWriter fileWriter = new FileWriter("UserInfo.txt", true);
			fileWriter.write(userName + " " + password + System.lineSeparator());
			fileWriter.close();
		} catch (IOException e) {
			System.out.println("Error occured trying to write to file");
			return false;
		}
		
		return true;*/
	}
}
