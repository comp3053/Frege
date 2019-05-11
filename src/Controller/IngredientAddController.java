package Controller;
import mainPart.*;
import UI.*;

public class IngredientAddController {
	public IngredientAddController() {
			
	}
		
	public boolean addIngredientQuantity(String name, float quantity) {
		return StorageIngredient.addQuantity(name, quantity);
	}
	public float searchQuantity(String name) {
		return StorageIngredient.searchQ(name);
	}
}
