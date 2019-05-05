package UI;
import java.awt.EventQueue;
import mainPart.*;

public class test {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
