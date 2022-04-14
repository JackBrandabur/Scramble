-- MySQL dump 10.13  Distrib 8.0.28, for macos11 (x86_64)
--
-- Host: localhost    Database: Scramble
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Recipes`
--

DROP TABLE IF EXISTS `Recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Recipes` (
  `RecipeID` int DEFAULT NULL,
  `RecipeName` varchar(255) DEFAULT NULL,
  `Servings` int DEFAULT NULL,
  `PrepTime` int DEFAULT NULL,
  `Ingredients` text,
  `Directions` text,
  `Nutrition` text,
  `Source` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Recipes`
--

LOCK TABLES `Recipes` WRITE;
/*!40000 ALTER TABLE `Recipes` DISABLE KEYS */;
INSERT INTO `Recipes` VALUES (1,'Churros -',4,20,'Ingredients:\n1 cup water\n2 1/2 tbsp white sugar\n1/2 tsp salt\n2 tbsp vegetable oil\n1 cup all purpose flour\n2 quarts vegetable oil\n1/2 cup white sugar (or to taste)\n1 tsp ground cinnamon','Directions:\n1) In a small saucepan over medium heat, mix water, 2 1/2 tbsp white sugar, salt, and 2 tbsp vegetable oil. Bring to boil and remove from heat. Stir in flour until a ball is formed.\n2) Heat 2 quarts vegetable oil in a deep pot to 375 degrees F (190 degrees C). Place dough in a disposable bag with a small corner cut (for better results use a pastry bag fitted with a medium-star tip). Squeeze 5-6 in (12-13 cm) tubes into the hot oil. Do not overcrowd the pot. Fry until golden and drain on paper towels. Maintain between 350-375 degrees F (175-190 degrees C). Do not go over the recommended temperature to avoid burning.\n3) Combine 1/2 cup sugar and cinnamon. Roll drained churros in cinnamon-sugar mixture.','Nutrition: Per serving: 691 calories; 3.3g protein; 57.1g carbs; 51.1g fat; 293.1mg sodium','Source: https://www.allrecipes.com/recipe/24700/churros/'),(2,'French Toast-',4,20,'Ingredients:\n4 eggs\n2/3 cup milk\n2 tsp cinnamon\n8 slices bread (preferably thick)\nbutter (can sub vegetable oil)\nmaple syrup\npreferred toppings (chocolate, berries, powder sugar, etc.)','Directions:\n1) Make the egg mixture. In a medium bowl, whisk together the eggs, milk, and cinnamon. Whisk the mixture until well blended and pour into a shallow bowl, wide enough to place a slice of the bread you will be using.\n2) Soak bread slices in egg mixture. Place each slice of bread into the egg milk mixture, allowing the bread to soak in some of it.\n3) Fry the French toast. Melt some butter in a large skillet over medium high heat. Shake off the excess egg mixture from the bread and place the bread slices onto the hot skillet. Fry the french toast until browned on one side, then flip and brown the other side.\n4) Serve. Serve the French toast hot with butter, maple syrup, and/or fresh berries.','Nutrition: Per 2-slice serving: 434 calories; 19g fat; 55g carbs; 12g protein','Source: https://www.simplyrecipes.com/recipes/french_toast/'),(3,'Mac and Cheese -',8,15,'Ingredients:\n8 oz elbow macaroni uncooked\n2 tbs butter\n2 tbs all-purpose flour\n1/2 tsp sea salt\n1/4 tsp garlic powder (optional but recommended)\n1 cup whole milk\n1/4 cup sour cream (or greek yogurt)\n2 cups shredded cheddar cheese','Directions:\n1) Cook elbow macaroni according to package instructions. Be sure to add 1/4 tsp salt to the water used to boil the noodles. Drain, and set aside.\n2) Make the cheese sauce: Mix flour sea salt, and garlic powder together in a small bowl. Set aside.\n3) In a medium saucepan over medium heat, melt the butter.\n4) Add flour mixture and whisk to combine.\n5) Cook for one minute until mixture is slightly brown.\n6) Add 1 cup milk and whisk until the mixture is smooth.\n7) Add sour cream (or Greek yogurt) and whisk until smooth.\n8) Cook on medium-high heat until the mixture is thickened (about 3-5 minutes). Do not let it boil.\n9) Once mixture is thick (sticks to the back of the spatula), reduce heat to low and add cheese. Whisk until cheese is melted and mixture is smooth. Taste and add more salt/seasoning if desired.\n10) Add cooked pasta to the pot of cheese sauce and stir until the sauce is evenly distributed.\n11) Let the mac and cheese cool for 3-5 minutes or until the cheese sauce has thickened a little bit and sticks to the noodles. Serve warm!','Nutrition: Per 1/2 cup serving: 271 calories; 13.8g fat; 25.3g carbs; 12.3g protein','Source: https://joyfoodsunshine.com/homemade-mac-and-cheese/'),(4,'Rice Pudding -',4,30,'Ingredients:\n2 3/4 cups whole milk\n1 tsp vanilla extract\n1/2 cup rice (short-grain preferred)\n1/4 cup granulated sugar\n1/2 lemon zest\npinch of salt\npinch ground cinnamon','Directions:\n1) Gather the ingredients.\n2) Place the milk in a small saucepan over medium-low heat. Add the vanilla extract and stir.\n3) Once the milk starts to simmer and steam, skim off and discard any skin that might have formed. Sprinkle in the rice and stir gently with a wooden spoon. Turn the heat up slightly to maintain a lively simmer and continue to cook until the mixture begins to thicken, about 8 minutes.\n4) Cover the pot and lower the heat. Keep an eye on the rice and stir occasionally for 5 to 7 minutes.\n5) Remove the cover and continue to cook, stirring frequently, until the rice is done and the mixture is thickened to your liking, 9 to 11 minutes more. Remove from the heat and add the sugar, lemon zest, and a pinch of salt. Stir gently and taste. Add a little more sugar if necessary.\n6) The pudding will continue to thicken as it cools. Serve hot, at room temperature, or chilled. Sprinkle with cinnamon just before serving.','Nutrition: Per serving: 180 calories; 6g fat; 26g carbs; 6g protein','Source: https://www.thespruceeats.com/vanilla-rice-pudding-recipe-256121'),(5,'Spaghetti -',6,15,'Ingredients:\n1 12-oz box Barilla(r) Pronto(r) Half-Cut Spaghetti\npinch salt (optional to taste)\n1 lb ground beef or ground sirloin (I used and recommend 90% lean so you dont have to drain it)\n1 24-oz jar Barilla(r) Tomato and Basil Sauce or your favorite sauce\nfinely chopped fresh basil (for garnishing, optional)\nfreshly grated Parmesan cheese (for garnishing, optional)','Directions:\n1) To a large pan, add the pasta, cover with 3 cups cold water, optional salt to taste, and boil over high heat until water has absorbed, about 10 minutes, but watch your pasta and cook as needed until al dente. While pasta boils, brown the ground beef.\n2) To a large skillet, add the ground beef and cook over medium-high heat, breaking up the meat with a spatula as it cooks to ensure even cooking.\n3) After beef has cooked through, add the pasta sauce, stir to combine, and cook for 1 to 2 minutes, or until heated through.\n4) After pasta has cooked for about 10 minutes, or until all the water has been absorbed, add the sauce over the pasta and toss to combine in the skillet or alternatively plate the pasta and add sauce to each individual plate as desired.\n5) Optionally garnish with basil and Parmesan to taste and serve immediately. Pasta and sauce are best warm and fresh but extra will keep airtight in the fridge for up to 5 days.','Nutrition: Per serving: 303 calories; 16g fat; 12g carbs; 27g protein','Source: https://www.averiecooks.com/easy-15-minute-spaghetti/');
/*!40000 ALTER TABLE `Recipes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UserRecipes`
--

DROP TABLE IF EXISTS `UserRecipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `UserRecipes` (
  `UserName` varchar(255) DEFAULT NULL,
  `Publish` int DEFAULT NULL,
  `RecipeID` int DEFAULT NULL,
  `RecipeName` varchar(255) DEFAULT NULL,
  `Servings` int DEFAULT NULL,
  `PrepTime` int DEFAULT NULL,
  `Ingredients` text,
  `Directions` text,
  `Nutrition` text,
  `Source` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserRecipes`
--

LOCK TABLES `UserRecipes` WRITE;
/*!40000 ALTER TABLE `UserRecipes` DISABLE KEYS */;
INSERT INTO `UserRecipes` VALUES ('admin',1,6,'Chocolate Chip Cookies-',24,20,'Ingredients:\n1 cup butter, softened\n1 cup white sugar\n1 cup packed brown sugar\n2 eggs\n2 teaspoons vanilla extract\n1 teaspoon baking soda\n2 teaspoons hot water\n½ teaspoon salt\n3 cups all-purpose flour\n2 cups semisweet chocolate chips\n1 cup chopped walnuts','Directions:\n1) Preheat oven to 350 degrees F (175 degrees C).\n2) Cream together the butter, white sugar, and brown sugar until smooth. Beat in the eggs one at a time, then stir in the vanilla. Dissolve baking soda in hot water. Add to batter along with salt. Stir in flour, chocolate chips, and nuts. Drop by large spoonfuls onto ungreased pans.\n2) Bake for about 10 minutes in the preheated oven, or until edges are nicely browned.','Nutrition: 298 calories; protein 3.6g; carbohydrates 38.9g; fat 15.6g; cholesterol 35.8mg; sodium 165.8mg','Source: https://www.allrecipes.com/recipe/10813/best-chocolate-chip-cookies/');
/*!40000 ALTER TABLE `UserRecipes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Users` (
  `UserName` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES ('brandajj@miamioh,edu','testPassword'),('admin','123'),('admin2','1234'),('admin','123');
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-13 21:32:57
