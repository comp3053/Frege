package mainPart;
import java.util.Date;
import java.util.Scanner;

public class Note {
	private String title;
	private java.sql.Date date;
	private String content;
	
	public Note(String title, String content) {
		// automatically generate date
		long time = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(time);
		
		this.title = title;
		this.date = date;
		this.content = content;
		Database.dbAddNote(this);
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
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
}
