package UI;

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
import java.awt.Label;

public class RecipePage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecipePage window = new RecipePage();
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
	public RecipePage() {
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
		
		JLabel lblRecipes = new JLabel("Recipes");
		lblRecipes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipes.setFont(new Font("Calibri", Font.BOLD, 35));
		lblRecipes.setBounds(205, 126, 168, 52);
		frame.getContentPane().add(lblRecipes);
		
		// Set Buttons
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(478, 29, 90, 32);
		frame.getContentPane().add(btnHome);
		btnHome.setFont(new Font("Calibri", Font.PLAIN, 15));
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(53, 256, 130, 52);
		frame.getContentPane().add(btnAdd);
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 25));
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(223, 256, 130, 52);
		frame.getContentPane().add(btnDelete);
		btnDelete.setFont(new Font("Calibri", Font.PLAIN, 25));
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(392, 256, 130, 52);
		frame.getContentPane().add(btnUpdate);
		btnUpdate.setFont(new Font("Calibri", Font.PLAIN, 25));
		
		// Page Jump
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
		frame.setVisible(false);
	}

}
