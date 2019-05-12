package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JList;

public class NotesPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public NotesPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(29, 67, 524, 290);
		contentPane.add(layeredPane);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblDate.setBounds(41, 13, 79, 31);
		layeredPane.add(lblDate);
		
		JLabel lblRecipe = new JLabel("Recipe");
		lblRecipe.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipe.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblRecipe.setBounds(192, 13, 79, 31);
		layeredPane.add(lblRecipe);
		
		JLabel lblContent = new JLabel("Content");
		lblContent.setHorizontalAlignment(SwingConstants.CENTER);
		lblContent.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblContent.setBounds(357, 13, 95, 31);
		layeredPane.add(lblContent);
		
		JList list = new JList();
		list.setBounds(14, 52, 496, 225);
		layeredPane.add(list);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new HomePage();
			}
		});
		btnHome.setBounds(460, 28, 89, 27);
		contentPane.add(btnHome);
		
		JLabel lblNotesPage = new JLabel("Notes Page");
		lblNotesPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotesPage.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNotesPage.setBounds(210, 13, 153, 46);
		contentPane.add(lblNotesPage);
	}
	// Close current UI page
	protected void closeThis() {
		//contentPane.setVisible(false);
		this.dispose();
	}
}
