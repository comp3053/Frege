package Controller;

import mainPart.StorageIngredient;

public class IngredientSubtractController {
	public IngredientSubtractController() {
		
	}
		
	//View give the ingredient name and quantity he want to subtract
	public boolean subtractIngredientQuantity(String name, float quantity) {
		return StorageIngredient.subtractQuantity(name, quantity);
	}
	//then, show the ingredient amount after subtracting
	public float searchQuantity(String name) {
		return StorageIngredient.searchQ(name);
	}
}
