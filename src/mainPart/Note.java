package mainPart;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Note {
	private String recipeName;
	private String title;
	private java.sql.Date date;
	private String content;
	
	// -------- constructors --------
	public Note(String recipeName, String title, String content) {
		// automatically generate date
		long time = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(time);
		
		this.recipeName = recipeName;
		this.title = title;
		this.date = date;
		this.content = content;
	}
	
	public Note(String recipeName, String title, java.sql.Date date, String content) {
		this.recipeName = recipeName;
		this.title = title;
		this.date = date;
		this.content = content;
	}
	
	// ------ getters and setters -------
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getRecipeName() {
		return recipeName;
	}
	
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	
	public java.sql.Date getDate() {
		return date;
	}
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	// ----- methods -----
	public static boolean addNote(String recipeName, String title, float batchSize, String content) {
		// after brew, user need to write a note
		Note note = new Note(recipeName, title, content);
		// add current brew record into database
		return Brew.brew(recipeName, Database.dbAddNote(note), batchSize);
	}
	
	public static ArrayList<Note> showAllNotes() {
		// call this function and get all the notes from database
		return Database.dbGetAllNotes();
	}
}
