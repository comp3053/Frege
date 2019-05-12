package mainPart;

public class StorageIngredient extends Ingredient{
	
	
	public StorageIngredient (String name, float quantity, String unit) {
		super(name, quantity, unit);
	}
	
	public static boolean addQuantity(String ingredientName, float quantity) {
		// only accept non-negative numbers
		if(quantity >= 0)
		{
			float oldQuantity = Database.dbGetStorageingredientQuantity(ingredientName);
			quantity = oldQuantity + quantity;
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
				quantity = oldQuantity - quantity;
				return Database.dbUpdateStorageIngredient(ingredientName, quantity);
			} else {
				System.out.println("Subtract too much!");
			}
		} else { // if number is negative, then amount unchanged
			System.out.println("Invalid amount!");
		}
		return false;
	}
	
	public static float searchQ(String name) {
		float Quantity = Database.dbGetStorageingredientQuantity(name);
		return Quantity;
	}
	
}