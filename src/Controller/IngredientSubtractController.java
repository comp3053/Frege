package Controller;

import mainPart.StorageIngredient;

public class IngredientSubtractController {
	public IngredientSubtractController() {
		
	}
		
	public boolean subtractIngredientQuantity(String name, float quantity) {
		StorageIngredient siSub = new StorageIngredient(name, quantity, "kg");
		return siSub.subtractQuantity(quantity);
	}
	public float searchQuantity(String name) {
		return StorageIngredient.searchQ(name);
	}
}
