package UI;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.RecipesAddController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class RecipesAddPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnAdd;
	private JButton btnCancel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecipesAddPage frame = new RecipesAddPage();
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
	public RecipesAddPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Name input
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setBounds(14, 71, 117, 25);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField.setBounds(132, 71, 110, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		// Malts input
		JLabel lblMalts = new JLabel("Malts:");
		lblMalts.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblMalts.setBounds(14, 139, 93, 25);
		contentPane.add(lblMalts);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField_1.setBounds(132, 141, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblKg = new JLabel("kg");
		lblKg.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblKg.setBounds(221, 144, 26, 18);
		contentPane.add(lblKg);
		
		// Hops input
		JLabel lblHops = new JLabel("Hops:");
		lblHops.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblHops.setBounds(14, 206, 93, 28);
		contentPane.add(lblHops);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField_2.setBounds(132, 210, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		label = new JLabel("kg");
		label.setFont(new Font("Calibri", Font.PLAIN, 20));
		label.setBounds(221, 213, 26, 18);
		contentPane.add(label);
		
		// Yeasts input
		JLabel lblYeasts = new JLabel("Yeasts:");
		lblYeasts.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblYeasts.setBounds(300, 68, 140, 31);
		contentPane.add(lblYeasts);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField_3.setBounds(423, 73, 86, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		label_1 = new JLabel("kg");
		label_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		label_1.setBounds(510, 76, 26, 18);
		contentPane.add(label_1);
		
		// Sugars input
		JLabel lblSugars = new JLabel("Sugars:");
		lblSugars.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblSugars.setBounds(300, 136, 140, 31);
		contentPane.add(lblSugars);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField_4.setBounds(423, 141, 86, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		label_2 = new JLabel("kg");
		label_2.setFont(new Font("Calibri", Font.PLAIN, 20));
		label_2.setBounds(510, 144, 26, 18);
		contentPane.add(label_2);
		
		// Additives input
		JLabel lblAdditives = new JLabel("Additives:");
		lblAdditives.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblAdditives.setBounds(300, 205, 125, 31);
		contentPane.add(lblAdditives);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField_5.setBounds(423, 210, 86, 24);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		label_3 = new JLabel("kg");
		label_3.setFont(new Font("Calibri", Font.PLAIN, 20));
		label_3.setBounds(510, 213, 26, 18);
		contentPane.add(label_3);
		
		// Set Buttons
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnAdd.setBounds(105, 303, 113, 39);
		contentPane.add(btnAdd);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnCancel.setBounds(340, 303, 113, 39);
		contentPane.add(btnCancel);
		
		// Page Jump
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 暂时空缺修改数据库的行为或页面
				//Temporary vacancies modify the behavior or page of the database
				//应当有一个提示add成功的页面
				//There should be a page that prompts that add is successful
				
				String cName = textField.getText().trim();
				String cMalts = textField_1.getText().trim();
				String cHops = textField_2.getText().trim();
				String cYeasts = textField_3.getText().trim();
				String cSugars = textField_4.getText().trim();
				String cAdditives = textField_5.getText().trim();
				
				if(cMalts.equals("")) {
					cMalts = "0";
				}
				if(cHops.equals("")) {
					cHops = "0";
				}
				if(cYeasts.equals("")) {
					cYeasts = "0";
				}
				if(cSugars.equals("")) {
					cSugars = "0";
				}
				if(cAdditives.equals("")) {
					cAdditives = "0";
				}
				
				if(cName.equals("")||cMalts.equals("")||cHops.equals("")||cYeasts.equals("")||cSugars.equals("")||cAdditives.equals("")) {
					
					//如果操作失败，不改变数据库并且刷新当前页面
					//If the operation fails, do not change the database and refresh the current page
					JOptionPane.showMessageDialog(null,"Operation error!","Warning",JOptionPane.ERROR_MESSAGE);
					closeThis();
					new RecipesAddPage().setVisible(true);
				}else {
					
					try {
						//Transfer String into integer
						float malts = Integer.parseInt(cMalts);
						float hops = Integer.parseInt(cHops);
						float yeasts = Integer.parseInt(cYeasts);
						float sugars = Integer.parseInt(cSugars);
						float additives= Integer.parseInt(cAdditives);
						if (malts<0||hops<0||yeasts<0||sugars<0||additives<0) {
							// If input a negative number it will be error 
							JOptionPane.showMessageDialog(null,"Please input a positive number!","Warning",JOptionPane.ERROR_MESSAGE);
						}else {
							// call controller to add recipes into database
							RecipesAddController controllerUI = new RecipesAddController();
							controllerUI.addRecipe(cName, malts, hops, yeasts, sugars, additives);
							
							// 如果操作成功，则修改数据库并且返回RecipePage
							//If the operation is successful, modify the database and return to RecipePage
							JOptionPane.showMessageDialog(null, "Success!");
							closeThis();
							new RecipePage();
						}
					}catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(null,"Please input a number!","Warning",JOptionPane.ERROR_MESSAGE);
					}	
					
				}
			}
		});
				
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new RecipePage();
			}
		});
				
	}
			
	// Close current UI page
	protected void closeThis() {
		contentPane.setVisible(false);
	}
		
}
