package Controller;

import java.util.ArrayList;

import mainPart.Note;

public class NotesController {
	public NotesController() {
		
	}
	
	public ArrayList<Note> showNote(){
		return Note.showNote();
	}
}
