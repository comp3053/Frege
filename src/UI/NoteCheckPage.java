package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JEditorPane;

public class NoteCheckPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public NoteCheckPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNote = new JLabel("Note");
		lblNote.setHorizontalAlignment(SwingConstants.CENTER);
		lblNote.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNote.setBounds(219, 13, 153, 46);
		contentPane.add(lblNote);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(14, 61, 554, 254);
		contentPane.add(layeredPane);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblDate.setBounds(0, 13, 105, 32);
		layeredPane.add(lblDate);
		
		JLabel lblRecipe = new JLabel("Recipe");
		lblRecipe.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipe.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblRecipe.setBounds(0, 46, 105, 32);
		layeredPane.add(lblRecipe);
		
		JLabel lblContent = new JLabel("Content");
		lblContent.setHorizontalAlignment(SwingConstants.CENTER);
		lblContent.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblContent.setBounds(0, 79, 105, 32);
		layeredPane.add(lblContent);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(118, 13, 367, 32);
		layeredPane.add(editorPane);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(118, 46, 367, 32);
		layeredPane.add(editorPane_1);
		
		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setBounds(119, 79, 367, 162);
		layeredPane.add(editorPane_2);
		
		JButton btnUpdate = new JButton("Back");
		btnUpdate.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new NotesPage().setVisible(true);;
			}
		});
		btnUpdate.setBounds(219, 325, 150, 45);
		contentPane.add(btnUpdate);
	}
	// Close current UI page
	protected void closeThis() {
		//contentPane.setVisible(false);
		this.dispose();
	}
}
