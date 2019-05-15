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
		JFrame frame = new JFrame("测试圆角按钮窗口");
		frame.setBounds(100, 100, 400, 400);
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 30));
		panel.setBackground(Color.white);
		MyRoundButton myButton = new MyRoundButton("按 钮");
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
		//紫色
		Color c_initial = new Color(151, 112, 212);
		Color c_enter = new Color(164, 135, 217);
		
		color = c_initial;
		color_initial = c_initial;
		color_enter = c_enter;
		setPreferredSize(new Dimension(150, 55));// define the size of button
		setFont(new Font("宋体", Font.BOLD, 18));// define the font and size
		setForeground(Color.white);// define the color of text on button
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
		g2d.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 28,
				28);
		super.paintComponent(g);
	}

	public void paintBorder(Graphics g) {// 绘制按钮边框：圆角矩形边框
		// 注意：此类中的具体实现，即以下两句，可以有，也可以没有，对最终的显示效果没有多大影响。但是这个方法必须有，否则绘制出的就是默认的矩形边框，而不是圆角边框了。
		// g.setColor(color);
		// 画边界区域
		// g.drawRoundRect(0, 0, getSize().width-1 , getSize().height-1, 28, 28);
	}
}