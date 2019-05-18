package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controller.CheckRecipesController;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.SwingConstants;

public class RecipesCheckPage extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public RecipesCheckPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(contentPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Recipe Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel.setBounds(176, 13, 233, 50);
		contentPane.add(lblNewLabel);
		
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
		scroll.setBounds(0, 13, 554, 253);
		layeredPane.add(scroll);
		table.setModel(tableModel);
				
		// Click the table, will choose one recipe
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			int index;
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				//get the index in table we click
				index = table.getSelectedRow();
				String name = (String) table.getValueAt(index, 0);
				closeThis();
				new RecipesIngredientsPage(name).setVisible(true);
			}
					 
		});
		
		MyRoundButton btnHome = new MyRoundButton("Home");
		btnHome.setBounds(478, 13, 90, 32);
		contentPane.add(btnHome);
		btnHome.setFont(new Font("Calibri", Font.PLAIN, 15));
		
		MyRoundButton btnCancel = new MyRoundButton("Cancel");
		btnCancel.setBounds(208, 331, 150, 45);
		contentPane.add(btnCancel);
		btnCancel.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// click "Cancel", go beck to BrewPage
				closeThis();
				new RecipePage();
			}
		});
	}
	// Close current UI page
	protected void closeThis() {
		//contentPane.setVisible(false);
		this.dispose();
	}
}
