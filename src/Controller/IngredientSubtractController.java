package Controller;

import mainPart.StorageIngredient;

public class IngredientSubtractController {
	public IngredientSubtractController() {
		
	}
		
	public boolean subtractIngredientQuantity(String name, float quantity) {
		return StorageIngredient.subtractQuantity(name, quantity);
	}
	public float searchQuantity(String name) {
		return StorageIngredient.searchQ(name);
	}
}
