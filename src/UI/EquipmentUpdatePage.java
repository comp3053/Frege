package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
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
import javax.swing.JTextField;

public class EquipmentUpdatePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquipmentUpdatePage frame = new EquipmentUpdatePage();
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
		
		textField = new JTextField();
		textField.setBounds(264, 74, 65, 38);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblLiters = new JLabel("liters");
		lblLiters.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblLiters.setBounds(335, 85, 58, 18);
		layeredPane.add(lblLiters);
		
		JLabel label = new JLabel("\u2192");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Calibri", Font.PLAIN, 18));
		label.setBounds(220, 85, 44, 18);
		layeredPane.add(label);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Success!");
				closeThis();
				new EquipmentPage().setVisible(true);;
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
			contentPane.setVisible(false);
		}
}
