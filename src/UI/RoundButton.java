package UI;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RoundButton {

	public static void main(String[] args) {
		JFrame frame = new JFrame("button");
		frame.setBounds(100, 100, 400, 400);
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 30));
		panel.setBackground(Color.white);
		MyRoundButton myButton = new MyRoundButton("button");
		panel.add(myButton);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class MyRoundButton extends JButton {
	private Color color, color_initial, color_enter;// the color will change when mouse over it

	public MyRoundButton(String s) {
		super(s);
		//��ɫ
		Color c_initial = new Color(151, 112, 212);
		Color c_enter = new Color(164, 135, 217);
		
		color = c_initial;
		color_initial = c_initial;
		color_enter = c_enter;
		setPreferredSize(new Dimension(150, 55));// define the size of button
		setFont(new Font("����", Font.BOLD, 18));// define the font and size
		
		setForeground(Color.white);// define the color of text on button
		
		//way 1
	    setBackground(color);
	    setOpaque(true);//设置透明背影
	    setBorderPainted(false);
		
		//way 2
		//setBackground(color);
		//setForeground(color);
		//setBorderPainted(false);
		
		setFocusPainted(false);// delete the line when click the button
		setContentAreaFilled(false);// The button itself is set to be transparent so that we can display our own defined colors.
		addMouseListener(new MouseAdapter() {// Use mouse monitoring to set the color change of the button when the mouse is moved in and removed.
			public void mouseEntered(MouseEvent e) {
				color = color_enter;
			}

			public void mouseExited(MouseEvent e) {
				color = color_initial;
			}

			public void mouseReleased(MouseEvent e) {
				color = color_initial;
			}

			public void mouseClicked(MouseEvent e) {
				color = color_enter;
			}

		});
	}

	public void paintComponent(Graphics g) {// Draw the shape of the fill button: rounded rectangle button
		Graphics2D g2d = (Graphics2D) g;
		// The following two sentences are used to eliminate the sawtooth around the fillet.
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.addRenderingHints(rh);
		// Set the color of the fill button
		g2d.setColor(color);
		// Set fill fillet rectangle area
		g2d.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 28, 28);
		super.paintComponent(g);
	}

	public void paintBorder(Graphics g) {// ���ư�ť�߿�Բ�Ǿ��α߿�
		// ע�⣺�����еľ���ʵ�֣����������䣬�����У�Ҳ����û�У������յ���ʾЧ��û�ж��Ӱ�졣����������������У�������Ƴ��ľ���Ĭ�ϵľ��α߿򣬶�����Բ�Ǳ߿��ˡ�
		// g.setColor(color);
		// ���߽�����
		// g.drawRoundRect(0, 0, getSize().width-1 , getSize().height-1, 28, 28);
	}
}