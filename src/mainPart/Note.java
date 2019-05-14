package mainPart;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Note {
	private String recipeName;
	private String title;
	private java.sql.Date date;
	private String content;
	
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
	
	public static boolean addNote(String recipeName, String title, float batchSize, String content) {
		Note note = new Note(recipeName, title, content);
		return Brew.brew(recipeName, Database.dbAddNote(note), batchSize);
	}
	
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
	
	public static ArrayList<Note> showAllNotes() {
		return Database.dbGetAllNotes();
	}
}
