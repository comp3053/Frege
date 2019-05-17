package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class IngredientPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public IngredientPage() {
		setTitle("BrewDay! [Frege]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(contentPane);
		contentPane.setVisible(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngredient = new JLabel("Ingredient");
		lblIngredient.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngredient.setFont(new Font("Calibri", Font.BOLD, 35));
		lblIngredient.setBounds(162, 99, 238, 52);
		contentPane.add(lblIngredient);
		
		// Set Buttons
		MyRoundButton btnAdd = new MyRoundButton("Add");
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnAdd.setBounds(64, 229, 188, 52);
		contentPane.add(btnAdd);
		
		MyRoundButton btnSubtract = new MyRoundButton("Subtract");
		btnSubtract.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnSubtract.setBounds(323, 229, 188, 52);
		contentPane.add(btnSubtract);
		
		MyRoundButton btnHome = new MyRoundButton("Home");
		btnHome.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnHome.setBounds(482, 10, 90, 32);
		contentPane.add(btnHome);
		
		// Page Jump
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Click "Home", go back to HomePage
				closeThis();
				new HomePage();
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Click "Add", go to IngredientAddPage
				closeThis();
				new IngredientAddPage().setVisible(true);
			}
		});
		
		btnSubtract.addActionListener(new ActionListener() {
			// Click "Cancel", go to the IngredientSubtractPage 
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new IngredientSubtractPage().setVisible(true);
			}
		});
		
	}
	
	// Close current UI page
	protected void closeThis() {
		//contentPane.setVisible(false);
		this.dispose();
	}

}
