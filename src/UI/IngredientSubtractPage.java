package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class IngredientSubtractPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngredientSubtractPage frame = new IngredientSubtractPage();
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
	public IngredientSubtractPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddIngredientList = new JLabel("Subtract Ingredient List");
		lblAddIngredientList.setBounds(14, 13, 303, 27);
		lblAddIngredientList.setFont(new Font("Calibri", Font.BOLD, 25));
		contentPane.add(lblAddIngredientList);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(java.awt.Color.WHITE);
		layeredPane.setBorder(new LineBorder(new java.awt.Color(0, 0, 0)));
		layeredPane.setBounds(24, 53, 527, 266);
		contentPane.add(layeredPane);
		layeredPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(41, 13, 72, 31);
		layeredPane.add(lblName);
		lblName.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblAmount.setBounds(198, 13, 122, 31);
		layeredPane.add(lblAmount);
		
		JButton btnSubtract = new JButton("Subtract");
		btnSubtract.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnSubtract.setBounds(94, 332, 136, 38);
		contentPane.add(btnSubtract);
		btnSubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//暂时缺少对数据库的操作
				//Temporarily missing operations on the database
				
				// 如果操作成功，则修改数据库并且返回RecipePage
				//If the operation is successful, modify the database and return to RecipePage
				JOptionPane.showMessageDialog(null, "Success!");
				closeThis();
				new IngredientPage();
				
				//如果操作失败，不改变数据库并且刷新当前页面
				//If the operation fails, do not change the database and refresh the current page
				/*JOptionPane.showMessageDialog(null,"Operation error!","Warning",JOptionPane.ERROR_MESSAGE);
				closeThis();
				new IngredientSubtractPage().setVisible(true);*/
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnCancel.setBounds(344, 332, 136, 38);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeThis();
				new IngredientPage().setVisible(true);
			}
		});
	}
	// Close current UI page
	protected void closeThis() {
		contentPane.setVisible(false);
	}

}
