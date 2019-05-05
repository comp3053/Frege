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
		
		JLabel lblRecipes = new JLabel("Recipes");
		lblRecipes.setFont(new Font("Calibri", Font.BOLD, 35));
		lblRecipes.setBounds(217, 124, 113, 52);
		frame.getContentPane().add(lblRecipes);
		
		Label label = new Label("Home");
		label.setBounds(524, 29, 44, 25);
		frame.getContentPane().add(label);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(76, 256, 107, 39);
		frame.getContentPane().add(btnAdd);
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 25));
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(223, 256, 107, 39);
		frame.getContentPane().add(btnDelete);
		btnDelete.setFont(new Font("Calibri", Font.PLAIN, 25));
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(378, 256, 107, 39);
		frame.getContentPane().add(btnUpdate);
		btnUpdate.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
}
