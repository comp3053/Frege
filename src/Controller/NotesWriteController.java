package Controller;

import mainPart.Note;

public class NotesWriteController {
	public NotesWriteController() {
		
	}
	
	//View give the recipe name, title, batch size and note content 
	public boolean addNote(String recipeName, String title, float batchSize, String content) {
		return Note.addNote(recipeName, title, batchSize, content);
	}
}
