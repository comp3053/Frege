package Controller;
import mainPart.*;
import UI.*;

public class IngredientAddController {
	public IngredientAddController() {
			
	}
		
	public void addIngredientQuantity(String name, float quantity) {
		StorageIngredient siAdd = new StorageIngredient(name, quantity, "kg");
		siAdd.addQuantity(quantity);
	}

}
