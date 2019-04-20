
public class RecipeIngredient extends Ingredient{
	public RecipeIngredient () {
		super();
	}
	public boolean updateAmount(float amount) {
		if(amount >= 0)
		{
			super.setAmount(amount);
			return true;
		}
		System.out.println("Invalid amount!");
		return false;
	}
}
