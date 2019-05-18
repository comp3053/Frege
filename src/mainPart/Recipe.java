package mainPart;
import java.util.ArrayList;
import java.util.Map;

public class Recipe<ingredients> {
	private String recipeName;
	private float quantity;
	private String unit;
	private ArrayList<RecipeIngredient> ingredients;
	private Map<String, Brew> Brews;
	
	// ------- constructor -------
	public Recipe(String recipeName, float quantity, String unit, ArrayList<RecipeIngredient> ingredients) {
		this.recipeName = recipeName;
		this.quantity = quantity;
		this.unit = unit;
		this.ingredients = ingredients;
	}
	
	// ------- getters and setters -------
	public void setRecipeName(String name) {
		this.recipeName = name;
	}
	
	public String getRecipeName() {
		return this.recipeName;
	}
	
	public boolean setQuantity(float quantity) {
		if (quantity >= 0)
		{
			this.quantity = quantity;
			return true;
		} else {
			System.out.println("Quantity should be non-negative!");
			return false;
		}
	}
	
	public ArrayList<RecipeIngredient> getIngredients() {
		return ingredients;
	}
	
	public float getQuantity() {
		return this.quantity;
	}
	
	public boolean setUnit(String unit) {
		if (unit.equals("kg") || unit.equals("g") || unit.equals("ml") || unit.equals("l"))
		{
			this.unit = unit;
			return true;
		} else {
			System.out.println("Unit invaild!");
			return false;
		}
		
	}
	
	public String getUnit() {
		return this.unit;
	}
	
	// ------- methods ---------
	public static boolean addRecipe(String recipeName, float quantity, String unit, ArrayList<RecipeIngredient> ingredients) {
		// add a recipe into the database
		int recipeID = Database.dbGetRecipeID(recipeName);
		if (recipeID != 0) // if the recipe already exists.
			return false;
		
		return Database.dbNewRecipe(recipeName, quantity, unit, ingredients);
	}
	
	public static boolean updateRecipe(String name, float maltQ, float hopQ, float yeastQ, float sugarQ, float additiveQ) {
		// check whether have this recipe in the list
		int recipeID = Database.dbGetRecipeID(name);
		if (recipeID == 0) return false; // if cannot find the recipe
		
		// start to update the recipe's ingredient quantity one by one
		boolean flag1 = Database.dbUpdateRecipeIngredient(recipeID, "malt", maltQ);
		boolean flag2 = Database.dbUpdateRecipeIngredient(recipeID, "hop", hopQ);
		boolean flag3 = Database.dbUpdateRecipeIngredient(recipeID, "yeast", yeastQ);
		boolean flag4 = Database.dbUpdateRecipeIngredient(recipeID, "sugar", sugarQ);
		boolean flag5 = Database.dbUpdateRecipeIngredient(recipeID, "additive", additiveQ);
		// if all the update successfully, return true
		return (flag1 && flag2 && flag3 && flag4 && flag5);
	}
	
	public static boolean deleteRecipe(String name) {
		// call this function to delete specific recipe
		return Database.dbDeleteRecipe(name);
	}
	
	public static ArrayList<Float> convertToAbsoluteMeasure(int recipeID, float batchSize) {
		// call this function to get the absolute quantity of each ingredient that exactly needs basing on the batch size
		// get the quantity need of each ingredient per liter
		ArrayList<Float> ingredient = Database.dbGetRecipeIngredientQuantity(recipeID);
		for (int i = 0; i < 5; i++) {
			// compute the absolute quantity of each ingredient
			ingredient.set(i, ingredient.get(i) * batchSize);
		}
		return ingredient;
	}
	
	public static boolean CheckIngredients(int recipeID, float batchSize) {
		// call this function to check whether the storage ingredient is enough for this recipe basing on the batch size
		boolean flag = true;
		// get the absolute quantity of each ingredient
		ArrayList<Float> RecipeIngredient = convertToAbsoluteMeasure(recipeID, batchSize);
		ArrayList<String> ingredientName = new ArrayList<String>();
		ingredientName.add("malts");
		ingredientName.add("hops");
		ingredientName.add("yeasts");
		ingredientName.add("sugars");
		ingredientName.add("additives");
		for (int i = 0; i < 5; i++)
		{	// get the quantity of ingredient in the storage, and compare whether it's enough
			if (Database.dbGetStorageingredientQuantity(ingredientName.get(i)) < RecipeIngredient.get(i))
			{
				// if current ingredient in storage is not enough, that means this recipe cannot be brew now
				System.out.println("You have " + ingredientName.get(i) + " " + Database.dbGetStorageingredientQuantity(ingredientName.get(i))
				+ "kg, but you need to have " + RecipeIngredient.get(i) + "kg.");
				// it will return false
				flag = false;
				break;
			}
			// if every ingredient in the storage is enough, then return
		}
		return flag;
	}	
	
	public static ArrayList<String> recommendRecipe(float batchSize){
		ArrayList<String> result = new ArrayList<String>();
		// get all the recipe from the database
		ArrayList<Integer> allRecipeID = Database.dbGetAllRecipeID();
		
		for (int i = 0; i < allRecipeID.size(); i++) {
			if (CheckIngredients(allRecipeID.get(i), batchSize)) {
				// if the ingredients in the storage is enough for the current recipe, then recommend it
				result.add(Database.dbGetRecipeName(allRecipeID.get(i)));
			}
		}
		return result;
		// if result is null, then call the function to compute every recipe's ingredient lack
	}
	
	public static ArrayList<Float> checkMissing(int recipeID, float batchSize) {
		ArrayList<Float> missingIngredient = new ArrayList<Float>();
		// get the absolute quantity of each ingredient
		ArrayList<Float> RecipeIngredient = convertToAbsoluteMeasure(recipeID, batchSize);
		ArrayList<String> ingredientName = new ArrayList<String>();
		ingredientName.add("malts");
		ingredientName.add("hops");
		ingredientName.add("yeasts");
		ingredientName.add("sugars");
		ingredientName.add("additives");
		for (int i = 0; i < 5; i++)
		{	// compute the missing quantity of each ingredient
			float missingQuantity = RecipeIngredient.get(i) - Database.dbGetStorageingredientQuantity(ingredientName.get(i)); 
			if (missingQuantity > 0)
			{	// set the missing quantity of current ingredient
				missingIngredient.add(i, missingQuantity);
			} else {
				// if the current ingredient is enough, set to 0
				missingIngredient.add(i, (float) 0);
			}
		}
		return missingIngredient;
	}
	
	public static ArrayList<String> getAllRecipeName() {
		ArrayList<String> allRecipeName = new ArrayList<String>();
		// get all the recipe id from the database
		ArrayList<Integer> allRecipeID = Database.dbGetAllRecipeID();
		for (int i = 0; i < allRecipeID.size(); i++) {
			// convert each recipe id into it's corresponding name
			allRecipeName.add(Database.dbGetRecipeName(allRecipeID.get(i)));
		}
		return allRecipeName;
	}
	
	// ------ Qualifier with Brew class -------
	public void addBrew(String name, Brew b) {
		if (!Brews.containsKey(b))
		{
			Brews.put(name, b);
			b.addRecipe(name, this);
		}
	}
}
