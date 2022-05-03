import java.io.File;
import java.sql.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
//Terminal command to access database /usr/local/mysql/bin/mysql -u root -p
//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

/**
 * The Class Search.
 */
public class Search {
	
	/**
	 * D B connect.
	 *
	 * @param item the item
	 * @param filter the filter
	 * @param ingredients the ingredients
	 */
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
	
	/**
	 * Search.
	 *
	 * @param item the item
	 * @param filter the filter
	 * @param ingredients the ingredients
	 * @return the array list
	 */
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
		return recipeSteps;
	}
}

