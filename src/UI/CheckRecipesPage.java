package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controller.BrewController;
import Controller.CheckRecipesController;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.Color;

public class CheckRecipesPage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;


	/**
	 * Create the frame.
	 */
	public CheckRecipesPage(float batchSize) {
		setTitle("BrewDay! [Frege]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(contentPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRecipeList = new JLabel("Check Recipe List");
		lblRecipeList.setFont(new Font("Calibri", Font.BOLD, 30));
		lblRecipeList.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipeList.setBounds(113, 13, 336, 37);
		contentPane.add(lblRecipeList);
		
		// call controller to get all the Recipes List, it return an ArrayList
		ArrayList<String> AllRecipeList = new ArrayList<String>();
		CheckRecipesController controller = new CheckRecipesController();
		AllRecipeList = controller.getAllRecipeName();
		// get the length of returning list
		int length = AllRecipeList.size();
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(14, 50, 554, 279);
		contentPane.add(layeredPane);
		
		// Table Model
		// Rewrite the table can be select but can't be edited
		DefaultTableModel tableModel=new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};	
		tableModel.addColumn("Recipes");
		for(int i = 0;i < length;i++) {
			// put recipe name into table by using Vector
			Vector v = new Vector();
			v.add(AllRecipeList.get(i));
			tableModel.addRow(v);
		}
		        
		// Table
		table = new JTable(tableModel);
		table.setFont(new Font("Calibri", Font.PLAIN, 20));
		table.setRowHeight(30);
		// Dynamic table 
		JScrollPane scroll = new JScrollPane(table);
		scroll.setEnabled(false);
		scroll.setBounds(75, 13, 196, 253);
		layeredPane.add(scroll);
		table.setModel(tableModel);
				
		// Click the table, will choose one recipe to brew 
		String inf;
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			int index;
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				//get the index in table we click
				index = table.getSelectedRow();
				
				//show the select Recipe name
				//String n = (String) table.getValueAt(index, 0);
				/*textField = new JTextField();
				textField.setEditable(false);
				textField.setHorizontalAlignment(SwingConstants.CENTER);
				textField.setFont(new Font("Calibri", Font.PLAIN, 25));
				textField.setBounds(332, 87, 141, 46);
				textField.setText((String) table.getValueAt(index, 0));
				layeredPane.add(textField);
				textField.setColumns(10);*/
				
				// Get the Recipe Name from table
				String name = (String) table.getValueAt(index, 0);
				// Brew Button
				MyRoundButton btnCheck = new MyRoundButton("Check");
				btnCheck.setFont(new Font("Calibri", Font.PLAIN, 22));
				btnCheck.setBounds(359, 183, 130, 43);
				layeredPane.add(btnCheck);
				// Brew Button Listener
				btnCheck.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// click "Check" to check the ingredient of selected Recipe we missed
						closeThis();
						new IngredientCheckPage(name,batchSize).setVisible(true);;
					}
				});
			}
					 
		});

		
		MyRoundButton btnCancel = new MyRoundButton("Cancel");
		btnCancel.setBounds(208, 331, 150, 45);
		contentPane.add(btnCancel);
		btnCancel.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// click "Cancel", go beck to BrewPage
				closeThis();
				new BrewPage().setVisible(true);;
			}
		});
	}
	// Close current UI page
	protected void closeThis() {
		//contentPane.setVisible(false);
		this.dispose();
	}
}
