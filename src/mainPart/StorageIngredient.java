package mainPart;

public class StorageIngredient extends Ingredient{	
	// StorageIngredient is a child class of ingredient
	public StorageIngredient (String name, float quantity, String unit) {
		super(name, quantity, unit);
	}
	
	public static boolean addQuantity(String ingredientName, float quantity) {
		// only accept non-negative numbers
		if(quantity >= 0)
		{
			// get the original quantity from the database
			float oldQuantity = Database.dbGetStorageingredientQuantity(ingredientName);
			// compute the new quantity
			quantity = oldQuantity + quantity;
			// update the quantity in the database
			return Database.dbUpdateStorageIngredient(ingredientName, quantity);
		}
		// if number is negative, then amount unchanged
		System.out.println("Invalid amount!");
		return false;
	}
	
	public static boolean subtractQuantity(String ingredientName, float quantity) {
		// only accept non-negative numbers
		if(quantity >= 0)
		{
			float oldQuantity = Database.dbGetStorageingredientQuantity(ingredientName);
			if (oldQuantity - quantity >= 0) {
				// compute the new quantity
				quantity = oldQuantity - quantity;
				// update the quantity in the database
				return Database.dbUpdateStorageIngredient(ingredientName, quantity);
			} else {
				// if the subtract quantity is larger than the original quantity
				System.out.println("Subtract too much!");
			}
		} else {
			// if number is negative, then amount unchanged
			System.out.println("Invalid amount!");
		}
		return false;
	}
	
	public static float searchQ(String name) {
		// call this function to get the specific quantity of ingredient in storage
		float Quantity = Database.dbGetStorageingredientQuantity(name);
		return Quantity;
	}
	
}