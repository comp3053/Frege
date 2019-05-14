package mainPart;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Brew<recipes> {
	private float batchSize;
	private Date date;
	private Map<String, Recipe> recipe;
	private ArrayList<Recipe> recipes;
	private ArrayList<Ingredient> ingredient;
	private ArrayList<RecipeIngredient> RIn;
	
	
	public float getBatchSize() {
		return batchSize;
	}
	
	public void setBatchSize(float batchSize) {
		this.batchSize = batchSize;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public static boolean brew(String recipeName, int noteID, float batchSize) {
		int recipeID = Database.dbGetRecipeID(recipeName);
		if (recipeID == 0) return false;
		
		ArrayList<String> ingredientName = new ArrayList<String>();
		ingredientName.add("malts");
		ingredientName.add("hops");
		ingredientName.add("yeasts");
		ingredientName.add("sugars");
		ingredientName.add("additives");
		
		ArrayList<Float> recipeIngredients = Database.dbGetRecipeIngredientQuantity(recipeID);
		for (int i = 0; i < 5 ; i++) {
			StorageIngredient.subtractQuantity(ingredientName.get(i), recipeIngredients.get(i) * batchSize);
		}
		Database.dbBrew(recipeID, noteID, batchSize);
		return true;
	}
	
	public void addRecipe(String recipeName, Recipe r) {
		if(!recipe.containsKey(recipeName))
		{
			recipe.put(recipeName, r);
			r.addBrew(recipeName, this);
		}
	}
}
