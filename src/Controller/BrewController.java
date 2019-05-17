package Controller;

import java.util.ArrayList;

import mainPart.Equipment;
import mainPart.Recipe;

public class BrewController {
	public BrewController() {
		
	}
	
	// to get the capacity
	public float getCapacity() {
		return Equipment.getEquipmentCapacity();
	}
	//View gives the batch size, and return a Recipes' name list to it
	public ArrayList<String> recommandRecipe(float batchSize) {
		return Recipe.recommendRecipe(batchSize);
	}
}
