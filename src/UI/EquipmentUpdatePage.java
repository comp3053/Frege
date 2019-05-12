package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import Controller.BrewController;
import Controller.EquipmentUpdateController;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import Controller.EquipmentUpdateController;
import javafx.scene.control.Spinner;

public class EquipmentUpdatePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public EquipmentUpdatePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEquipment = new JLabel("Equipment 1");
		lblEquipment.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipment.setFont(new Font("Calibri", Font.BOLD, 30));
		lblEquipment.setBounds(201, 36, 190, 72);
		contentPane.add(lblEquipment);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(90, 119, 407, 181);
		contentPane.add(layeredPane);
		
		JLabel lblCapacity = new JLabel("Capacity:");
		lblCapacity.setBounds(39, 72, 112, 40);
		layeredPane.add(lblCapacity);
		lblCapacity.setFont(new Font("Calibri", Font.BOLD, 25));
		lblCapacity.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spinner.setFont(new Font("Calibri", Font.PLAIN, 18));
		spinner.setBounds(264, 74, 65, 38);
		layeredPane.add(spinner);
		
		EquipmentUpdateController controller = new EquipmentUpdateController();
		float capacity = (float) spinner.getValue();
		controller.updateEquipment(capacity);
		
		JLabel lblLiters = new JLabel("liters");
		lblLiters.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblLiters.setBounds(335, 85, 58, 18);
		layeredPane.add(lblLiters);
		
		JLabel label = new JLabel("\u2192");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Calibri", Font.PLAIN, 18));
		label.setBounds(220, 85, 44, 18);
		layeredPane.add(label);
		
		String cEquipment = textField.getText().trim();
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
				try {
					//Temporarily missing operations on the database
					float size = (float) spinner.getValue();
					if(size < 0) {
						//If the operation fails, do not change the database and refresh the current page
						JOptionPane.showMessageDialog(null,"Operation error!","Warning",JOptionPane.ERROR_MESSAGE);
						closeThis();
						new EquipmentUpdatePage().setVisible(true);
					}else {
						EquipmentUpdateController controller = new EquipmentUpdateController();
						JOptionPane.showMessageDialog(null, "Success!");
						closeThis();
						new EquipmentPage().setVisible(true);
					}
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,"Please input a number!","Warning",JOptionPane.ERROR_MESSAGE);
=======
				if(cEquipment.equals("")) {
					//warning
					JOptionPane.showMessageDialog(null,"Operation error!","Warning",JOptionPane.ERROR_MESSAGE);
					closeThis();
					new EquipmentUpdatePage().setVisible(true);
				}else {
					try {
						float l = Integer.parseInt(cEquipment);
						if(l < 0) {
							JOptionPane.showMessageDialog(null,"Please input a positive number!","Warning",JOptionPane.ERROR_MESSAGE);
						}else {
							EquipmentUpdateController controller = new EquipmentUpdateController();
							boolean check = controller.equals(l);
							
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
				
>>>>>>> branch 'master' of https://github.com/comp3053/Frege.git
			}
		}
		});
		btnUpdate.setBounds(90, 311, 150, 45);
		contentPane.add(btnUpdate);
		
		JButton btnCancel = new JButton("Cancel");
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
