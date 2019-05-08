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
import javax.swing.JTextField;
import javax.swing.JButton;

public class BrewPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrewPage frame = new BrewPage();
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
	public BrewPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBrew = new JLabel("Brew");
		lblBrew.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrew.setFont(new Font("Calibri", Font.BOLD, 30));
		lblBrew.setBounds(200, 78, 161, 53);
		contentPane.add(lblBrew);
		
		JLabel lblRecommendARecipe = new JLabel("Recommend a Recipe");
		lblRecommendARecipe.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblRecommendARecipe.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecommendARecipe.setBounds(147, 130, 281, 47);
		contentPane.add(lblRecommendARecipe);
		
		JLabel lblBatchSizeL = new JLabel("Batch size                  L beer today~");
		lblBatchSizeL.setHorizontalAlignment(SwingConstants.CENTER);
		lblBatchSizeL.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblBatchSizeL.setBounds(107, 190, 375, 47);
		contentPane.add(lblBatchSizeL);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 20));
		textField.setBounds(234, 201, 86, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnGo = new JButton("GO!");
		btnGo.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnGo.setBounds(225, 275, 113, 39);
		contentPane.add(btnGo);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new SelectRecipesPage().setVisible(true);;
			}
		});
	}
	
	// Close current UI page
	protected void closeThis() {
		contentPane.setVisible(false);
	}
}
