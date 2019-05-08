package mainPart;

public class StorageIngredient extends Ingredient{
	
	public StorageIngredient (String name, float quantity, String unit) {
		super(name, quantity, unit);
	}
	
	public boolean addQuantity(float quantity) {
		// only accept non-negative numbers
		if(quantity >= 0)
		{
			float oldQuantity = this.getQuantity();
			super.setQuantity(oldQuantity + quantity);
			return Database.dbUpdateStorageIngredient(this);
		}
		// if number is negative, then amount unchanged
		System.out.println("Invalid amount!");
		return false;
	}
	
	public boolean subtractQuantity(float quantity) {
		// only accept non-negative numbers
		if(quantity >= 0)
		{
			float oldQuantity = this.getQuantity();
			if (oldQuantity - quantity >= 0) {
				super.setQuantity(quantity);
				return Database.dbUpdateStorageIngredient(this);
			} else {
				System.out.println("Subtract too much!");
			}
		}
		// if number is negative, then amount unchanged
		System.out.println("Invalid amount!");
		return false;
	}
}