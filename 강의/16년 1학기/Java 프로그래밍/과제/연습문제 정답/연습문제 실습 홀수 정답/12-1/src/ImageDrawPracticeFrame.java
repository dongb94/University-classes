import java.awt.*;
import javax.swing.*;

public class ImageDrawPracticeFrame extends JFrame {
	public ImageDrawPracticeFrame(){
		super("이미지 그리기 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new MyPanel());
		setSize(300,300);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		ImageIcon icon = new ImageIcon("images/back.jpg");
		Image img = icon.getImage();
		public MyPanel() {
			setLayout(new FlowLayout());
			add(new JButton("Hello"));
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}
	
	static public void main(String[] args) {
		new ImageDrawPracticeFrame();
	}
}
