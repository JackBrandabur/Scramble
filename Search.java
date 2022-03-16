import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Search {
	public static void main (String[] args) {
		ArrayList<String> recipes = search("French Toast", false);
		System.out.println(recipes.toString());
	} 
	
	public static ArrayList <String> search(String item, boolean ingredient) {
		ArrayList <String> recipes = new ArrayList<String>();
		item = item.toLowerCase();
		try {
			Scanner fileReader = new Scanner(new File("Recipes.txt"));
			if (ingredient) {
				/*item = item.toLowerCase();
				while(fileReader.hasNextLine()) {
					String str1 = fileReader.nextLine();
					while (fileReader.hasNextLine()) {
						if (fileReader.nextLine().equals("Ingredients:")) {
							String line  = fileReader.nextLine();
							while (!(line.contains(item)) && !(line.equals("Directions:"))) {
								if (fileReader.hasNextLine()) {
									line = fileReader.nextLine();
								}	
							}
							if (line.contains(item)) {
								recipes.add(str1);
							}
						}
						
					}
				}
				
				
				while(fileReader.hasNextLine() && !(fileReader.nextLine().equals("Ingredients:"))) {
					//fileReader.nextLine();
					//System.out.println(fileReader.nextLine());
				}
				while(fileReader.hasNextLine() && !(fileReader.nextLine().equals("Directions:"))) {
					if (fileReader.nextLine().toLowerCase().contains(item)) {
						recipes.add(str1);
					}
				}
				while(fileReader.hasNextLine()) {
					fileReader.nextLine();
					if (fileReader.nextLine().equals("")) {
						String str2 = fileReader.nextLine();
						str2 = str2.toLowerCase();
						while(fileReader.hasNextLine() && !(fileReader.nextLine().equals("Ingredients:"))) {
							fileReader.nextLine();
							
						}
						while(fileReader.hasNextLine() && !(fileReader.nextLine().equals("Directions:"))) {
							if (fileReader.nextLine().toLowerCase().contains(item)) {
								recipes.add(str2);
								//System.out.println("test");
							}
						}
						
					}
				}*/
			} else {
				String str1 = fileReader.nextLine();
				//System.out.println(str1);
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
				//System.out.println(line);
				//if (recipes.toString().contains("Mac and Cheese")) {
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
		//System.out.println(recipeSteps.toString());
		return recipeSteps;
	}
}
