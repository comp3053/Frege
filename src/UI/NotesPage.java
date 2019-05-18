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
		setTitle("BrewDay! [Frege]");
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
		
		
		DefaultTableModel tableModel=new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};	
		tableModel.addColumn("Date");
		tableModel.addColumn("Recipe");
		tableModel.addColumn("Title");

		
		
		NotesController controller = new NotesController();
		ArrayList<Note> note = controller.showNote();
        for(int i = note.size();i >= 0;i--) {
        	Vector row = new Vector();
        	Vector vData = new Vector();
        	vData.add(note.get(i).getDate());
        	vData.add(note.get(i).getRecipeName());
        	vData.add(note.get(i).getTitle());
        	tableModel.addRow(vData);  	
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
				System.out.println(index);
				closeThis();
				new NoteCheckPage(note.get(index).getDate(), note.get(index).getRecipeName(), note.get(index).getTitle(), note.get(index).getContent()).setVisible(true);
			}
		});
		
		MyRoundButton btnHome = new MyRoundButton("Home");
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
