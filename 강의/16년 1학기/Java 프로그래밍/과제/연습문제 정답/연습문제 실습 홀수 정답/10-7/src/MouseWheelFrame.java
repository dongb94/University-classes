import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseWheelFrame extends JFrame {
	public MouseWheelFrame() {
		super("마우스 휠을 굴려 폰트 크기 조절");
		setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Love Java");
		label.setFont(new Font("Arial", Font.PLAIN, 10)); // 10 픽셀 크기
		
		label.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				int n = e.getWheelRotation();
				if(n < 0) { // up direction. 폰트 작게
					JLabel la = (JLabel)e.getSource();
					Font f = la.getFont();
					int size = f.getSize();
					if(size <= 5)
						return;
					la.setFont(new Font("Arial", Font.PLAIN, size-5)); 
				}
				else { // down direction. 폰트 크게
					JLabel la = (JLabel)e.getSource();
					Font f = la.getFont();
					int size = f.getSize();
					la.setFont(new Font("TimesRoman", Font.PLAIN, size+5)); 
				}
			}
		});
		add(label);
		setSize(300,150);
		setVisible(true);
		label.requestFocus();
	}
	static public void main(String [] args) {
		new MouseWheelFrame();
	}
}
