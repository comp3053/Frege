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

public class BrewPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public BrewPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		
		// Put in center
		int windowWidth = contentPane.getWidth();
		int windowHeight = contentPane.getHeight();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		contentPane.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
		
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
		
		JLabel lblBatchSizeL = new JLabel("Batch size                  L beer today~");
		lblBatchSizeL.setHorizontalAlignment(SwingConstants.CENTER);
		lblBatchSizeL.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblBatchSizeL.setBounds(24, 191, 533, 47);
		contentPane.add(lblBatchSizeL);
		
		BrewController EquipController = new BrewController();
		float capacity= EquipController.getCapacity();
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 20));
		textField.setBounds(234, 201, 86, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(478, 29, 90, 32);
		contentPane.add(btnHome);
		btnHome.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new HomePage();
			}
		});
		
		JButton btnCan = new JButton("Go!");
		btnCan.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnCan.setBounds(208, 273, 153, 39);
		contentPane.add(btnCan);
		btnCan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Get input String and transfer into integer
				String cBatch = textField.getText().trim();
				if(cBatch.equals("")) {
					//warning
					JOptionPane.showMessageDialog(null,"Operation error!","Warning",JOptionPane.ERROR_MESSAGE);
					closeThis();
					new BrewPage().setVisible(true);
				}else {
					try {
						float batch = Integer.parseInt(cBatch);
						if(batch < 0) {
							JOptionPane.showMessageDialog(null,"Please input a positive number!","Warning",JOptionPane.ERROR_MESSAGE);
						}else if(batch > capacity) {
							JOptionPane.showMessageDialog(null,"Can't brew more than "+capacity+" L!","Warning",JOptionPane.ERROR_MESSAGE);
						}else {
							ArrayList<String> RecipeList = new ArrayList<String>();
							BrewController controller = new BrewController();
							RecipeList = controller.recommandRecipe(batch);
							int length = RecipeList.size();
							
							if(length > 0) {
								closeThis();
								new SelectRecipesPage(batch,RecipeList).setVisible(true);
							}else {
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
