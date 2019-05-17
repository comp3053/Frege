package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class ConfirmBrewPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ConfirmBrewPage(String Name,float batchSize) {
		setTitle("BrewDay! [Frege]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(contentPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConfirm = new JLabel("Confirm?");
		lblConfirm.setFont(new Font("Calibri", Font.BOLD, 35));
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setBounds(185, 99, 200, 70);
		contentPane.add(lblConfirm);
		
		MyRoundButton btnYes = new MyRoundButton("Yes");
		btnYes.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//operation with controller��then it  will return the boolean for operation
				//decide the page jump by boolean

				closeThis();
				new NotesWritePage(Name,batchSize).setVisible(true);
				
			}
		});
		btnYes.setBounds(89, 248, 150, 45);
		contentPane.add(btnYes);
		
		MyRoundButton btnCancel = new MyRoundButton("Cancel");
		btnCancel.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new BrewPage().setVisible(true);;
			}
		});
		btnCancel.setBounds(345, 248, 150, 45);
		contentPane.add(btnCancel);
	}
	// Close current UI page
	protected void closeThis() {
		//contentPane.setVisible(false);
		this.dispose();
	}

}
