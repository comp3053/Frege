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
		MyRoundButton myButton = new MyRoundButton("按 钮", new Color(151, 112,
				212), new Color(164, 135, 217));
		panel.add(myButton);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class MyRoundButton extends JButton {// 自定义一个继承JButton的类
	private Color color, color_initial, color_enter;// 关于鼠标移入移除时，用于按钮颜色变化的一些变量

	public MyRoundButton(String s, Color c_initial, Color c_enter) {
		super(s);
		color = c_initial;
		color_initial = c_initial;
		color_enter = c_enter;
		setPreferredSize(new Dimension(150, 55));// 定义按钮大小
		setFont(new Font("宋体", Font.BOLD, 18));// 定义按钮上的文本字体，大小
		setForeground(Color.white);// 定义按钮上的文本颜色
		setFocusPainted(false);// 去掉 点击按钮时，文本周边的虚线
		setContentAreaFilled(false);// 按钮本身设置为透明，只有这样才能显示出我们自己定义的颜色
		addMouseListener(new MouseAdapter() {// 通过鼠标监听来设置鼠标移入移除时，按钮颜色的变化
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

	public void paintComponent(Graphics g) {// 绘制填充按钮的形状：圆角矩形按钮
		Graphics2D g2d = (Graphics2D) g;
		// 以下两句，是消除圆角周边的锯齿用的
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.addRenderingHints(rh);
		// 设置填充按钮的颜色
		g2d.setColor(color);
		// 设置填充圆角矩形区域
		g2d.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 28,
				28);
		super.paintComponent(g);
	}

	public void paintBorder(Graphics g) {// 绘制按钮边框：圆角矩形边框
		// 注意：此类中的具体实现，即以下两句，可以有，也可以没有，对最终的显示效果没有多大影响。但是这个方法必须有，否则绘制出的就是默认的矩形边框，而不是圆角边框了。
		// g.setColor(color);
		// 画边界区域
		// g.drawRoundRect(0, 0, getSize().width-1 , getSize().height-1 ,
		// 28, 28);
	}
}