package UI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.EquipmentController;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EquipmentPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public EquipmentPage() {
		setTitle("BrewDay! [Frege]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(contentPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Equipment");
		lblNewLabel.setBounds(165, 79, 254, 71);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblCapacity = new JLabel("Current Capacity:");
		lblCapacity.setBounds(56, 180, 237, 40);
		contentPane.add(lblCapacity);
		lblCapacity.setFont(new Font("Calibri", Font.BOLD, 25));
		lblCapacity.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		MyRoundButton btnUpdate = new MyRoundButton("Update");
		btnUpdate.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new EquipmentUpdatePage().setVisible(true);;
			}
		});
		btnUpdate.setBounds(219, 266, 150, 45);
		contentPane.add(btnUpdate);
		
		MyRoundButton btnHome = new MyRoundButton("Home");
		btnHome.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new HomePage();
			}
		});
		btnHome.setBounds(460, 28, 89, 27);
		contentPane.add(btnHome);
		
		EquipmentController controller1 = new EquipmentController();
		JLabel lblNumber = new JLabel("number");
		lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNumber.setBounds(273, 180, 155, 40);
		lblNumber.setText(Float.toString(controller1.getCapacity()));
		contentPane.add(lblNumber);
		
		JLabel lblL = new JLabel("L");
		lblL.setHorizontalAlignment(SwingConstants.CENTER);
		lblL.setFont(new Font("Calibri", Font.BOLD, 25));
		lblL.setBounds(414, 180, 64, 40);
		contentPane.add(lblL);
	}
	// Close current UI page
	protected void closeThis() {
		//contentPane.setVisible(false);
		this.dispose();
	}
}
