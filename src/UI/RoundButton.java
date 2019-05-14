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
		JFrame frame = new JFrame("����Բ�ǰ�ť����");
		frame.setBounds(100, 100, 400, 400);
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 30));
		panel.setBackground(Color.white);
		MyRoundButton myButton = new MyRoundButton("�� ť", new Color(151, 112,
				212), new Color(164, 135, 217));
		panel.add(myButton);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class MyRoundButton extends JButton {// �Զ���һ���̳�JButton����
	private Color color, color_initial, color_enter;// ������������Ƴ�ʱ�����ڰ�ť��ɫ�仯��һЩ����

	public MyRoundButton(String s, Color c_initial, Color c_enter) {
		super(s);
		color = c_initial;
		color_initial = c_initial;
		color_enter = c_enter;
		setPreferredSize(new Dimension(150, 55));// ���尴ť��С
		setFont(new Font("����", Font.BOLD, 18));// ���尴ť�ϵ��ı����壬��С
		setForeground(Color.white);// ���尴ť�ϵ��ı���ɫ
		setFocusPainted(false);// ȥ�� �����ťʱ���ı��ܱߵ�����
		setContentAreaFilled(false);// ��ť��������Ϊ͸����ֻ������������ʾ�������Լ��������ɫ
		addMouseListener(new MouseAdapter() {// ͨ����������������������Ƴ�ʱ����ť��ɫ�ı仯
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

	public void paintComponent(Graphics g) {// ������䰴ť����״��Բ�Ǿ��ΰ�ť
		Graphics2D g2d = (Graphics2D) g;
		// �������䣬������Բ���ܱߵľ���õ�
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.addRenderingHints(rh);
		// ������䰴ť����ɫ
		g2d.setColor(color);
		// �������Բ�Ǿ�������
		g2d.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 28,
				28);
		super.paintComponent(g);
	}

	public void paintBorder(Graphics g) {// ���ư�ť�߿�Բ�Ǿ��α߿�
		// ע�⣺�����еľ���ʵ�֣����������䣬�����У�Ҳ����û�У������յ���ʾЧ��û�ж��Ӱ�졣����������������У�������Ƴ��ľ���Ĭ�ϵľ��α߿򣬶�����Բ�Ǳ߿��ˡ�
		// g.setColor(color);
		// ���߽�����
		// g.drawRoundRect(0, 0, getSize().width-1 , getSize().height-1 ,
		// 28, 28);
	}
}