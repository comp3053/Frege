package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.prism.paint.Color;

import Controller.IngredientAddController;
import mainPart.Database;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.ScrollPane;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class IngredientAddPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public IngredientAddPage() {
		setTitle("BrewDay! [Frege]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new java.awt.Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(contentPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddIngredientList = new JLabel("Add Ingredient List");
		lblAddIngredientList.setBounds(14, 13, 303, 27);
		lblAddIngredientList.setFont(new Font("Calibri", Font.BOLD, 25));
		contentPane.add(lblAddIngredientList);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(new java.awt.Color(255, 255, 255));
		layeredPane.setBorder(new LineBorder(new java.awt.Color(0, 0, 0)));
		layeredPane.setBounds(24, 53, 527, 266);
		contentPane.add(layeredPane);
		layeredPane.setLayout(null);
		
		// Set text
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(41, 13, 83, 31);
		layeredPane.add(lblName);
		lblName.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblAmount.setBounds(198, 13, 133, 31);
		layeredPane.add(lblAmount);
		
		JLabel lblMalts = new JLabel("Malts");
		lblMalts.setHorizontalAlignment(SwingConstants.LEFT);
		lblMalts.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblMalts.setBounds(51, 57, 99, 31);
		layeredPane.add(lblMalts);
		
		JLabel lblHops = new JLabel("Hops");
		lblHops.setHorizontalAlignment(SwingConstants.LEFT);
		lblHops.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblHops.setBounds(51, 91, 99, 31);
		layeredPane.add(lblHops);
		
		JLabel lblYeasts = new JLabel("Yeasts");
		lblYeasts.setHorizontalAlignment(SwingConstants.LEFT);
		lblYeasts.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblYeasts.setBounds(51, 125, 99, 31);
		layeredPane.add(lblYeasts);
		
		JLabel lblSugars = new JLabel("Sugars");
		lblSugars.setHorizontalAlignment(SwingConstants.LEFT);
		lblSugars.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblSugars.setBounds(51, 159, 99, 31);
		layeredPane.add(lblSugars);
		
		JLabel lblAdditives = new JLabel("Additives");
		lblAdditives.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdditives.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblAdditives.setBounds(51, 194, 121, 31);
		layeredPane.add(lblAdditives);
		
		// Find Amount in database and show on
		//IngredientAddController controllerUI1 = new IngredientAddController();
		
		// call controller to get the ingredient amount in database 
		IngredientAddController controller1 = new IngredientAddController();
		
		float x1 = controller1.searchQuantity("Malts");
		String cMalts = Float.toString(x1);
		JLabel lblAmountMalts= new JLabel(cMalts);
		lblAmountMalts.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountMalts.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblAmountMalts.setBounds(198, 57, 133, 31);
		layeredPane.add(lblAmountMalts);
		
		float x2 = controller1.searchQuantity("Hops");
		String cHops = Float.toString(x2);
		JLabel lblAmountHops = new JLabel(cHops);
		lblAmountHops.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountHops.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblAmountHops.setBounds(198, 91, 133, 31);
		layeredPane.add(lblAmountHops);
		
		float x3 = controller1.searchQuantity("Yeasts");
		String cYeasts = Float.toString(x3);
		JLabel lblAmountYeasts = new JLabel(cYeasts);
		lblAmountYeasts.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountYeasts.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblAmountYeasts.setBounds(198, 125, 133, 31);
		layeredPane.add(lblAmountYeasts);
		
		float x4 = controller1.searchQuantity("Sugars");
		String cSugars = Float.toString(x4);
		JLabel lblAmountSugars = new JLabel(cSugars);
		lblAmountSugars.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountSugars.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblAmountSugars.setBounds(198, 159, 133, 31);
		layeredPane.add(lblAmountSugars);
		
		float x5 = controller1.searchQuantity("Additives");
		String cAdditives = Float.toString(x5);
		JLabel lblAmountAdditives = new JLabel(cAdditives);
		lblAmountAdditives.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountAdditives.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblAmountAdditives.setBounds(198, 194, 133, 31);
		layeredPane.add(lblAmountAdditives);
		
		// The symbol '+'
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(345, 0, 55, 266);
		layeredPane.add(layeredPane_1);
		
		JLabel label = new JLabel("+");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Calibri", Font.PLAIN, 22));
		label.setBounds(0, 58, 55, 31);
		layeredPane_1.add(label);
		
		JLabel label_1 = new JLabel("+");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Calibri", Font.PLAIN, 22));
		label_1.setBounds(0, 92, 55, 31);
		layeredPane_1.add(label_1);
		
		JLabel label_2 = new JLabel("+");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Calibri", Font.PLAIN, 22));
		label_2.setBounds(0, 125, 55, 31);
		layeredPane_1.add(label_2);
		
		JLabel label_3 = new JLabel("+");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Calibri", Font.PLAIN, 22));
		label_3.setBounds(0, 160, 55, 31);
		layeredPane_1.add(label_3);
		
		JLabel label_4 = new JLabel("+");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Calibri", Font.PLAIN, 22));
		label_4.setBounds(0, 194, 55, 31);
		layeredPane_1.add(label_4);
		
		// Input number to add
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spinner.setFont(new Font("Calibri", Font.PLAIN, 18));
		spinner.setBounds(414, 61, 70, 24);
		layeredPane.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spinner_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		spinner_1.setBounds(414, 95, 70, 24);
		layeredPane.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spinner_2.setFont(new Font("Calibri", Font.PLAIN, 18));
		spinner_2.setBounds(414, 129, 70, 24);
		layeredPane.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spinner_3.setFont(new Font("Calibri", Font.PLAIN, 18));
		spinner_3.setBounds(414, 163, 70, 24);
		layeredPane.add(spinner_3);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spinner_4.setFont(new Font("Calibri", Font.PLAIN, 18));
		spinner_4.setBounds(414, 198, 70, 24);
		layeredPane.add(spinner_4);
		
		
		MyRoundButton btnAdd = new MyRoundButton("Add");
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnAdd.setBounds(80, 332, 150, 38);
		contentPane.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//Temporarily missing operations on the database
					float nMalts = (float) spinner.getValue();
					float nHops = (float) spinner_1.getValue();
					float nYeasts = (float) spinner_2.getValue();
					float nSugars = (float) spinner_3.getValue();
					float nAdditives = (float) spinner_4.getValue();
					
					if(nMalts < 0||nHops < 0||nYeasts < 0||nSugars < 0||nAdditives < 0) {
					
						//If the operation fails, do not change the database and refresh the current page
						JOptionPane.showMessageDialog(null,"Please input positive number! <(*ToT*)>","Warning",JOptionPane.ERROR_MESSAGE);
						closeThis();
						new IngredientAddPage().setVisible(true);
					
					}else {
						// call controller to change the amount in database
						IngredientAddController controllerUI = new IngredientAddController();
						controllerUI.addIngredientQuantity("Malts",nMalts);
						controllerUI.addIngredientQuantity("Hops",nHops);
						controllerUI.addIngredientQuantity("Yeasts",nYeasts);
						controllerUI.addIngredientQuantity("Sugars",nSugars);
						controllerUI.addIngredientQuantity("Additives",nAdditives);
						//If the operation is successful, modify the database and return to RecipePage
						JOptionPane.showMessageDialog(null, "Success! (*^ w ^*)");
						closeThis();
						new IngredientPage().setVisible(true);
					}
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,"Please input a number! (> w <)","Warning",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		MyRoundButton btnCancel = new MyRoundButton("Cancel");
		btnCancel.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnCancel.setBounds(337, 332, 150, 38);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Click  "Cancel", go back to IngredientPage
				closeThis();
				new IngredientPage().setVisible(true);
			}
		});
		
		
	}
	
	// Close current UI page
	protected void closeThis() {
		//contentPane.setVisible(false);
		this.dispose();
	}
}