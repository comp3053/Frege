package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.EquipmentUpdateController;
import Controller.NotesWriteController;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;

public class NotesWritePage extends JFrame {

	private JPanel contentPane;
	private String Date;
	private String Recipe;
	private String Content;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private String Date;
			private String Recipe;
			private String Content;

			public void run() {
				try {
					NotesWritePage frame = new NotesWritePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NotesWritePage() {
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
		layeredPane.setBounds(14, 37, 554, 272);
		contentPane.add(layeredPane);
		
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
        
        JTextField RecipeVal = new JTextField(Recipe);
        RecipeVal.setPreferredSize(new Dimension(100, 23));
        RecipeVal.setBounds(118, 46, 367, 32);
        layeredPane.add(RecipeVal);
        
        JTextField ContentVal = new JTextField(Content);
        ContentVal.setPreferredSize(new Dimension(100, 23));
        ContentVal.setBounds(119, 79, 367, 162);
        layeredPane.add(ContentVal);
        
		
        JButton btnSave = new JButton("Save");
        btnSave.setFont(new Font("Calibri", Font.PLAIN, 25));
        btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(Recipe == null) {
						JOptionPane.showMessageDialog(null,"Operation error!","Warning",JOptionPane.ERROR_MESSAGE);
						closeThis();
						new NotesWritePage().setVisible(true);
					}else {
						// pass the title and content of note
						NotesWriteController controller = new NotesWriteController();
						controller.addNote(Recipe, Content);
						boolean add = controller.addNote(Recipe, Content);
						if(add) {
							JOptionPane.showMessageDialog(null, "Success!");
							closeThis();
							new HomePage();
						}else {
							JOptionPane.showMessageDialog(null,"Fail!","Warning",JOptionPane.ERROR_MESSAGE);
							closeThis();
							new NotesWritePage().setVisible(true);
						}
					}
			}catch(NullPointerException ex) {
				JOptionPane.showMessageDialog(null,"Please input right information!","Warning",JOptionPane.ERROR_MESSAGE);
			}
		}
		});
        btnSave.setBounds(90, 311, 150, 45);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new HomePage();
			}
		});
		btnCancel.setBounds(347, 311, 150, 45);
		contentPane.add(btnCancel);
	}
	// Close current UI page
		protected void closeThis() {
			contentPane.setVisible(false);
		}
}
