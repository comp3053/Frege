package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.EquipmentUpdateController;
import Controller.NotesWriteController;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import javax.swing.JList;
import java.awt.Color;

public class NotesWritePage extends JFrame {

	private JPanel contentPane;
	private String Date;
	private String Recipe;
	private String Content;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public NotesWritePage(String RecipeName, float batchSize) {
		setTitle("BrewDay! [Frege]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(contentPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNote = new JLabel("Note");
		lblNote.setHorizontalAlignment(SwingConstants.CENTER);
		lblNote.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNote.setBounds(217, 0, 153, 46);
		contentPane.add(lblNote);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(14, 37, 554, 272);
		contentPane.add(layeredPane);
		
		JLabel lblRecipe = new JLabel("Recipe");
		lblRecipe.setHorizontalAlignment(SwingConstants.LEFT);
		lblRecipe.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblRecipe.setBounds(16, 14, 94, 32);
		layeredPane.add(lblRecipe);
		
		JLabel lblTitle = new JLabel("Title");
        lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
        lblTitle.setFont(new Font("Calibri", Font.PLAIN, 25));
        lblTitle.setBounds(16, 49, 94, 32);
        layeredPane.add(lblTitle);
		
		JLabel lblContent = new JLabel("Content");
		lblContent.setHorizontalAlignment(SwingConstants.LEFT);
		lblContent.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblContent.setBounds(16, 83, 119, 32);
		layeredPane.add(lblContent);
        
		JTextField RecipeVal = new JTextField(Recipe);
        RecipeVal.setFont(new Font("Calibri", Font.PLAIN, 20));
        RecipeVal.setPreferredSize(new Dimension(100, 23));
        RecipeVal.setBounds(118, 14, 367, 32);
        RecipeVal.setText(RecipeName);
        layeredPane.add(RecipeVal);
        RecipeVal.setEditable(false);
        
        // Title
        JTextField TitleVal = new JTextField();
        TitleVal.setFont(new Font("Calibri", Font.PLAIN, 20));
        TitleVal.setBounds(118, 49, 367, 32);
        layeredPane.add(TitleVal);
        TitleVal.setColumns(10);
        
        JLayeredPane layeredPane2 = new JLayeredPane();
        layeredPane2.setBounds(118, 84, 367, 174);
        layeredPane.add(layeredPane2);
        JTextArea ContentVal = new JTextArea(4, 180);
        ContentVal.setFont(new Font("Calibri", Font.PLAIN, 20)); 
        ContentVal.setLineWrap(true);
        JScrollPane scr = new JScrollPane(ContentVal, 
        								// Hide the horizontal scroll bar policy
        								JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
        								JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        layeredPane2.setLayout(new BorderLayout());
        layeredPane2.add(scr, BorderLayout.CENTER);
		
        MyRoundButton btnSave = new MyRoundButton("Save");
        btnSave.setFont(new Font("Calibri", Font.PLAIN, 25));
        btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(TitleVal.getText() == null) {
						JOptionPane.showMessageDialog(null,"Operation error!","Warning",JOptionPane.ERROR_MESSAGE);
					}else if(TitleVal.getText().length() > 20){
						JOptionPane.showMessageDialog(null,"Input Title is too long!","Warning",JOptionPane.ERROR_MESSAGE);
					}else {
						if( ContentVal.getText()== null) {
							JOptionPane.showMessageDialog(null,"Operation error!","Warning",JOptionPane.ERROR_MESSAGE);
						
						}else {
							// pass the title and content of notes
							NotesWriteController controller = new NotesWriteController();
							//controller.addNote(RecipeName, batchSize, ContentVal.getText());
							boolean add = controller.addNote(RecipeName, TitleVal.getText(),batchSize, ContentVal.getText());
							if(add) {
								JOptionPane.showMessageDialog(null, "Success!");
								closeThis();
								new HomePage();
							}else {
								JOptionPane.showMessageDialog(null,"Fail!","Warning",JOptionPane.ERROR_MESSAGE);
								closeThis();
								new NotesWritePage(RecipeName, batchSize).setVisible(true);
							}
						}
					}
					
			}catch(NullPointerException ex) {
				JOptionPane.showMessageDialog(null,"Please input right information!","Warning",JOptionPane.ERROR_MESSAGE);
			}
		}
		});
        btnSave.setBounds(90, 311, 150, 45);
		contentPane.add(btnSave);
		
		MyRoundButton btnCancel = new MyRoundButton("Cancel");
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
			//contentPane.setVisible(false);
			this.dispose();
		}
}
