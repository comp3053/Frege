package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JEditorPane;

public class IngredientCheckPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String name = "Recipes1";
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngredientCheckPage frame = new IngredientCheckPage(name);
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
	public IngredientCheckPage(String Name) {
		System.out.println(Name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("You Need :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel.setBounds(45, 35, 175, 52);
		contentPane.add(lblNewLabel);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(14, 86, 554, 213);
		contentPane.add(layeredPane);
		
		JLabel lblNewLabel_1 = new JLabel("Ingredient 1");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(14, 13, 115, 27);
		layeredPane.add(lblNewLabel_1);
		
		JLabel lblIngredient = new JLabel("Ingredient 2");
		lblIngredient.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngredient.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblIngredient.setBounds(14, 58, 115, 27);
		layeredPane.add(lblIngredient);
		
		JLabel lblIngredient_1 = new JLabel("Ingredient 3");
		lblIngredient_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngredient_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblIngredient_1.setBounds(14, 106, 115, 27);
		layeredPane.add(lblIngredient_1);
		
		JLabel lblIngredient_2 = new JLabel("Ingredient 4");
		lblIngredient_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngredient_2.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblIngredient_2.setBounds(14, 157, 115, 27);
		layeredPane.add(lblIngredient_2);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(143, 13, 50, 27);
		layeredPane.add(editorPane);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(143, 58, 50, 27);
		layeredPane.add(editorPane_1);
		
		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setBounds(143, 106, 50, 27);
		layeredPane.add(editorPane_2);
		
		JEditorPane editorPane_3 = new JEditorPane();
		editorPane_3.setBounds(143, 157, 50, 27);
		layeredPane.add(editorPane_3);
		
		JLabel lblKg = new JLabel("kg");
		lblKg.setHorizontalAlignment(SwingConstants.CENTER);
		lblKg.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblKg.setBounds(204, 13, 36, 27);
		layeredPane.add(lblKg);
		
		JLabel label = new JLabel("kg");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Calibri", Font.PLAIN, 20));
		label.setBounds(204, 58, 36, 27);
		layeredPane.add(label);
		
		JLabel label_1 = new JLabel("kg");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		label_1.setBounds(204, 106, 36, 27);
		layeredPane.add(label_1);
		
		JLabel label_2 = new JLabel("kg");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Calibri", Font.PLAIN, 20));
		label_2.setBounds(204, 157, 36, 27);
		layeredPane.add(label_2);
		
		JEditorPane editorPane_4 = new JEditorPane();
		editorPane_4.setBounds(243, 13, 50, 27);
		layeredPane.add(editorPane_4);
		
		JEditorPane editorPane_5 = new JEditorPane();
		editorPane_5.setBounds(243, 58, 50, 27);
		layeredPane.add(editorPane_5);
		
		JEditorPane editorPane_6 = new JEditorPane();
		editorPane_6.setBounds(243, 106, 50, 27);
		layeredPane.add(editorPane_6);
		
		JEditorPane editorPane_7 = new JEditorPane();
		editorPane_7.setBounds(243, 157, 50, 27);
		layeredPane.add(editorPane_7);
		
		JEditorPane editorPane_8 = new JEditorPane();
		editorPane_8.setBounds(412, 106, 50, 27);
		layeredPane.add(editorPane_8);
		
		JLabel lblMissed = new JLabel("Missed");
		lblMissed.setHorizontalAlignment(SwingConstants.CENTER);
		lblMissed.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblMissed.setBounds(322, 106, 100, 27);
		layeredPane.add(lblMissed);
		
		JLabel label_3 = new JLabel("kg");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Calibri", Font.PLAIN, 20));
		label_3.setBounds(466, 106, 36, 27);
		layeredPane.add(label_3);
		
		JLabel label_4 = new JLabel("Missed");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Calibri", Font.PLAIN, 20));
		label_4.setBounds(322, 157, 100, 27);
		layeredPane.add(label_4);
		
		JEditorPane editorPane_9 = new JEditorPane();
		editorPane_9.setBounds(412, 157, 50, 27);
		layeredPane.add(editorPane_9);
		
		JLabel label_5 = new JLabel("kg");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Calibri", Font.PLAIN, 20));
		label_5.setBounds(466, 157, 36, 27);
		layeredPane.add(label_5);
		
		JButton btnBrew = new JButton("Back");
		btnBrew.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnBrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new CheckRecipesPage().setVisible(true);
			}
		});
		btnBrew.setBounds(90, 311, 150, 45);
		contentPane.add(btnBrew);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new BrewPage().setVisible(true);
			}
		});
		btnCancel.setBounds(347, 311, 150, 45);
		contentPane.add(btnCancel);
	}
	// Close current UI page
		protected void closeThis() {
			contentPane.setVisible(false);
		}
}
