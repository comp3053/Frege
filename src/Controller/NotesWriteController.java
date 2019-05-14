package Controller;

import mainPart.Note;

public class NotesWriteController {
	public NotesWriteController() {
		
	}
	
	public boolean addNote(String recipeName, String title, float batchSize, String content) {
		return Note.addNote(recipeName, title, batchSize, content);
	}
}
