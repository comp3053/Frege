package UI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.sun.glass.events.MouseEvent;

import javafx.scene.control.TableColumn;
import mainPart.Recipe;

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
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;

public class SelectRecipesPage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public SelectRecipesPage(float batchSize, ArrayList<String> RecipesList) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(contentPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRecipeList = new JLabel("Available Recipe List");
		lblRecipeList.setFont(new Font("Calibri", Font.BOLD, 30));
		lblRecipeList.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipeList.setBounds(48, 13, 449, 37);
		contentPane.add(lblRecipeList);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(14, 45, 554, 279);
		contentPane.add(layeredPane);
		
		// Table Model
		// Rewrite the table can be select but can't be edited
		DefaultTableModel tableModel=new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableModel.addColumn("Recipes");
		
		int size = RecipesList.size(); 
		System.out.println(size);
        for(int i = 0;i < size;i++) {
        	// should link to database
        	Vector v = new Vector();
        	v.add(RecipesList.get(i));
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
				index = table.getSelectedRow();
				
				/*textField = new JTextField();
				textField.setEditable(false);
				textField.setHorizontalAlignment(SwingConstants.CENTER);
				textField.setFont(new Font("Calibri", Font.PLAIN, 25));
				textField.setBounds(332, 87, 141, 46);
				textField.setText((String) table.getValueAt(index, 0));
				layeredPane.add(textField);
				textField.setColumns(10);*/
				String name = (String) table.getValueAt(index, 0);
				
				// Brew Button
				JButton btnBrew = new JButton("Brew");
				btnBrew.setFont(new Font("Calibri", Font.PLAIN, 25));
				btnBrew.setBounds(359, 183, 110, 43);
				layeredPane.add(btnBrew);
				// Brew Button Listener
				btnBrew.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
	
						closeThis();
						//new ConfirmBrewPage(textField.getText(),batchSize).setVisible(true);
						new ConfirmBrewPage(name,batchSize).setVisible(true);
					}
				});
			}
			 
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(215, 325, 150, 45);
		contentPane.add(btnCancel);
		btnCancel.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new BrewPage().setVisible(true);
			}
		});
	}
	// Close current UI page
	protected void closeThis() {
		//contentPane.setVisible(false);
		this.dispose();
	}

}
