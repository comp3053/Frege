package Controller;

import mainPart.Note;

public class NotesWriteController {
	public NotesWriteController() {
		
	}
	
	public boolean addNote(String recipeName, float batchSize, String content) {
		return Note.addNote(recipeName, batchSize, content);
	}
}
