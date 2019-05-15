package mainPart;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Brew<recipes> {
	private float batchSize;
	private Date date;
	private Map<String, Recipe> recipe;
	
	
	// ----- getters and setters -----
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
	
	// ------- methods --------
	public static boolean brew(String recipeName, int noteID, float batchSize) {
		// call this function to add a brew record into the database
		// get the recipe id of current recipe
		int recipeID = Database.dbGetRecipeID(recipeName);
		// if cannot find the recipe
		if (recipeID == 0) return false;
		
		ArrayList<String> ingredientName = new ArrayList<String>();
		ingredientName.add("malts");
		ingredientName.add("hops");
		ingredientName.add("yeasts");
		ingredientName.add("sugars");
		ingredientName.add("additives");
		
		// get the quantity of each ingredient that needed in current recipe per liter
		ArrayList<Float> recipeIngredients = Database.dbGetRecipeIngredientQuantity(recipeID);
		for (int i = 0; i < 5 ; i++) {
			// subtract the quantity of ingredient to brew current recipe basing on the batch size
			StorageIngredient.subtractQuantity(ingredientName.get(i), recipeIngredients.get(i) * batchSize);
		}
		// write a record into the database
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
