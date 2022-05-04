import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RecipeScraper {
	public static Set<String> set = new HashSet<String>();
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		/*try {
			final Document document = Jsoup.connect("https://www.allrecipes.com/").get();
			Elements links = document.select("a[href]");
			for (Element link : links) {
			    String linkHref = link.attr("href");
			    if(linkHref.contains("https://www.allrecipes.com/recipe/")){
			        set.add(linkHref);
			    }
		    }
			System.out.println(set.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			final Document document = Jsoup.connect("https://www.allrecipes.com/recipes/80/main-dish/").get();
			Elements links = document.select("a[href]");
			for (Element link : links) {
			    String linkHref = link.attr("href");
			    if(linkHref.contains("https://www.allrecipes.com/recipe/")){
			        set.add(linkHref);
			    }
		    }
			System.out.println(set.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			final Document document = Jsoup.connect("https://www.allrecipes.com/recipes/78/breakfast-and-brunch/").get();
			Elements links = document.select("a[href]");
			//Set<String> set = new HashSet<String>();
			for (Element link : links) {
			    String linkHref = link.attr("href");
			    if(linkHref.contains("https://www.allrecipes.com/recipe/")){
			        set.add(linkHref);
			    }
		    }
			System.out.println(set.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			final Document document = Jsoup.connect("https://www.allrecipes.com/recipes/17561/lunch/").get();
			Elements links = document.select("a[href]");
			//Set<String> set = new HashSet<String>();
			for (Element link : links) {
			    String linkHref = link.attr("href");
			    if(linkHref.contains("https://www.allrecipes.com/recipe/")){
			        set.add(linkHref);
			    }
		    }
			System.out.println(set.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			final Document document = Jsoup.connect("https://www.allrecipes.com/recipes/17562/dinner/").get();
			Elements links = document.select("a[href]");
			//Set<String> set = new HashSet<String>();
			for (Element link : links) {
			    String linkHref = link.attr("href");
			    if(linkHref.contains("https://www.allrecipes.com/recipe/")){
			        set.add(linkHref);
			    }
		    }
			System.out.println(set.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			final Document document = Jsoup.connect("https://www.allrecipes.com/recipes/76/appetizers-and-snacks/").get();
			Elements links = document.select("a[href]");
			//Set<String> set = new HashSet<String>();
			for (Element link : links) {
			    String linkHref = link.attr("href");
			    if(linkHref.contains("https://www.allrecipes.com/recipe/")){
			        set.add(linkHref);
			    }
		    }
			System.out.println(set.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			final Document document = Jsoup.connect("https://www.allrecipes.com/recipes/156/bread/").get();
			Elements links = document.select("a[href]");
			//Set<String> set = new HashSet<String>();
			for (Element link : links) {
			    String linkHref = link.attr("href");
			    if(linkHref.contains("https://www.allrecipes.com/recipe/")){
			        set.add(linkHref);
			    }
		    }
			System.out.println(set.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			final Document document = Jsoup.connect("https://www.allrecipes.com/recipes/79/desserts/").get();
			Elements links = document.select("a[href]");
			//Set<String> set = new HashSet<String>();
			for (Element link : links) {
			    String linkHref = link.attr("href");
			    if(linkHref.contains("https://www.allrecipes.com/recipe/")){
			        set.add(linkHref);
			    }
		    }
			System.out.println(set.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			final Document document = Jsoup.connect("https://www.allrecipes.com/recipes/253/everyday-cooking/slow-cooker/").get();
			Elements links = document.select("a[href]");
			//Set<String> set = new HashSet<String>();
			for (Element link : links) {
			    String linkHref = link.attr("href");
			    if(linkHref.contains("https://www.allrecipes.com/recipe/")){
			        set.add(linkHref);
			    }
		    }
			System.out.println(set.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
			final Document document = Jsoup.connect("https://www.allrecipes.com/recipes/235/world-cuisine/middle-eastern/").get();
			Elements links = document.select("a[href]");
			//Set<String> set = new HashSet<String>();
			for (Element link : links) {
			    String linkHref = link.attr("href");
			    if(linkHref.contains("https://www.allrecipes.com/recipe/")){
			        set.add(linkHref);
			    }
		    }
			System.out.println(set.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Object[] links = set.toArray();
			int counterLinks = 0;
			for (int j = 0; j < links.length; j++) {
				final Document document = Jsoup.connect(links[j].toString()).get();
				Elements recipes = document.getElementsByTag("script");
				for (Element recipe : recipes) {
					String s = recipe.toString();
					String[] stringArr = s.split("\n");
					String[] recipeArr = new String[7];
					for (int i = 0; i < stringArr.length; i++) {
						if (stringArr[i].contains("prepTime")) {
							while(!stringArr[i].contains("review") && i < stringArr.length - 1) {
								//Name Servings PrepTime Ingredients Directions Nutrition Source
								if (stringArr[i].contains("\"itemReviewed\":")) {
									recipeArr[0] = stringArr[i];
								}
								if (stringArr[i].contains("\"recipeYield\":")) {
									recipeArr[1] = stringArr[i].trim();;
								}
								if (stringArr[i].contains("totalTime")) {
									recipeArr[2] = stringArr[i];
								}
								if (stringArr[i].contains("\"recipeIngredient\": [")) {
									while (!stringArr[i].contains("]")) {
										i++;
										recipeArr[3] += stringArr[i].substring(0, stringArr[i].length() - 1) + "\n";
									}
								}
								if (stringArr[i].contains("\"recipeInstructions\": [")) {
									while (!stringArr[i].contains("]")) {
										i++;
										recipeArr[4] += stringArr[i];
									}
								}
								if (stringArr[i].contains("\"NutritionInformation\"")) {
									while (!stringArr[i].contains("proteinContent")) {
										i++;
										recipeArr[5] += stringArr[i];
									}
								}
								i++;
							}
							recipeArr[6] = links[j].toString();
							/*System.out.println("-----------------------------------------------------------" + counterLinks++);
							System.out.println(recipeArr[0]);
							System.out.println(recipeArr[1]);
							System.out.println(recipeArr[2]);
							System.out.println(recipeArr[3]);
							System.out.println(recipeArr[4]);
							System.out.println(recipeArr[5]);
							System.out.println(recipeArr[6]);*/
							dBConnect(recipeCompiler(recipeArr));
						}
					}
			    }
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static String[] recipeCompiler(String[] recipes) {
		int step = 2;
		recipes[0] = recipes[0].substring(recipes[0].indexOf(":") + 3, recipes[0].length()-2);
		System.out.println(recipes[0]);
		
		if(recipes[1] == null) {
			recipes[1] = "" + 1;
		} else {
			recipes[1] = recipes[1].substring(recipes[1].indexOf(":") + 3, recipes[1].indexOf(":") + 5).trim();
		}
		recipes[1] = "" + (int)Double.parseDouble(recipes[1]);
		System.out.println(recipes[1]);
		if(recipes[2].contains("null")) {
			recipes[2] = "" + 20;
		} else {
			int minutes = Integer.parseInt(recipes[2].substring(recipes[2].indexOf("H") + 1, recipes[2].length() - 3).trim());
			int hours = Integer.parseInt(recipes[2].substring(recipes[2].lastIndexOf("T") + 1, recipes[2].indexOf("H")).trim());
			int totalTime = hours * 60 + minutes;
			recipes[2] = "" + totalTime;
		}
		System.out.println(recipes[2]);
		
		recipes[3] = recipes[3].substring(4, recipes[3].indexOf("]") - 1).trim();
		recipes[3] = recipes[3].replace("\"", "");
		String[] lines = recipes[3].split("\n");
		String result = "";
		for (int i = 0; i < lines.length; i++) {
			lines[i] = lines[i].replaceAll("\\s{2,}", " ").trim();
			result += lines[i] + "\n";
		}
		recipes[3] = "Ingredients: " + "\n" + result;
		System.out.println(recipes[3]);
		
		recipes[4] = recipes[4].substring(recipes[4].indexOf("x") + 5, recipes[4].lastIndexOf("}")).trim();
		recipes[4] = recipes[4].replace("\"", "");
		while(recipes[4].contains("\\n        },        {          @type: HowToStep,          text:")) {
			recipes[4] = recipes[4].substring(0,recipes[4].indexOf("\\")) 
					+ recipes[4].substring(recipes[4].indexOf("\\") + 63, recipes[4].length());
		}
		recipes[4] = recipes[4].replace("\\n", "");
		recipes[4] = "Directions:" + "\n" + "1) " + recipes[4];
		for (int i = 0; i < recipes[4].length() - 1; i++) {
			if (recipes[4].charAt(i) == '.') {
				recipes[4] = recipes[4].substring(0, i) + "\n" + step + ")"
						+ recipes[4].substring(i + 1, recipes[4].length());
				step++;
			}
		}
		System.out.println(recipes[4]);
		
		recipes[5] = recipes[5].replace("\"", "");
		recipes[5] = recipes[5].replace("Content", "");
		recipes[5] = recipes[5].replace(",        ", "; ");
		recipes[5] = recipes[5].substring(recipes[5].indexOf("c"), recipes[5].lastIndexOf(",") - 1);
		System.out.println(recipes[5]);
		System.out.println(recipes[6]);
		return recipes;
	}
	
	public static boolean dBConnect(String[] recipes) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Scramble", "root", "admin123");
			Statement mystmt = myConn.createStatement();
			int serving = Integer.parseInt(recipes[1]);
			int prepTime = Integer.parseInt(recipes[2]);
			ResultSet myRs = mystmt.executeQuery("select * from Recipes Order by RecipeID DESC");
			myRs.next();
			int recipeID1 = myRs.getInt("RecipeID");
			ResultSet myRs2 = mystmt.executeQuery("select * from UserRecipes Order by RecipeID DESC");
			
			int recipeID = -1;
			if (myRs2.next()) {
				if (recipeID1 < myRs2.getInt("RecipeID")) {
					recipeID = myRs2.getInt("RecipeID") + 1;
				} else {
					recipeID = recipeID1 + 1;
				}
			} else {
				recipeID = recipeID1 + 1;
			}
			mystmt.executeUpdate("insert into Recipes (RecipeID, RecipeName, Servings, PrepTime, Ingredients, Directions, "
					+ "Nutrition, Source) Values ('" + recipeID + "', '" + recipes[0] + "-', " + serving + ", " + prepTime + ", '" + recipes[3] + "', '" + recipes[4] + "', '" + recipes[5] 
						+ "', 'Source: " + recipes[6] +"')");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}
