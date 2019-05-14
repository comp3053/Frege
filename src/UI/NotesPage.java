package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

import Controller.NotesController;
import mainPart.Note;

import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JList;

public class NotesPage extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public NotesPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(contentPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(29, 67, 524, 290);
		contentPane.add(layeredPane);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblDate.setBounds(14, 13, 137, 31);
		layeredPane.add(lblDate);
		
		JLabel lblRecipe = new JLabel("Recipe");
		lblRecipe.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipe.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblRecipe.setBounds(191, 13, 144, 31);
		layeredPane.add(lblRecipe);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblTitle.setBounds(367, 13, 143, 31);
		layeredPane.add(lblTitle);
		
		DefaultTableModel tableModel=new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};	
		
		NotesController controller = new NotesController();
		ArrayList<Note> note = controller.showNote();
        for(int i = 0;i < note.size();i++) {
        	Vector v = new Vector();
        	Date Date = note.get(i).getDate();
        	String Recipe = note.get(i).getRecipeName();
        	String Title = note.get(i).getTitle();
        	String Content = note.get(i).getContent();
        	v.add(Date);
        	//v.add(1, Recipe);
        	//v.add(2, Content);
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
				index = table.getSelectedRow();
				closeThis();
				new NoteCheckPage(controller.showNote().get(index).getDate(), controller.showNote().get(index).getRecipeName(), controller.showNote().get(index).getTitle(), controller.showNote().get(index).getContent()).setVisible(true);
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
		lblNotesPage.setBounds(149, 14, 246, 46);
		contentPane.add(lblNotesPage);
	}
	// Close current UI page
	protected void closeThis() {
		//contentPane.setVisible(false);
		this.dispose();
	}
}
