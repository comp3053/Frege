package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import javax.swing.JButton;

public class CheckRecipesPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckRecipesPage frame = new CheckRecipesPage();
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
	public CheckRecipesPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRecipeList = new JLabel("Recipe List");
		lblRecipeList.setFont(new Font("Calibri", Font.BOLD, 30));
		lblRecipeList.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipeList.setBounds(215, 27, 165, 37);
		contentPane.add(lblRecipeList);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(14, 83, 554, 287);
		contentPane.add(layeredPane);
		
		JLabel lblRecipe = new JLabel("Recipe 1");
		lblRecipe.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipe.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblRecipe.setBounds(14, 56, 165, 37);
		layeredPane.add(lblRecipe);
		
		JLabel lblRecipe_2 = new JLabel("Recipe 3");
		lblRecipe_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipe_2.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblRecipe_2.setBounds(14, 131, 165, 37);
		layeredPane.add(lblRecipe_2);
		
		JLabel lblRecipe_1 = new JLabel("Recipe 2");
		lblRecipe_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipe_1.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblRecipe_1.setBounds(250, 56, 165, 37);
		layeredPane.add(lblRecipe_1);
		
		JLabel lblRecipe_3 = new JLabel("Recipe 4");
		lblRecipe_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipe_3.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblRecipe_3.setBounds(250, 131, 165, 37);
		layeredPane.add(lblRecipe_3);
		
		JButton btnBrew = new JButton("Brew");
		btnBrew.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnBrew.setBounds(163, 56, 91, 37);
		layeredPane.add(btnBrew);
		btnBrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new IngredientCheckPage().setVisible(true);;
			}
		});
		
		JButton button = new JButton("Brew");
		button.setFont(new Font("Calibri", Font.PLAIN, 20));
		button.setBounds(163, 131, 91, 37);
		layeredPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new IngredientCheckPage().setVisible(true);;
			}
		});
		
		JButton button_1 = new JButton("Brew");
		button_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		button_1.setBounds(400, 56, 91, 37);
		layeredPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new IngredientCheckPage().setVisible(true);;
			}
		});
		
		JButton button_2 = new JButton("Brew");
		button_2.setFont(new Font("Calibri", Font.PLAIN, 20));
		button_2.setBounds(400, 131, 91, 37);
		layeredPane.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new IngredientCheckPage().setVisible(true);;
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(210, 217, 150, 45);
		layeredPane.add(btnCancel);
		btnCancel.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new IngredientCheckPage().setVisible(true);;
			}
		});
	}
	// Close current UI page
			protected void closeThis() {
				contentPane.setVisible(false);
			}
}
