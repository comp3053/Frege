package mainPart;

public class RecipeIngredient extends Ingredient{
	// RecipeIngredient is a child class of ingredient
	public RecipeIngredient (String name, float quantity, String unit) {
		super(name, quantity, unit);
	}
	
	public boolean updateQuantity(int recipeID, String ingredientName, float quantity) {
		// only accept non-negative numbers
		if(quantity >= 0)
		{
			super.setQuantity(quantity);
			// update the quantity in the database
			return Database.dbUpdateRecipeIngredient(recipeID, ingredientName, quantity);
		}
		// if number is negative, then amount unchanged
		System.out.println("Invalid amount!");
		return false;
	}
}
