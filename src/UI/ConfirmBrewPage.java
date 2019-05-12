package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.SelectRecipesController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmBrewPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmBrewPage frame = new ConfirmBrewPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ConfirmBrewPage(String Name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConfirm = new JLabel("Confirm?");
		lblConfirm.setFont(new Font("Calibri", Font.BOLD, 35));
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setBounds(204, 98, 200, 70);
		contentPane.add(lblConfirm);
		
		JButton btnYes = new JButton("Yes");
		btnYes.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//operation with controller£¬then it  will return the boolean for operation
				//decide the page jump by boolean
				SelectRecipesController controller = new SelectRecipesController();
				boolean check = controller.brewRecipe(Name);
				if(check) {
					JOptionPane.showMessageDialog(null, "Success!");
					closeThis();
					new HomePage();
				}else {
					JOptionPane.showMessageDialog(null,"Fail!","Warning",JOptionPane.ERROR_MESSAGE);
					closeThis();
					new HomePage();
				}
				
			}
		});
		btnYes.setBounds(89, 248, 150, 45);
		contentPane.add(btnYes);
		
		JButton btnCancel = new JButton("Cancel");
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
		contentPane.setVisible(false);
	}

}
