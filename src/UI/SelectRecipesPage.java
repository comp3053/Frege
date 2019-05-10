package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import javafx.scene.control.TableColumn;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;

public class SelectRecipesPage extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectRecipesPage frame = new SelectRecipesPage();
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
	public SelectRecipesPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRecipeList = new JLabel("Available Recipe List");
		lblRecipeList.setFont(new Font("Calibri", Font.BOLD, 30));
		lblRecipeList.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipeList.setBounds(119, 13, 322, 37);
		contentPane.add(lblRecipeList);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(14, 45, 554, 279);
		contentPane.add(layeredPane);
		
		// Table
		table = new JTable();
		table.setFont(new Font("Calibri", Font.PLAIN, 18));
		table.setBounds(75, 13, 394, 253);
		layeredPane.add(table);
		/* 用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看 */  
        JScrollPane scroll = new JScrollPane(table);  
        scroll.setBounds(14, 325, 554, -275);
        getContentPane().add(scroll); 
		
		String[] columnNames = {"Recipes","Operation"};
		javax.swing.table.TableColumn column = null;  
        int colunms = table.getColumnCount();
        for(int i = 0; i < colunms; i++)  {  
            column = table.getColumnModel().getColumn(i);  
            /*将每一列的默认宽度设置为100*/  
            column.setPreferredWidth(100);  
        }  
        /* 
         * 设置JTable自动调整列表的状态，此处设置为关闭 
         */  
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(215, 325, 150, 45);
		contentPane.add(btnCancel);
		btnCancel.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new BrewPage().setVisible(true);;
			}
		});
	}
	// Close current UI page
	protected void closeThis() {
		contentPane.setVisible(false);
	}
}
