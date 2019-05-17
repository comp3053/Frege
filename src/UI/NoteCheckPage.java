package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class NoteCheckPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;


	/**
	 * Create the frame.
	 */
	public NoteCheckPage(Date Date, String RecipeName, String Title, String Content) {
		setTitle("BrewDay! [Frege]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Calibri", Font.BOLD, 30));
		lblTitle.setBounds(170, 13, 224, 42);
		lblTitle.setText(Title);
		contentPane.add(lblTitle);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblDate.setBounds(300, 54, 224, 42);
		DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
		String outputText = outputFormat.format(Date);
		lblDate.setText(outputText);
		contentPane.add(lblDate);
		
		JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(14, 105, 554, 202);
        contentPane.add(layeredPane);
        JTextArea ContentVal = new JTextArea(4, 180);
        ContentVal.setFont(new Font("Calibri", Font.PLAIN, 20)); 
        ContentVal.setLineWrap(true);
        ContentVal.setText(Content);
        JScrollPane scr = new JScrollPane(ContentVal, 
        								// Hide the horizontal scroll bar policy
        								JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
        								JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        layeredPane.setLayout(new BorderLayout());
        layeredPane.add(scr, BorderLayout.CENTER);
		
		JLabel lblRecipe = new JLabel("Recipe");
		lblRecipe.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipe.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblRecipe.setBounds(49, 54, 155, 42);
		lblRecipe.setText(RecipeName);
		contentPane.add(lblRecipe);
		
		
		MyRoundButton btnBack = new MyRoundButton("Back");
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new NotesPage().setVisible(true);
			}
		});
		btnBack.setBounds(233, 320, 113, 33);
		contentPane.add(btnBack);
	
		
	}
	
	// Close current UI page
	protected void closeThis() {
		//contentPane.setVisible(false);
		this.dispose();
	}
}
