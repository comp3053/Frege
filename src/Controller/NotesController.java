package Controller;

import java.util.ArrayList;

import mainPart.Note;

public class NotesController {
	public NotesController() {
		
	}
	
	//return all notes
	public ArrayList<Note> showNote(){
		return Note.showAllNotes();
	}
}
