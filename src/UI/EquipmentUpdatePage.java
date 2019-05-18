package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.BrewController;
import Controller.EquipmentController;
import Controller.EquipmentUpdateController;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EquipmentUpdatePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public EquipmentUpdatePage() {
		setTitle("BrewDay! [Frege]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(contentPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEquipment = new JLabel("Equipment 1");
		lblEquipment.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipment.setFont(new Font("Calibri", Font.BOLD, 30));
		lblEquipment.setBounds(110, 36, 345, 72);
		contentPane.add(lblEquipment);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(14, 121, 554, 181);
		contentPane.add(layeredPane);
		
		JLabel lblCapacity = new JLabel("Capacity:");
		lblCapacity.setBounds(14, 71, 151, 40);
		layeredPane.add(lblCapacity);
		lblCapacity.setFont(new Font("Calibri", Font.BOLD, 25));
		lblCapacity.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Calibri", Font.PLAIN, 20));
		textField.setBounds(353, 74, 101, 38);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblLiters = new JLabel("liters");
		lblLiters.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblLiters.setBounds(468, 85, 72, 18);
		layeredPane.add(lblLiters);
		
		JLabel label = new JLabel("\u2192");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Calibri", Font.PLAIN, 18));
		label.setBounds(299, 84, 44, 18);
		layeredPane.add(label);
		
		EquipmentController controller1 = new EquipmentController();
		JLabel lblNumber = new JLabel("number");
		lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNumber.setBounds(191, 71, 94, 40);
		lblNumber.setText(Float.toString(controller1.getCapacity()));
		layeredPane.add(lblNumber);
		
		
		MyRoundButton btnUpdate = new MyRoundButton("Update");
		btnUpdate.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// get the number
				String cEquipment = textField.getText().trim();
				System.out.println(cEquipment);
				
				if(cEquipment.equals("")) {
					//warning
					JOptionPane.showMessageDialog(null,"Operation error!","Warning",JOptionPane.ERROR_MESSAGE);
					closeThis();
					new EquipmentUpdatePage().setVisible(true);
				}else {
					try {
						float l = Float.valueOf(cEquipment);
						if(l < 0) {
							JOptionPane.showMessageDialog(null,"Please input a positive number!","Warning",JOptionPane.ERROR_MESSAGE);
						}else {
							EquipmentUpdateController controller = new EquipmentUpdateController();
							boolean check = controller.updateEquipment(l);
							
							if(check) {
								JOptionPane.showMessageDialog(null, "Success!");
								closeThis();
								new EquipmentPage().setVisible(true);
							}else {
								JOptionPane.showMessageDialog(null,"Fail!","Warning",JOptionPane.ERROR_MESSAGE);
								closeThis();
								new EquipmentPage().setVisible(true);
							}
						}
					}catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(null,"Please input a number!","Warning",JOptionPane.ERROR_MESSAGE);
					}	
				}
				
			}
		});
		btnUpdate.setBounds(90, 311, 150, 45);
		contentPane.add(btnUpdate);
		
		MyRoundButton btnCancel = new MyRoundButton("Cancel");
		btnCancel.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new EquipmentPage().setVisible(true);;
			}
		});
		btnCancel.setBounds(347, 311, 150, 45);
		contentPane.add(btnCancel);
	}
	// Close current UI page
	protected void closeThis() {
		//contentPane.setVisible(false);
		this.dispose();
	}
}
