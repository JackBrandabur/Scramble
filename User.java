import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class User {
//	public static void main (String[] args) {
//		createAccount("Brandajj@miamioh,edu","testPassword");
//		System.out.println(login("Brandajj@miamioh.edu", "testPassword"));
//	}
	
	public static boolean login(String userName, String password) {
		userName = userName.toLowerCase();
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
		return false;
	}
	
	public static boolean createAccount(String userName, String password) {
		userName = userName.toLowerCase();
		try {
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
		
		return true;
	}
}
