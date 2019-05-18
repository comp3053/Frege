package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.BrewController;
import Controller.IngredientSubtractController;
import mainPart.Recipe;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class BrewPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public BrewPage() {
		setTitle("BrewDay! [Frege]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// Make the UI page in the center
		setLocationRelativeTo(contentPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		
		JLabel lblBrew = new JLabel("Brew");
		lblBrew.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrew.setFont(new Font("Calibri", Font.BOLD, 30));
		lblBrew.setBounds(200, 78, 161, 53);
		contentPane.add(lblBrew);
		
		JLabel lblRecommendARecipe = new JLabel("Recommend a Recipe");
		lblRecommendARecipe.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblRecommendARecipe.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecommendARecipe.setBounds(147, 130, 281, 47);
		contentPane.add(lblRecommendARecipe);
		
		JLabel lblBatchSizeL = new JLabel("Entry a batch size                  L ");
		lblBatchSizeL.setHorizontalAlignment(SwingConstants.CENTER);
		lblBatchSizeL.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblBatchSizeL.setBounds(24, 191, 533, 47);
		contentPane.add(lblBatchSizeL);
		
		// Call the controller to link with database to get the capacity of equipment
		BrewController EquipController = new BrewController();
		float capacity= EquipController.getCapacity();
		
		// TextField for input
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 20));
		textField.setBounds(328, 201, 86, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		// Button
		MyRoundButton btnHome = new MyRoundButton("Home");
		btnHome.setBounds(478, 29, 90, 32);
		contentPane.add(btnHome);
		btnHome.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// When click "Home", go back to HomePage
				closeThis();
				new HomePage();
			}
		});
		
		MyRoundButton btnCan = new MyRoundButton("Go!");
		btnCan.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnCan.setBounds(208, 273, 153, 39);
		contentPane.add(btnCan);
		btnCan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Get input String and transfer into integer
				String cBatch = textField.getText().trim();
				if(cBatch.equals("")) {
					//warning: if user did not input anything
					JOptionPane.showMessageDialog(null,"Operation error!","Warning",JOptionPane.ERROR_MESSAGE);
					//Refresh this page
					closeThis();
					new BrewPage().setVisible(true);
				}else {
					//Type changing, so need Exception to catch the error
					try {
						// change the input string into float
						float batch = Float.valueOf(cBatch);
						if(batch < 0) {
							// if input is smaller then 0, error
							JOptionPane.showMessageDialog(null,"Please input a positive number!","Warning",JOptionPane.ERROR_MESSAGE);
						}else if(batch > capacity) {
							// if input is larger than the capacity in database, can't brew
							JOptionPane.showMessageDialog(null,"Can't brew more than "+capacity+" L!","Warning",JOptionPane.ERROR_MESSAGE);
						}else {
							// call controller to change the database, and it will return an arrayList we can brew now
							ArrayList<String> RecipeList = new ArrayList<String>();
							BrewController controller = new BrewController();
							RecipeList = controller.recommandRecipe(batch);
							// get the size of returning arraylist
							int length = RecipeList.size();
							
							if(length > 0) {
								// if size is larger than 0, it means we have at least one recipe can brew now
								// so go the the SelectRecipesPage(the recipes list we can brew)
								closeThis();
								new SelectRecipesPage(batch,RecipeList).setVisible(true);
							}else {
								// if size is 0, it means we can't brew anything because the ingredients are not  enough
								// so go to the CheckRecipesPage to check the ingredients we missed
								closeThis();
								new CheckRecipesPage(batch).setVisible(true);
							}
						}
					}catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(null,"Please input a number!","Warning",JOptionPane.ERROR_MESSAGE);
					}	
				}
			}
		});
		
	}
	
	// Close current UI page
	protected void closeThis() {
		//contentPane.setVisible(false);
		this.dispose();
	}
}
