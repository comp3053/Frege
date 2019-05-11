package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JList;

public class NotesPage extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotesPage frame = new NotesPage();
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
	public NotesPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(29, 67, 524, 290);
		contentPane.add(layeredPane);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblDate.setBounds(59, 13, 79, 31);
		layeredPane.add(lblDate);
		
		JLabel lblRecipe = new JLabel("Recipe");
		lblRecipe.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipe.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblRecipe.setBounds(218, 13, 79, 31);
		layeredPane.add(lblRecipe);
		
		JLabel lblContent = new JLabel("Content");
		lblContent.setHorizontalAlignment(SwingConstants.CENTER);
		lblContent.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblContent.setBounds(367, 13, 95, 31);
		layeredPane.add(lblContent);
		
		DefaultTableModel tableModel=new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};	
		tableModel.addColumn("");
		tableModel.addColumn("");
		tableModel.addColumn("");
        for(int i = 0;i < 10;i++) {
        	// should link to database
        	Vector v = new Vector();
        	v.add("Brew"+i);
        	//v.add("");
        	tableModel.addRow(v);
        }
        
        // Table
        table = new JTable(tableModel);
		table.setFont(new Font("Calibri", Font.PLAIN, 20));
		table.setRowHeight(30);
		// Dynamic table 
		JScrollPane scroll = new JScrollPane(table);
		scroll.setEnabled(false);
		scroll.setBounds(14, 43, 496, 223);
		layeredPane.add(scroll);
		table.setModel(tableModel);
		 

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			int index;
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				index = table.getSelectedRow();
				String DateVal = (String) table.getValueAt(index, 0);
				String RecipeVal = (String) table.getValueAt(index, 1);
				String ContentVal = (String) table.getValueAt(index, 2);
				//String n = (String) table.getValueAt(index, 0);
				closeThis();
				new NoteCheckPage(DateVal, RecipeVal, ContentVal).setVisible(true);
			}
			 
		});
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new HomePage();
			}
		});
		btnHome.setBounds(460, 28, 89, 27);
		contentPane.add(btnHome);
		
		JLabel lblNotesPage = new JLabel("Notes Page");
		lblNotesPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotesPage.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNotesPage.setBounds(210, 13, 153, 46);
		contentPane.add(lblNotesPage);
	}
	// Close current UI page
		protected void closeThis() {
			contentPane.setVisible(false);
		}
}
