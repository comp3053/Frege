package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;



public class HomePage {

	private JFrame frmBrewdayfrege;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frmBrewdayfrege.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmBrewdayfrege = new JFrame();
		frmBrewdayfrege.getContentPane().setBackground(new Color(255, 255, 255));
		frmBrewdayfrege.setTitle("BrewDay! [Frege]");
		frmBrewdayfrege.setBounds(100, 100, 600, 430);
		frmBrewdayfrege.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBrewdayfrege.getContentPane().setLayout(null);
		frmBrewdayfrege.setVisible(true);
		
		// Put in center
		int windowWidth = frmBrewdayfrege.getWidth();
		int windowHeight = frmBrewdayfrege.getHeight();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		frmBrewdayfrege.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
		
		JLabel lblBrewDay = new JLabel("Brew Day!");
		lblBrewDay.setForeground(new Color(153, 50, 204));
		lblBrewDay.setFont(new Font("Lithos Pro Regular", Font.BOLD, 40));
		lblBrewDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrewDay.setBounds(130, 41, 310, 91);
		frmBrewdayfrege.getContentPane().add(lblBrewDay);
		
		MyRoundButton btnRecipes = new MyRoundButton("Recipes");
		btnRecipes.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnRecipes.setBounds(57, 145, 201, 39);
		frmBrewdayfrege.getContentPane().add(btnRecipes);
		btnRecipes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// When click "Recipes", jump to RecipePage
				closeThis();
				new RecipePage();
			}
		});
		
		MyRoundButton btnIngredients = new MyRoundButton("Ingredients");
		btnIngredients.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnIngredients.setBounds(321, 145, 204, 39);
		frmBrewdayfrege.getContentPane().add(btnIngredients);
		btnIngredients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// When click "Ingredients", jump to IngredientsPage
				closeThis();
				new IngredientPage().setVisible(true);
			}
		});
		
		MyRoundButton btnBrew = new MyRoundButton("Brew");
		btnBrew.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnBrew.setBounds(188, 208, 204, 39);
		frmBrewdayfrege.getContentPane().add(btnBrew);
		btnBrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// When click "Brew", jump to BrewPage
				closeThis();
				new BrewPage().setVisible(true);
			}
		});
		
		MyRoundButton btnNotes = new MyRoundButton("Notes");
		btnNotes.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnNotes.setBounds(57, 270, 204, 39);
		frmBrewdayfrege.getContentPane().add(btnNotes);
		btnNotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// When click "Notes", jump to NotesPage
				closeThis();
				new NotesPage().setVisible(true);
			}
		});
		
		MyRoundButton btnEquipment = new MyRoundButton("Equipment");
		btnEquipment.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnEquipment.setBounds(321, 270, 204, 39);
		frmBrewdayfrege.getContentPane().add(btnEquipment);
		btnEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// When click "Equipment", jump to Equipment
				closeThis();
				new EquipmentPage().setVisible(true);
			}
		});
	}
	
	// Close current UI page
	protected void closeThis() {
		//frame.setVisible(false);
		frmBrewdayfrege.dispose();
	}
}
