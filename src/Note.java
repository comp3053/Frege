import java.util.Date;
import java.util.Scanner;

public class Note {
	private String title;
	private Date date;
	private String content;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void editContent(String content) {
		Scanner inputContent = new Scanner(System.in);
        String newContent = inputContent.next();
        this.content = newContent;
	}
}
