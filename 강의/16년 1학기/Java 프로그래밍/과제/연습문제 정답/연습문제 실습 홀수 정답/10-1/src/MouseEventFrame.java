import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseEventFrame extends JFrame {
	public MouseEventFrame() {
		super("���콺 �ø��� ������ ����");			
		setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Love Java");
		label.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				JLabel la = (JLabel)e.getSource();
				la.setText("Love Java");
			}
			public void mouseExited(MouseEvent e) {
				JLabel la = (JLabel)e.getSource();
				la.setText("�����");
			}			
		});
		add(label);
		setSize(250,150);
		setVisible(true);
	}
	static public void main(String [] args) {
		new MouseEventFrame();
	}
}
