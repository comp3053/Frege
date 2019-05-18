package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controller.NotesController;
import Controller.RecipesCheckController;
import mainPart.Note;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class RecipesIngredientsPage extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public RecipesIngredientsPage(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(contentPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(29, 134, 524, 157);
		contentPane.add(layeredPane);
		
		DefaultTableModel tableModel=new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};	
		tableModel.addColumn("Malts");
		tableModel.addColumn("Hops");
		tableModel.addColumn("Yeasts");
		tableModel.addColumn("Sugars");
		tableModel.addColumn("Additives");
		
		
		RecipesCheckController controller = new RecipesCheckController();
		ArrayList<Float> recipeIngredient = controller.getRecipeIngredient(name);
        Vector row = new Vector();
        Vector vData = new Vector();
        vData.add(recipeIngredient.get(0));
        vData.add(recipeIngredient.get(1));
        vData.add(recipeIngredient.get(2));
        vData.add(recipeIngredient.get(3));
        vData.add(recipeIngredient.get(4));
        tableModel.addRow(vData);  	
        
        // Table
        table = new JTable(tableModel);
		table.setFont(new Font("Calibri", Font.PLAIN, 20));
		table.setRowHeight(30);
		// Dynamic table 
		JScrollPane scroll = new JScrollPane(table);
		scroll.setEnabled(false);
		scroll.setBounds(14, 13, 496, 130);
		layeredPane.add(scroll);
		table.setModel(tableModel);
		
		MyRoundButton btnHome = new MyRoundButton("Home");
		btnHome.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new HomePage();
			}
		});
		btnHome.setBounds(464, 17, 89, 27);
		contentPane.add(btnHome);
		
		MyRoundButton btnCancel = new MyRoundButton("Cancel");
		btnCancel.setBounds(215, 325, 150, 45);
		contentPane.add(btnCancel);
		btnCancel.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// click "Cancel", go beck to BrewPage
				closeThis();
				new RecipesCheckPage().setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Recipe Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel.setBounds(80, 63, 417, 37);
		lblNewLabel.setText(name);
		contentPane.add(lblNewLabel);
	}
	// Close current UI page
	protected void closeThis() {
		//contentPane.setVisible(false);
		this.dispose();
	}
}
