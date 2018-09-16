import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImageLabelDraggingFrame extends JFrame {
	public ImageLabelDraggingFrame(){
		super("이미지 레이블 드래깅 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(null);
		
		ImageIcon icon = new ImageIcon("images/apple.jpg");		
		JLabel imageLabel = new JLabel(icon);
		imageLabel.setSize(icon.getIconHeight(),icon.getIconWidth());
		imageLabel.setLocation(100,100);
		MyMouseListener  ml = new MyMouseListener();
		imageLabel.addMouseListener(ml);
		imageLabel.addMouseMotionListener(ml);
		add(imageLabel);
		setSize(300,300);
		setVisible(true);
	}
	
	class MyMouseListener extends MouseAdapter implements MouseMotionListener {
		Point startP = new Point();
		public void mousePressed(MouseEvent e) {
			startP = e.getPoint();
		}
		public void mouseReleased(MouseEvent e) {
			Point endP = e.getPoint();
			JComponent la = (JComponent)(e.getSource());
			Point p = la.getLocation();
			la.setLocation(p.x + endP.x - startP.x, p.y + endP.y - startP.y);
			la.getParent().repaint();
		}
		public void mouseDragged(MouseEvent e) {
			Point endP = e.getPoint();
			Component la = (JComponent)(e.getSource());
			Point p = la.getLocation();
			la.setLocation(p.x + endP.x - startP.x, p.y + endP.y - startP.y);
		}	
	}
	
	static public void main(String[] args) {
		new ImageLabelDraggingFrame();
	}
}
