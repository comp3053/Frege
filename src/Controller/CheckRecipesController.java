package Controller;

import java.util.ArrayList;

import mainPart.Brew;
import mainPart.Database;
import mainPart.Recipe;

public class CheckRecipesController {
	public CheckRecipesController() {
		
	}
	
	//View ask for all recipe name
	public ArrayList<String> getAllRecipeName(){
		return Recipe.getAllRecipeName();
	}
}
