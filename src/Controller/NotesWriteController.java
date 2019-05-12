package Controller;

import mainPart.Note;

public class NotesWriteController {
	public NotesWriteController() {
		
	}
	
	public boolean addNote(String title, String content) {
		return Note.addNote(title, content);
	}
}
