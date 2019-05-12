package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.BrewController;
import Controller.IngredientCheckController;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JEditorPane;

public class IngredientCheckPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public IngredientCheckPage(String Name, float batchSize) {
		System.out.println(Name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName= new JLabel(Name);
		lblName.setBounds(37, 30, 150, 31);
		contentPane.add(lblName);
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Calibri", Font.BOLD, 25));
		
		JLabel lblNewLabel = new JLabel("You Need :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel.setBounds(176, 30, 175, 31);
		contentPane.add(lblNewLabel);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(14, 74, 554, 213);
		contentPane.add(layeredPane);
		
		JLabel lblNewLabel_1 = new JLabel("Malts");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(34, 13, 115, 27);
		layeredPane.add(lblNewLabel_1);
		
		JLabel lblIngredient = new JLabel("Hops");
		lblIngredient.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngredient.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblIngredient.setBounds(34, 53, 115, 27);
		layeredPane.add(lblIngredient);
		
		JLabel lblIngredient_1 = new JLabel("Yeasts");
		lblIngredient_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngredient_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblIngredient_1.setBounds(34, 93, 115, 27);
		layeredPane.add(lblIngredient_1);
		
		JLabel lblIngredient_2 = new JLabel("Sugars");
		lblIngredient_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngredient_2.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblIngredient_2.setBounds(34, 133, 115, 27);
		layeredPane.add(lblIngredient_2);
		
		JLabel lblAdditives = new JLabel("Additives");
		lblAdditives.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdditives.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblAdditives.setBounds(34, 173, 115, 27);
		layeredPane.add(lblAdditives);
		
		// Get ingredient amount we need from database 
		ArrayList<Float> AbsoluteIngredient = new ArrayList<Float>();
		IngredientCheckController controller1 = new IngredientCheckController();
		AbsoluteIngredient = controller1.getAbsoluteIngredient(Name,batchSize);
		float malts = AbsoluteIngredient.get(0);
		float hops = AbsoluteIngredient.get(1);
		float yeasts = AbsoluteIngredient.get(2);
		float sugars = AbsoluteIngredient.get(3);
		float additives = AbsoluteIngredient.get(4);
		// show the number in database
		String cMalts = Float.toString(malts);
		JLabel lblAmountMalts= new JLabel(cMalts);
		lblAmountMalts.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountMalts.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblAmountMalts.setBounds(133, 12, 71, 29);
		layeredPane.add(lblAmountMalts);
		
		String cHops = Float.toString(hops);
		JLabel lblAmountHops = new JLabel(cHops);
		lblAmountHops.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountHops.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblAmountHops.setBounds(133, 53, 71, 29);
		layeredPane.add(lblAmountHops);
		
		String cYeasts = Float.toString(yeasts);
		JLabel lblAmountYeasts = new JLabel(cYeasts);
		lblAmountYeasts.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountYeasts.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblAmountYeasts.setBounds(133, 92, 71, 29);
		layeredPane.add(lblAmountYeasts);
		
		String cSugars = Float.toString(sugars);
		JLabel lblAmountSugars = new JLabel(cSugars);
		lblAmountSugars.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountSugars.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblAmountSugars.setBounds(133, 132, 71, 29);
		layeredPane.add(lblAmountSugars);
		
		String cAdditives = Float.toString(additives);
		JLabel lblAmountAdditives = new JLabel(cAdditives);
		lblAmountAdditives.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountAdditives.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblAmountAdditives.setBounds(133, 172, 71, 29);
		layeredPane.add(lblAmountAdditives);
		
		// kg
		JLabel lblKg = new JLabel("kg");
		lblKg.setHorizontalAlignment(SwingConstants.CENTER);
		lblKg.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblKg.setBounds(204, 13, 36, 27);
		layeredPane.add(lblKg);
		
		JLabel label = new JLabel("kg");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Calibri", Font.PLAIN, 20));
		label.setBounds(204, 53, 36, 27);
		layeredPane.add(label);
		
		JLabel label_1 = new JLabel("kg");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		label_1.setBounds(204, 93, 36, 27);
		layeredPane.add(label_1);
		
		JLabel label_2 = new JLabel("kg");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Calibri", Font.PLAIN, 20));
		label_2.setBounds(204, 133, 36, 27);
		layeredPane.add(label_2);
		
		JLabel label_6 = new JLabel("kg");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Calibri", Font.PLAIN, 20));
		label_6.setBounds(204, 173, 36, 27);
		layeredPane.add(label_6);
		
		String cA = Float.toString(15);
		
		
		// Valid or missed
		ArrayList<Float> MissedAmount = new ArrayList<Float>();
		IngredientCheckController controller2 = new IngredientCheckController();
		MissedAmount = controller2.checkMissing(Name,batchSize);
		float x1 = MissedAmount.get(0); //malts
		float x2 = MissedAmount.get(1); //hops
		float x3 = MissedAmount.get(2); //yeasts
		float x4 = MissedAmount.get(3); //sugars
		float x5 = MissedAmount.get(4); //additives
		
		if(x1 == 0) {
			JLabel lblAvailable = new JLabel("Available");
			lblAvailable.setHorizontalAlignment(SwingConstants.LEFT);
			lblAvailable.setFont(new Font("Calibri", Font.PLAIN, 20));
			lblAvailable.setBounds(284, 13, 89, 27);
			layeredPane.add(lblAvailable);
		}else {
			JLabel lblMissed = new JLabel("Missed");
			lblMissed.setHorizontalAlignment(SwingConstants.LEFT);
			lblMissed.setFont(new Font("Calibri", Font.PLAIN, 20));
			lblMissed.setBounds(284, 13, 89, 27);
			layeredPane.add(lblMissed);
			
			String num = Float.toString(x1);
			JLabel lblNum = new JLabel(num);
			lblNum.setHorizontalAlignment(SwingConstants.CENTER);
			lblNum.setFont(new Font("Calibri", Font.PLAIN, 20));
			lblNum.setBounds(365, 13, 83, 27);
			layeredPane.add(lblNum);
			
			JLabel lblkg= new JLabel("kg");
			lblkg.setHorizontalAlignment(SwingConstants.CENTER);
			lblkg.setFont(new Font("Calibri", Font.PLAIN, 20));
			lblkg.setBounds(450, 13, 36, 27);
			layeredPane.add(lblkg);
		}
		
		if(x2 == 0) {
			JLabel lblAvailable= new JLabel("Available");
			lblAvailable.setHorizontalAlignment(SwingConstants.LEFT);
			lblAvailable.setFont(new Font("Calibri", Font.PLAIN, 20));
			lblAvailable.setBounds(284, 55, 89, 27);
			layeredPane.add(lblAvailable);
		}else {
			JLabel lblMissed = new JLabel("Missed");
			lblMissed.setHorizontalAlignment(SwingConstants.LEFT);
			lblMissed.setFont(new Font("Calibri", Font.PLAIN, 20));
			lblMissed.setBounds(284, 55, 89, 27);
			layeredPane.add(lblMissed);
			
			String num = Float.toString(x2);
			JLabel lblNum = new JLabel(num);
			lblNum.setHorizontalAlignment(SwingConstants.CENTER);
			lblNum.setFont(new Font("Calibri", Font.PLAIN, 20));
			lblNum.setBounds(365, 55, 83, 27);
			layeredPane.add(lblNum);
			
			JLabel lblkg= new JLabel("kg");
			lblkg.setHorizontalAlignment(SwingConstants.CENTER);
			lblkg.setFont(new Font("Calibri", Font.PLAIN, 20));
			lblkg.setBounds(450, 55, 36, 27);
			layeredPane.add(lblkg);
		}
		
		if(x3 == 0) {
			JLabel lblAvailable = new JLabel("Available");
			lblAvailable.setHorizontalAlignment(SwingConstants.LEFT);
			lblAvailable.setFont(new Font("Calibri", Font.PLAIN, 20));
			lblAvailable.setBounds(284, 93, 89, 27);
			layeredPane.add(lblAvailable);
		}else {
			JLabel lblMissed = new JLabel("Missed");
			lblMissed.setHorizontalAlignment(SwingConstants.LEFT);
			lblMissed.setFont(new Font("Calibri", Font.PLAIN, 20));
			lblMissed.setBounds(284, 93, 89, 27);
			layeredPane.add(lblMissed);
			
			String num = Float.toString(x3);
			JLabel lblNum = new JLabel(num);
			lblNum.setHorizontalAlignment(SwingConstants.CENTER);
			lblNum.setFont(new Font("Calibri", Font.PLAIN, 20));
			lblNum.setBounds(365, 93, 83, 27);
			layeredPane.add(lblNum);
			
			JLabel lblkg= new JLabel("kg");
			lblkg.setHorizontalAlignment(SwingConstants.CENTER);
			lblkg.setFont(new Font("Calibri", Font.PLAIN, 20));
			lblkg.setBounds(450, 93, 36, 27);
			layeredPane.add(lblkg);
		}
		
		if(x4 == 0) {
			JLabel lblAvailable = new JLabel("Available");
			lblAvailable.setHorizontalAlignment(SwingConstants.LEFT);
			lblAvailable.setFont(new Font("Calibri", Font.PLAIN, 20));
			lblAvailable.setBounds(284, 133, 89, 27);
			layeredPane.add(lblAvailable);
		}else {
			JLabel lblMissed = new JLabel("Missed");
			lblMissed.setHorizontalAlignment(SwingConstants.LEFT);
			lblMissed.setFont(new Font("Calibri", Font.PLAIN, 20));
			lblMissed.setBounds(284, 133, 89, 27);
			layeredPane.add(lblMissed);
			
			String num = Float.toString(x4);
			JLabel lblNum = new JLabel(num);
			lblNum.setHorizontalAlignment(SwingConstants.CENTER);
			lblNum.setFont(new Font("Calibri", Font.PLAIN, 20));
			lblNum.setBounds(365, 133, 83, 27);
			layeredPane.add(lblNum);
			
			JLabel lblkg= new JLabel("kg");
			lblkg.setHorizontalAlignment(SwingConstants.CENTER);
			lblkg.setFont(new Font("Calibri", Font.PLAIN, 20));
			lblkg.setBounds(450, 133, 36, 27);
			layeredPane.add(lblkg);
		}
		
		if(x5 == 0) {
			JLabel lblAvailable = new JLabel("Available");
			lblAvailable.setHorizontalAlignment(SwingConstants.LEFT);
			lblAvailable.setFont(new Font("Calibri", Font.PLAIN, 20));
			lblAvailable.setBounds(284, 173, 89, 27);
			layeredPane.add(lblAvailable);
		}else {
			JLabel lblMissed = new JLabel("Missed");
			lblMissed.setHorizontalAlignment(SwingConstants.LEFT);
			lblMissed.setFont(new Font("Calibri", Font.PLAIN, 20));
			lblMissed.setBounds(284, 173, 89, 27);
			layeredPane.add(lblMissed);
			
			String num = Float.toString(x5);
			JLabel lblNum = new JLabel(num);
			lblNum.setHorizontalAlignment(SwingConstants.CENTER);
			lblNum.setFont(new Font("Calibri", Font.PLAIN, 20));
			lblNum.setBounds(365, 173, 83, 27);
			layeredPane.add(lblNum);
			
			JLabel lblkg= new JLabel("kg");
			lblkg.setHorizontalAlignment(SwingConstants.CENTER);
			lblkg.setFont(new Font("Calibri", Font.PLAIN, 20));
			lblkg.setBounds(450, 173, 36, 27);
			layeredPane.add(lblkg);
		}
		

		JButton btnBrew = new JButton("Back");
		btnBrew.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnBrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new CheckRecipesPage(batchSize).setVisible(true);
			}
		});
		btnBrew.setBounds(69, 311, 150, 45);
		contentPane.add(btnBrew);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeThis();
				new BrewPage().setVisible(true);
			}
		});
		btnCancel.setBounds(346, 311, 150, 45);
		contentPane.add(btnCancel);
		
	}
	// Close current UI page
	protected void closeThis() {
		//contentPane.setVisible(false);
		this.dispose();
	}
}
