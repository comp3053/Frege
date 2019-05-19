package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.IngredientAddController;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

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
		lblIngredient.setBounds(161, 23, 238, 52);
		contentPane.add(lblIngredient);
		
		// Show Our the amount of ingredients in database
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(new java.awt.Color(255, 255, 255));
		layeredPane.setBorder(new LineBorder(new java.awt.Color(0, 0, 0)));
		layeredPane.setBounds(24, 69, 527, 230);
		contentPane.add(layeredPane);
		layeredPane.setLayout(null);
		
		JLabel lblMalts = new JLabel("Malts");
		lblMalts.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMalts.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblMalts.setBounds(94, 33, 99, 31);
		layeredPane.add(lblMalts);
		
		JLabel lblHops = new JLabel("Hops");
		lblHops.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHops.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblHops.setBounds(94, 67, 99, 31);
		layeredPane.add(lblHops);
		
		JLabel lblYeasts = new JLabel("Yeasts");
		lblYeasts.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYeasts.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblYeasts.setBounds(94, 101, 99, 31);
		layeredPane.add(lblYeasts);
		
		JLabel lblSugars = new JLabel("Sugars");
		lblSugars.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSugars.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblSugars.setBounds(94, 135, 99, 31);
		layeredPane.add(lblSugars);
		
		JLabel lblAdditives = new JLabel("Additives");
		lblAdditives.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdditives.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblAdditives.setBounds(72, 170, 121, 31);
		layeredPane.add(lblAdditives);
		
		// call controller to get the ingredient amount in database 
		IngredientAddController controller1 = new IngredientAddController();
				
		float x1 = controller1.searchQuantity("Malts");
		String cMalts = Float.toString(x1);
		JLabel lblAmountMalts= new JLabel(cMalts);
		lblAmountMalts.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountMalts.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblAmountMalts.setBounds(207, 33, 133, 31);
		layeredPane.add(lblAmountMalts);
				
		float x2 = controller1.searchQuantity("Hops");
		String cHops = Float.toString(x2);
		JLabel lblAmountHops = new JLabel(cHops);
		lblAmountHops.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountHops.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblAmountHops.setBounds(207, 67, 133, 31);
		layeredPane.add(lblAmountHops);
				
		float x3 = controller1.searchQuantity("Yeasts");
		String cYeasts = Float.toString(x3);
		JLabel lblAmountYeasts = new JLabel(cYeasts);
		lblAmountYeasts.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountYeasts.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblAmountYeasts.setBounds(207, 101, 133, 31);
		layeredPane.add(lblAmountYeasts);
				
		float x4 = controller1.searchQuantity("Sugars");
		String cSugars = Float.toString(x4);
		JLabel lblAmountSugars = new JLabel(cSugars);
		lblAmountSugars.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountSugars.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblAmountSugars.setBounds(207, 135, 133, 31);
		layeredPane.add(lblAmountSugars);
				
		float x5 = controller1.searchQuantity("Additives");
		String cAdditives = Float.toString(x5);
		JLabel lblAmountAdditives = new JLabel(cAdditives);
		lblAmountAdditives.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountAdditives.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblAmountAdditives.setBounds(207, 170, 133, 31);
		layeredPane.add(lblAmountAdditives);
		
		JLabel lblKg = new JLabel("kg");
		lblKg.setHorizontalAlignment(SwingConstants.LEFT);
		lblKg.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblKg.setBounds(347, 33, 99, 31);
		layeredPane.add(lblKg);
		
		JLabel lblKg_4 = new JLabel("kg");
		lblKg_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblKg_4.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblKg_4.setBounds(347, 170, 99, 31);
		layeredPane.add(lblKg_4);
		
		JLabel lblKg_3 = new JLabel("kg");
		lblKg_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblKg_3.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblKg_3.setBounds(347, 135, 99, 31);
		layeredPane.add(lblKg_3);
		
		JLabel lblKg_2 = new JLabel("kg");
		lblKg_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblKg_2.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblKg_2.setBounds(347, 101, 99, 31);
		layeredPane.add(lblKg_2);
		
		JLabel lblKg_1 = new JLabel("kg");
		lblKg_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblKg_1.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblKg_1.setBounds(347, 67, 99, 31);
		layeredPane.add(lblKg_1);
		
		// Set Buttons
		MyRoundButton btnAdd = new MyRoundButton("Add");
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnAdd.setBounds(63, 306, 188, 52);
		contentPane.add(btnAdd);
		
		MyRoundButton btnSubtract = new MyRoundButton("Subtract");
		btnSubtract.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnSubtract.setBounds(318, 306, 188, 52);
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
