package UI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class HomePage {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBrewday = new JLabel("BrewDay!");
		lblBrewday.setBounds(184, 13, 73, 40);
		frame.getContentPane().add(lblBrewday);
		
		JButton btnRecipe = new JButton("Recipe");
		btnRecipe.setBounds(42, 66, 113, 27);
		frame.getContentPane().add(btnRecipe);
		
		JButton btnIngredient = new JButton("Ingredient");
		btnIngredient.setBounds(265, 66, 113, 27);
		frame.getContentPane().add(btnIngredient);
		
		JButton btnEquipment = new JButton("Equipment");
		btnEquipment.setBounds(265, 127, 113, 27);
		frame.getContentPane().add(btnEquipment);
		
		JButton btnBrew = new JButton("Brew");
		btnBrew.setBounds(42, 127, 113, 27);
		frame.getContentPane().add(btnBrew);
		
		frame.setVisible(true);
	}
}
