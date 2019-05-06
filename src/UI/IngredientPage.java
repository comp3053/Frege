package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IngredientPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngredientPage frame = new IngredientPage();
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
	public IngredientPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngredient = new JLabel("Ingredient");
		lblIngredient.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngredient.setFont(new Font("Calibri", Font.BOLD, 35));
		lblIngredient.setBounds(195, 96, 176, 52);
		contentPane.add(lblIngredient);
		
		// Set Buttons
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnAdd.setBounds(107, 230, 125, 39);
		contentPane.add(btnAdd);
		
		JButton btnSubtract = new JButton("Subtract");
		btnSubtract.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnSubtract.setBounds(334, 230, 125, 39);
		contentPane.add(btnSubtract);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnHome.setBounds(482, 10, 90, 32);
		contentPane.add(btnHome);
		
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
				new IngredientAddPage().setVisible(true);
			}
		});
		
		btnSubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new IngredientSubtractPage().setVisible(true);
			}
		});
		
	}
	
	// Close current UI page
		protected void closeThis() {
			contentPane.setVisible(false);
		}

}
