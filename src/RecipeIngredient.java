
public class RecipeIngredient extends Ingredient{
	public RecipeIngredient () {
		super();
	}
	
	public boolean updateAmount(float amount) {
		// only accept non-negative numbers
		if(amount >= 0)
		{
			super.setAmount(amount);
			return true;
		}
		// if number is negative, then amount unchanged
		System.out.println("Invalid amount!");
		return false;
	}
}
