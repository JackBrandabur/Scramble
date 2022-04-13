import java.io.File;
import java.sql.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

//Terminal command to access database /usr/local/mysql/bin/mysql -u root -p

public class Search {
	public static void main (String[] args) {
		ArrayList <String> ingredients = new ArrayList<String>();
		//ingredients.add("milk");
		//ingredients.add("salt");
		//search("", 1, ingredients);
		//dBConnect("", 3, ingredients);
	}
	
	public static void dBConnect(String item, int filter, ArrayList <String> ingredients) {
		File recipesFile = new File("Recipes.txt");
		try {
			FileWriter fileWriter = new FileWriter(recipesFile, true);
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Scramble", "root", "admin123");
			Statement mystmt = myConn.createStatement();
			if (filter == 1) {
				ResultSet myRs = mystmt.executeQuery("SELECT *, LENGTH(Ingredients) - LENGTH(REPLACE(Ingredients, '\\n', '')) as Count\n"
						+ "FROM Recipes\n"
						+ "ORDER BY Count ASC");
				while (myRs.next()) {
					boolean add = false;
					int count = 0;
					for (int i = 0; i < ingredients.size(); i++) {
						if (myRs.getString("Ingredients").toLowerCase().contains(ingredients.get(i).toLowerCase())) {
							count++;
						}
					}
					if (ingredients.size() == count) add = true;
					if (add && myRs.getString("RecipeName").toLowerCase().contains(item.toLowerCase())) {
						fileWriter.write(myRs.getString("RecipeName") + "\n" + "Servings: " +  myRs.getString("Servings") + "\n" + "Time: " + myRs.getString("PrepTime")
						+ "\n" + myRs.getString("Ingredients") + "\n" + myRs.getString("Directions") + "\n" + myRs.getString("Nutrition") + "\n" 
							+ myRs.getString("Source") + "\n" + "\n");
					}	
				}
			} else if (filter == 2) {
				ResultSet myRs = mystmt.executeQuery("select * from Recipes Order by PrepTime ASC");
				while (myRs.next()) {
					boolean add = false;
					int count = 0;
					for (int i = 0; i < ingredients.size(); i++) {
						if (myRs.getString("Ingredients").toLowerCase().contains(ingredients.get(i).toLowerCase())) {
							count++;
						}
					}
					if (ingredients.size() == count) add = true;
					if (add && myRs.getString("RecipeName").toLowerCase().contains(item.toLowerCase())) {
						fileWriter.write(myRs.getString("RecipeName") + "\n" + "Servings: " +  myRs.getString("Servings") + "\n" + "Time: " + myRs.getString("PrepTime")
						+ "\n" + myRs.getString("Ingredients") + "\n" + myRs.getString("Directions") + "\n" + myRs.getString("Nutrition") + "\n" 
							+ myRs.getString("Source") + "\n" + "\n");
					}	
				}
			} else {
				ResultSet myRs = mystmt.executeQuery("select * from Recipes");
				while (myRs.next()) {
					boolean add = false;
					int count = 0;
					for (int i = 0; i < ingredients.size(); i++) {
						if (myRs.getString("Ingredients").toLowerCase().contains(ingredients.get(i).toLowerCase())) {
							count++;
						}
					}
					if (ingredients.size() == count) add = true;
					if (add && myRs.getString("RecipeName").toLowerCase().contains(item.toLowerCase())) {
						fileWriter.write(myRs.getString("RecipeName") + "\n" + "Servings: " +  myRs.getString("Servings") + "\n" + "Time: " + myRs.getString("PrepTime")
						+ "\n" + myRs.getString("Ingredients") + "\n" + myRs.getString("Directions") + "\n" + myRs.getString("Nutrition") + "\n" 
							+ myRs.getString("Source") + "\n" + "\n");
					}	
				}
			}
			fileWriter.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static ArrayList <String> search(String item, int filter, ArrayList <String> ingredients) {
		dBConnect(item, filter, ingredients);
		ArrayList <String> recipeSteps = new ArrayList<String>();
		Scanner fReader;
		try {
			File recipeFile = new File("Recipes.txt");
			fReader = new Scanner(recipeFile);
			while (fReader.hasNextLine()) {
				recipeSteps.add(fReader.nextLine());
			}
			fReader.close();
			recipeFile.delete();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error in ending");
		}
		System.out.println(recipeSteps.toString());
		return recipeSteps;
	}
}

//public static ArrayList <String> search(String item, boolean ingredient) {
/*ArrayList <String> recipes = new ArrayList<String>();
try {
	Scanner fileReader = new Scanner(new File("Recipes.txt"));
	if (filter == 1) {
		
	} else {
		String str1 = fileReader.nextLine();
		if (str1.substring(0,str1.length() - 2).equalsIgnoreCase(item)) {
			recipes.add(str1);
		}
		while (fileReader.hasNextLine()) {
			if (fileReader.nextLine().equals("")) {
				if (fileReader.hasNextLine()) {
					String str2 = fileReader.nextLine();
					if (str2.substring(0,str2.length() - 2).equalsIgnoreCase(item)) {
						recipes.add(str2);
					}
				}
			}
		}
	}
	fileReader.close();
	//Delete File somehow
} catch (FileNotFoundException e) {
	System.out.println("Error");
	e.printStackTrace();
}
ArrayList <String> recipeSteps = new ArrayList<String>();
Scanner fReader;
try {
	fReader = new Scanner(new File("Recipes.txt"));
	while (fReader.hasNextLine()) {
		String line = fReader.nextLine();
		if (line.toLowerCase().contains(item)) {
			recipeSteps.add(line);
			if (fReader.hasNextLine()) {
				line = fReader.nextLine();
				while(!(line.equals("")) && fReader.hasNextLine()) {
					recipeSteps.add(line);
					line = fReader.nextLine();
				}
			}
			if (line.equals("")) {
				break;
			}
		}
	}
} catch (FileNotFoundException e) {
	e.printStackTrace();
	System.out.println("Error in ending");
}
//System.out.println(recipes.toString());
System.out.println(recipeSteps.toString());*/
