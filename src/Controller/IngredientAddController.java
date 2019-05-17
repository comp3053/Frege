package Controller;
import mainPart.*;
import UI.*;

public class IngredientAddController {
	public IngredientAddController() {
			
	}
	
	//View give the ingredient name and the quantity it want to change 
	public boolean addIngredientQuantity(String name, float quantity) {
		return StorageIngredient.addQuantity(name, quantity);
	}
	//View ask for ingredient quantity
	public float searchQuantity(String name) {
		return StorageIngredient.searchQ(name);
	}
}
