package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class RecipesDeletePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecipesDeletePage frame = new RecipesDeletePage();
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
	public RecipesDeletePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteRecipe = new JLabel("Delete Recipe");
		lblDeleteRecipe.setFont(new Font("Calibri", Font.BOLD, 30));
		lblDeleteRecipe.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteRecipe.setBounds(149, 91, 252, 47);
		contentPane.add(lblDeleteRecipe);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Calibri", Font.PLAIN, 30));
		lblName.setBounds(99, 177, 113, 30);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 20));
		textField.setBounds(226, 177, 140, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(366, 177, 29, 30);
		contentPane.add(comboBox);
		
		// Set Buttons
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnDelete.setBounds(99, 283, 113, 39);
		contentPane.add(btnDelete);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnCancel.setBounds(373, 283, 113, 39);
		contentPane.add(btnCancel);
		
		// Page Jump
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 暂时空缺修改数据库的行为或页面
				//应当有一个提示delete成功的页面(操作成功)
			}
		});
						
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new RecipePage(); //return back to RecipePage
			}
		});
						
	}
					
	// Close current UI page
	protected void closeThis() {
		contentPane.setVisible(false);
	}

}
