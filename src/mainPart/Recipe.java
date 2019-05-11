package mainPart;
import java.util.ArrayList;
import java.util.Map;

public class Recipe<ingredients> {
	private String recipeName;
	private float quantity;
	private String unit;
	private ArrayList<RecipeIngredient> ingredients;
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
	
	
	public ArrayList<Float> convertToAbsoluteMeasure(int recipeID, float batchSize) {
		ArrayList<Float> ingredient = Database.dbGetRecipeIngredientQuantity(recipeID);
		for (int i = 0; i < 5; i++) {
			ingredient.set(i, ingredient.get(i) * batchSize);
		}
		return ingredient;
	}
	
	public boolean CheckIngredients(float batchSize) {
		boolean flag = true;
		for (int i = 0; i < ingredients.size(); i++)
		{
			if (ingredients.get(i).getQuantity() < batchSize)
			{
				flag = false;
			}
		}
		return flag;
	}	
	
	public static ArrayList<Recipe> recommandRecipe(float batchSize){
		
	}
}
