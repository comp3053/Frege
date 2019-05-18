package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.Label;

public class RecipePage {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public RecipePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setTitle("BrewDay! [Frege]");
		frame.setBounds(100, 100, 600, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		// Put in center
		int windowWidth = frame.getWidth();
		int windowHeight = frame.getHeight();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
		
		JLabel lblRecipes = new JLabel("Recipes");
		lblRecipes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipes.setFont(new Font("Calibri", Font.BOLD, 35));
		lblRecipes.setBounds(202, 97, 168, 52);
		frame.getContentPane().add(lblRecipes);
		
		// Set Buttons
		MyRoundButton btnHome = new MyRoundButton("Home");
		btnHome.setBounds(478, 29, 90, 32);
		frame.getContentPane().add(btnHome);
		btnHome.setFont(new Font("Calibri", Font.PLAIN, 15));
		
		MyRoundButton btnAdd = new MyRoundButton("Add");
		btnAdd.setBounds(53, 256, 130, 52);
		frame.getContentPane().add(btnAdd);
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 25));
		
		MyRoundButton btnDelete = new MyRoundButton("Delete");
		btnDelete.setBounds(223, 256, 130, 52);
		frame.getContentPane().add(btnDelete);
		btnDelete.setFont(new Font("Calibri", Font.PLAIN, 25));
		
		MyRoundButton btnUpdate = new MyRoundButton("Update");
		btnUpdate.setBounds(392, 256, 130, 52);
		frame.getContentPane().add(btnUpdate);
		btnUpdate.setFont(new Font("Calibri", Font.PLAIN, 25));
		
		UI.MyRoundButton btnCheck = new UI.MyRoundButton("Check");
		btnCheck.setText("Check");
		btnCheck.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnCheck.setBounds(222, 186, 130, 52);
		frame.getContentPane().add(btnCheck);
		
		// Page Jump
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeThis();
				new RecipesCheckPage().setVisible();
			}
		});
		
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeThis();
				new HomePage();
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeThis();
				new RecipesAddPage().setVisible(true);
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new RecipesDeletePage().setVisible(true);;
			}
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new RecipesUpdatePage().setVisible(true);;
			}
		});
		
	}
	
	// Close current UI page
	protected void closeThis() {
		//frame.setVisible(false);
		frame.dispose();
	}

}
