package Controller;
import mainPart.*;
import UI.*;

public class IngredientAddController {
	public IngredientAddController() {
			
	}
		
	public boolean addIngredientQuantity(String name, float quantity) {
		StorageIngredient siAdd = new StorageIngredient(name, quantity, "kg");
		return siAdd.addQuantity(quantity);
	}
	public float searchQuantity(String name) {
		return StorageIngredient.searchQ(name);
	}
}
