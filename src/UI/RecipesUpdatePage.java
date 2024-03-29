package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.RecipesAddController;
import Controller.RecipesUpdateController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RecipesUpdatePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the frame.
	 */
	public RecipesUpdatePage() {
		setTitle("BrewDay! [Frege]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(contentPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Name:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Calibri", Font.PLAIN, 25));
		label.setBounds(31, 66, 113, 25);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(141, 66, 106, 26);
		contentPane.add(textField);
		
		/*JComboBox comboBox = new JComboBox();
		comboBox.setBounds(249, 66, 26, 26);
		contentPane.add(comboBox);*/
		
		JLabel label_1 = new JLabel("Malts:");
		label_1.setFont(new Font("Calibri", Font.PLAIN, 25));
		label_1.setBounds(31, 133, 89, 25);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(141, 132, 86, 24);
		contentPane.add(textField_1);
		
		JLabel label_2 = new JLabel("kg");
		label_2.setFont(new Font("Calibri", Font.PLAIN, 20));
		label_2.setBounds(231, 128, 26, 39);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Hops:");
		label_3.setFont(new Font("Calibri", Font.PLAIN, 25));
		label_3.setBounds(31, 194, 89, 31);
		contentPane.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(141, 199, 86, 24);
		contentPane.add(textField_2);
		
		JLabel label_4 = new JLabel("kg");
		label_4.setFont(new Font("Calibri", Font.PLAIN, 20));
		label_4.setBounds(231, 192, 26, 39);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Yeasts:");
		label_5.setFont(new Font("Calibri", Font.PLAIN, 25));
		label_5.setBounds(289, 66, 125, 31);
		contentPane.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(415, 68, 86, 24);
		contentPane.add(textField_3);
		
		JLabel label_6 = new JLabel("kg");
		label_6.setFont(new Font("Calibri", Font.PLAIN, 20));
		label_6.setBounds(506, 61, 26, 39);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Sugars:");
		label_7.setFont(new Font("Calibri", Font.PLAIN, 25));
		label_7.setBounds(289, 127, 125, 31);
		contentPane.add(label_7);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(415, 132, 86, 24);
		contentPane.add(textField_4);
		
		JLabel label_8 = new JLabel("kg");
		label_8.setFont(new Font("Calibri", Font.PLAIN, 20));
		label_8.setBounds(506, 128, 26, 39);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("Additives:");
		label_9.setFont(new Font("Calibri", Font.PLAIN, 25));
		label_9.setBounds(289, 197, 151, 31);
		contentPane.add(label_9);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(415, 199, 86, 24);
		contentPane.add(textField_5);
		
		JLabel label_10 = new JLabel("kg");
		label_10.setFont(new Font("Calibri", Font.PLAIN, 20));
		label_10.setBounds(506, 192, 26, 39);
		contentPane.add(label_10);
		
		// Set Buttons
		MyRoundButton btnUpdate = new MyRoundButton("Update");
		btnUpdate.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnUpdate.setBounds(87, 301, 140, 39);
		contentPane.add(btnUpdate);
		
		MyRoundButton btnCancel = new MyRoundButton("Cancel");
		btnCancel.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnCancel.setBounds(336, 302, 140, 37);
		contentPane.add(btnCancel);
		
		// Page Jump
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Get the input information
				String cName = textField.getText().trim();
				String cMalts = textField_1.getText().trim();
				String cHops = textField_2.getText().trim();
				String cYeasts = textField_3.getText().trim();
				String cSugars = textField_4.getText().trim();
				String cAdditives = textField_5.getText().trim();
				
				if(cName.equals("")||cMalts.equals("")||cHops.equals("")||cYeasts.equals("")||cSugars.equals("")||cAdditives.equals("")) {
					//If the operation fails, do not change the database and refresh the current page
					JOptionPane.showMessageDialog(null,"Please fill all blanks! <(*ToT*)>","Warning",JOptionPane.ERROR_MESSAGE);
					closeThis();
					new RecipesUpdatePage().setVisible(true);
				}else {
					
					try {
						//Transfer String into integer
						float malts = Float.valueOf(cMalts);
						float hops = Float.valueOf(cHops);
						float yeasts = Float.valueOf(cYeasts);
						float sugars = Float.valueOf(cSugars);
						float additives = Float.valueOf(cAdditives);
						
						if (malts<0||hops<0||yeasts<0||sugars<0||additives<0) {
							// If input a negative number it will be error 
							JOptionPane.showMessageDialog(null,"Please input a positive number! <(*ToT*)>","Warning",JOptionPane.ERROR_MESSAGE);
						}else {
							RecipesUpdateController controllerUI = new RecipesUpdateController();
							boolean check = controllerUI.updateRecipe(cName, malts, hops, yeasts, sugars, additives);
							
							if(check) {
								//If the operation is successful, modify the database and return to RecipePage
								JOptionPane.showMessageDialog(null, "Success! (*^ w ^*)");
								closeThis();
								new RecipePage();
							}else {
								JOptionPane.showMessageDialog(null,"Update fail! (* X *)","Warning",JOptionPane.ERROR_MESSAGE);
								closeThis();
								new RecipesUpdatePage().setVisible(true);
							}
							
						}
					}catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(null,"Please input a number! (> w <)","Warning",JOptionPane.ERROR_MESSAGE);
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
