package mainPart;
import java.util.ArrayList;
import java.util.Map;

public class Recipe<ingredients> {
	private String recipeName;
	private float quantity;
	private String unit;
	private static ArrayList<RecipeIngredient> ingredients;
	private Map<String, Brew> Brews;
	
	public Recipe(String recipeName, float quantity, String unit, ArrayList<RecipeIngredient> ingredients) {
		this.recipeName = recipeName;
		this.quantity = quantity;
		this.unit = unit;
		this.ingredients = ingredients;
		//this.id = Database.dbNewRecipe(recipeName, quantity, unit, ingredients);
	}
	
	public static boolean addRecipe(String recipeName, float quantity, String unit, ArrayList<RecipeIngredient> ingredients) {
		return Database.dbNewRecipe(recipeName, quantity, unit, ingredients);
	}
	
	public static boolean updateRecipe(String name, float maltQ, float hopQ, float yeastQ, float sugarQ, float additiveQ) {
		// check whether have this recipe in the list
		int recipeID = Database.dbGetRecipeID(name);
		if (recipeID == 0) return false;
		
		boolean flag1 = Database.dbUpdateRecipeIngredient(recipeID, "malt", maltQ);
		boolean flag2 = Database.dbUpdateRecipeIngredient(recipeID, "hop", hopQ);
		boolean flag3 = Database.dbUpdateRecipeIngredient(recipeID, "yeast", yeastQ);
		boolean flag4 = Database.dbUpdateRecipeIngredient(recipeID, "sugar", sugarQ);
		boolean flag5 = Database.dbUpdateRecipeIngredient(recipeID, "additive", additiveQ);
		return (flag1 && flag2 && flag3 && flag4 && flag5);
	}
	
	public static boolean deleteRecipe(String name) {
		return Database.dbDeleteRecipe(name);
	}
	
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
	
	// Qualifier with Brew class
	public void addBrew(String name, Brew b) {
		if (!Brews.containsKey(b))
		{
			Brews.put(name, b);
			b.addRecipe(name, this);
		}
	}
	
	
	public static ArrayList<Float> convertToAbsoluteMeasure(int recipeID, float batchSize) {
		ArrayList<Float> ingredient = Database.dbGetRecipeIngredientQuantity(recipeID);
		System.out.println(ingredient);
		for (int i = 0; i < 5; i++) {
			ingredient.set(i, ingredient.get(i) * batchSize);
		}
		return ingredient;
	}
	
	public static boolean CheckIngredients(int recipeID, float batchSize) {
		boolean flag = true;
		ArrayList<Float> RecipeIngredient = convertToAbsoluteMeasure(recipeID, batchSize);
		ArrayList<String> ingredientName = new ArrayList<String>();
		ingredientName.add("malts");
		ingredientName.add("hops");
		ingredientName.add("yeasts");
		ingredientName.add("sugars");
		ingredientName.add("additives");
		for (int i = 0; i < 5; i++)
		{
			if (Database.dbGetStorageingredientQuantity(ingredientName.get(i)) < RecipeIngredient.get(i))
			{
				System.out.println("You have " + ingredientName.get(i) + " " + Database.dbGetStorageingredientQuantity(ingredientName.get(i))
				+ "kg, but you need to have " + RecipeIngredient.get(i) + "kg.");
				flag = false;
				break;
			}
		}
		return flag;
	}	
	
	public static ArrayList<String> recommendRecipe(float batchSize){
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<Integer> allRecipeID = Database.dbGetAllRecipeID();
		
		for (int i = 0; i < allRecipeID.size(); i++) {
			if (CheckIngredients(allRecipeID.get(i), batchSize)) {
				result.add(Database.dbGetRecipeName(allRecipeID.get(i)));
			}
		}
		return result;
		// if result is null, then call the function to compute every recipe's ingredient lack
	}
	
	public static ArrayList<Float> checkMissing(int recipeID, float batchSize) {
		ArrayList<Float> missingIngredient = new ArrayList<Float>();
		ArrayList<Float> RecipeIngredient = convertToAbsoluteMeasure(recipeID, batchSize);
		ArrayList<String> ingredientName = new ArrayList<String>();
		ingredientName.add("malts");
		ingredientName.add("hops");
		ingredientName.add("yeasts");
		ingredientName.add("sugars");
		ingredientName.add("additives");
		for (int i = 0; i < 5; i++)
		{
			float missingQuantity = RecipeIngredient.get(i) - Database.dbGetStorageingredientQuantity(ingredientName.get(i)); 
			if (missingQuantity > 0)
			{
				missingIngredient.add(i, missingQuantity);
			} else {
				missingIngredient.add(i, (float) 0);
			}
		}
		return missingIngredient;
	}
	
	public static ArrayList<String> getAllRecipeName() {
		ArrayList<String> allRecipeName = new ArrayList<String>();
		ArrayList<Integer> allRecipeID = Database.dbGetAllRecipeID();
		for (int i = 0; i < allRecipeID.size(); i++) {
			allRecipeName.add(Database.dbGetRecipeName(allRecipeID.get(i)));
		}
		return allRecipeName;
	}
}
