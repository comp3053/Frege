package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.RecipesDeleteController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class RecipesDeletePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public RecipesDeletePage() {
		setTitle("BrewDay! [Frege]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(contentPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteRecipe = new JLabel("Delete Recipe");
		lblDeleteRecipe.setFont(new Font("Calibri", Font.BOLD, 30));
		lblDeleteRecipe.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteRecipe.setBounds(149, 91, 252, 47);
		contentPane.add(lblDeleteRecipe);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Calibri", Font.PLAIN, 30));
		lblName.setBounds(99, 177, 113, 30);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 20));
		textField.setBounds(226, 177, 140, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		// Set Buttons
		MyRoundButton btnDelete = new MyRoundButton("Delete");
		btnDelete.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnDelete.setBounds(99, 283, 113, 39);
		contentPane.add(btnDelete);
		
		MyRoundButton btnCancel = new MyRoundButton("Cancel");
		btnCancel.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnCancel.setBounds(373, 283, 113, 39);
		contentPane.add(btnCancel);
		
		// Page Jump
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField.getText().trim();
				if(name.equals("")) {
					//If the operation fails, do not change the database and refresh the current page
					JOptionPane.showMessageDialog(null,"Operation error!","Warning",JOptionPane.ERROR_MESSAGE);
					closeThis();
					new RecipesDeletePage().setVisible(true);
				}else {
					RecipesDeleteController controller = new RecipesDeleteController();
					Boolean check = controller.deleteR(name);
					if(check) {
						//If the operation is successful, modify the database and return to RecipePage
						JOptionPane.showMessageDialog(null, "Success!");
						closeThis();
						new RecipePage();
					}else {
						JOptionPane.showMessageDialog(null,"Fail!","Warning",JOptionPane.ERROR_MESSAGE);
						closeThis();
						new RecipesDeletePage().setVisible(true);
					}	
				}
	
			}
		});
						
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new RecipePage(); //return back to RecipePage
			}
		});
						
	}
					
	// Close current UI page
	protected void closeThis() {
		//contentPane.setVisible(false);
		this.dispose();
	}
}
