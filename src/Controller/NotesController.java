package Controller;

import mainPart.Note;

public class NotesController {
	public NotesController() {
		
	}
	
	public boolean addNote(String title, String content) {
		return Note.addNote(title, content);
	}
}
