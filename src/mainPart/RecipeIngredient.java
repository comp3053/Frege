package mainPart;

public class RecipeIngredient extends Ingredient{
	
	public RecipeIngredient (String name, float quantity, String unit) {
		super(name, quantity, unit);
	}
	
	public boolean updateQuantity(int recipeID, String ingredientName, float quantity) {
		// only accept non-negative numbers
		if(quantity >= 0)
		{
			super.setQuantity(quantity);
			return Database.dbUpdateRecipeIngredient(recipeID, ingredientName, quantity);
		}
		// if number is negative, then amount unchanged
		System.out.println("Invalid amount!");
		return false;
	}
}
