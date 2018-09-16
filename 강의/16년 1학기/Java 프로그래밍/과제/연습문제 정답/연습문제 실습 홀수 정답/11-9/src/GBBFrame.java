import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GBBFrame extends JFrame {
	ImageIcon [] gbbImage = { new ImageIcon("images/gawi.jpg"),
			new ImageIcon("images/bawi.jpg"),
			new ImageIcon("images/bo.jpg")
	};
	static String SAME = "Same !!!";
	static String ME_WINNER = "ME !!!";
	static String COM_WINNER = "Computer !!!";
	
	MenuPanel menuPanel = new MenuPanel(); 
	GamePanel gamePanel = new GamePanel();
	
	public GBBFrame() {
		super("가위 바위 보 게임");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(menuPanel, BorderLayout.NORTH);
		add(gamePanel, BorderLayout.CENTER);

		setSize(400,300);
		setVisible(true);
	}
	
	class MenuPanel extends JPanel {
		JButton [] gbbBtn = new JButton [3];
		public MenuPanel() {
			setBackground(Color.GRAY);			
			for(int i=0; i<gbbBtn.length; i++) {
				gbbBtn[i] = new JButton(gbbImage[i]);
				add(gbbBtn[i]);
				
				gbbBtn[i].addActionListener(new MyActionListener());
			}
		}
	}
		
	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			int computerPart = (int)(Math.random()*3); // 0~2;
			
			String winner = SAME;  
			
			if(btn.getIcon() == gbbImage[0] && computerPart == 2 ||
					btn.getIcon() == gbbImage[1] && computerPart == 0 || 
					btn.getIcon() == gbbImage[2] && computerPart == 1)
				winner = ME_WINNER;
			else if(btn.getIcon() == gbbImage[0] && computerPart == 1 ||
					btn.getIcon() == gbbImage[1] && computerPart == 2 || 
					btn.getIcon() == gbbImage[2] && computerPart == 0)
				winner = COM_WINNER;
			else
				winner = SAME;							
				
			gamePanel.draw(btn.getIcon(), gbbImage[computerPart], winner);
		}
	}
	
	class GamePanel extends JPanel {
		JLabel me = new JLabel("me");
		JLabel computer = new JLabel("com");
		JLabel winner = new JLabel("Winner");
		
		public GamePanel() {
			setBackground(Color.YELLOW);			
			add(me);
			add(computer);
			add(winner);
			winner.setForeground(Color.RED);
		}
		
		public void draw(Icon myImage, Icon computerImage, String w) {
			me.setIcon(myImage);
			computer.setIcon(computerImage);
			winner.setText(w); 

		}
	}
	
	public static void main(String[] args) {
		new GBBFrame();
	}
}
