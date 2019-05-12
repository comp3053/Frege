package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class HomePage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frame.setVisible(true);
		
		JLabel lblBrewDay = new JLabel("Brew Day!");
		lblBrewDay.setFont(new Font("Calibri", Font.BOLD, 35));
		lblBrewDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrewDay.setBounds(188, 67, 187, 65);
		frame.getContentPane().add(lblBrewDay);
		
		JButton btnRecipes = new JButton("Recipes");
		btnRecipes.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnRecipes.setBounds(57, 145, 201, 39);
		frame.getContentPane().add(btnRecipes);
		btnRecipes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeThis();
				new RecipePage();
			}
		});
		
		JButton btnIngredients = new JButton("Ingredients");
		btnIngredients.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnIngredients.setBounds(321, 145, 204, 39);
		frame.getContentPane().add(btnIngredients);
		btnIngredients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeThis();
				new IngredientPage().setVisible(true);
			}
		});
		
		JButton btnBrew = new JButton("Brew");
		btnBrew.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnBrew.setBounds(188, 208, 204, 39);
		frame.getContentPane().add(btnBrew);
		btnBrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeThis();
				new BrewPage().setVisible(true);
			}
		});
		
		JButton btnNotes = new JButton("Notes");
		btnNotes.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnNotes.setBounds(57, 270, 204, 39);
		frame.getContentPane().add(btnNotes);
		btnNotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeThis();
				new NotesPage().setVisible(true);
			}
		});
		
		JButton btnEquipemnt = new JButton("Equipemnt");
		btnEquipemnt.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnEquipemnt.setBounds(321, 270, 204, 39);
		frame.getContentPane().add(btnEquipemnt);
		btnEquipemnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeThis();
				new EquipmentPage().setVisible(true);
			}
		});
	}
	
	// Close current UI page
	protected void closeThis() {
		//frame.setVisible(false);
		frame.dispose();
	}
}
