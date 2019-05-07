package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RecipesUpdatePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecipesUpdatePage frame = new RecipesUpdatePage();
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
	public RecipesUpdatePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Name:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Calibri", Font.PLAIN, 25));
		label.setBounds(31, 66, 113, 25);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(141, 66, 106, 26);
		contentPane.add(textField);
		// Get input information
		String name = textField.getText().trim();
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(249, 66, 26, 26);
		contentPane.add(comboBox);
		
		JLabel label_1 = new JLabel("Malts:");
		label_1.setFont(new Font("Calibri", Font.PLAIN, 25));
		label_1.setBounds(31, 133, 89, 25);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(141, 132, 86, 24);
		contentPane.add(textField_1);
		//Get String and transfer into integer
		String cMalts = textField_1.getText().trim();
		int malts = Integer.parseInt(cMalts);
		
		JLabel label_2 = new JLabel("kg");
		label_2.setFont(new Font("Calibri", Font.PLAIN, 20));
		label_2.setBounds(231, 135, 26, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Hops:");
		label_3.setFont(new Font("Calibri", Font.PLAIN, 25));
		label_3.setBounds(31, 194, 89, 31);
		contentPane.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(141, 199, 86, 24);
		contentPane.add(textField_2);
		//Get String and transfer into integer
		String cHops = textField_2.getText().trim();
		int hops = Integer.parseInt(cHops);
		
		JLabel label_4 = new JLabel("kg");
		label_4.setFont(new Font("Calibri", Font.PLAIN, 20));
		label_4.setBounds(231, 202, 26, 18);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Yeasts:");
		label_5.setFont(new Font("Calibri", Font.PLAIN, 25));
		label_5.setBounds(289, 66, 125, 31);
		contentPane.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(415, 68, 86, 24);
		contentPane.add(textField_3);
		//Get String and transfer into integer
		String cYeasts = textField_3.getText().trim();
		int yeasts = Integer.parseInt(cYeasts);
		
		JLabel label_6 = new JLabel("kg");
		label_6.setFont(new Font("Calibri", Font.PLAIN, 20));
		label_6.setBounds(506, 71, 26, 18);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Sugars:");
		label_7.setFont(new Font("Calibri", Font.PLAIN, 25));
		label_7.setBounds(289, 127, 125, 31);
		contentPane.add(label_7);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(415, 132, 86, 24);
		contentPane.add(textField_4);
		//Get String and transfer into integer
		String cSugars = textField_4.getText().trim();
		int sugars = Integer.parseInt(cSugars);
		
		JLabel label_8 = new JLabel("kg");
		label_8.setFont(new Font("Calibri", Font.PLAIN, 20));
		label_8.setBounds(506, 135, 26, 18);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("Additives:");
		label_9.setFont(new Font("Calibri", Font.PLAIN, 25));
		label_9.setBounds(289, 197, 151, 31);
		contentPane.add(label_9);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(415, 199, 86, 24);
		contentPane.add(textField_5);
		//Get String and transfer into integer
		String cAdditives = textField_5.getText().trim();
		int additives= Integer.parseInt(cAdditives);
		
		JLabel label_10 = new JLabel("kg");
		label_10.setFont(new Font("Calibri", Font.PLAIN, 20));
		label_10.setBounds(506, 202, 26, 18);
		contentPane.add(label_10);
		
		// Set Buttons
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnUpdate.setBounds(101, 300, 113, 39);
		contentPane.add(btnUpdate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnCancel.setBounds(344, 302, 113, 37);
		contentPane.add(btnCancel);
		
		// Page Jump
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 暂时空缺修改数据库的行为或页面
				//Temporary vacancies modify the behavior or page of the database
				//应当有一个提示Update成功的页面(操作成功)
				//There should be a page that prompts that Update is successful (operation is successful)
				
				// 如果操作成功，则修改数据库并且返回RecipePage
				//If the operation is successful, modify the database and return to RecipePage
				JOptionPane.showMessageDialog(null, "Success!");
				closeThis();
				new RecipePage();
				
				//如果操作失败，不改变数据库并且刷新当前页面
				//If the operation fails, do not change the database and refresh the current page
				/*JOptionPane.showMessageDialog(null,"Operation error!","Warning",JOptionPane.ERROR_MESSAGE);
				closeThis();
				new RecipesUpdatePage().setVisible(true);*/
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
