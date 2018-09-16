import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LeftKeyFrame extends JFrame {
	public LeftKeyFrame() {
		super("Left 키로 문자열 교체");		
		setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Love Java");
		label.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					JLabel la = (JLabel)e.getSource();
					StringBuffer text  = new StringBuffer(la.getText());
					la.setText(text.reverse().toString());
				}
			}
		});
		add(label);
		setSize(250,100);
		setVisible(true);
		label.requestFocus();
	}
	static public void main(String [] args) {
		new LeftKeyFrame();
	}
}
