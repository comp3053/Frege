package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class NoteCheckPage extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public NoteCheckPage(Date Date, String RecipeName, String Title, String Content) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Calibri", Font.BOLD, 30));
		lblTitle.setBounds(240, 13, 106, 42);
		lblTitle.setText(Title);
		contentPane.add(lblTitle);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblDate.setBounds(418, 54, 106, 42);
		DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
		String outputText = outputFormat.format(Date);
		lblDate.setText(outputText);
		contentPane.add(lblDate);
		
		JLabel lblContent = new JLabel("Content");
		lblContent.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblContent.setBounds(14, 105, 554, 176);
		lblContent.setText(Content);
		contentPane.add(lblContent);
		
		JLabel lblRecipe = new JLabel("Recipe");
		lblRecipe.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipe.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblRecipe.setBounds(69, 54, 106, 42);
		lblRecipe.setText(RecipeName);
		contentPane.add(lblRecipe);
		
		
		JButton btnBack = new JButton("Back");
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
