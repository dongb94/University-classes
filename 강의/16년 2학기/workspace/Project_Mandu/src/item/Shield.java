package item;

import java.net.URL;
import javax.swing.*;

/**
 * 쉴드 이미지 출력과 효과 구현하는 클래스
 * 
 * @author 심지영
 *
 */
class Shield extends ItemManager implements Runnable {
	/** 이미지 URL */
	private URL imageURL;
	/** 쉴드 이미지 아이콘 */
	public ImageIcon Shieldimg = new ImageIcon(imageURL = getClass().getClassLoader().getResource("shield.png"));
	/** 쉴드 jlabel */
	public JLabel Shield = new JLabel();

	/** 쉴드 기본 생성자 */
	public Shield() {
	}

	/** 쉴드 출력하는 메소드 */
	public void run() {
		pm.upLife();
		while (true) {
			if (pm.getLife() == 2) {
				Shield.setIcon(Shieldimg);
				Shield.setSize(100, 110);
				Shield.setLocation(pm.getMandu().getX() - 20, pm.getMandu().getY() - 35);
				gameFrame.add(Shield);
				gameFrame.repaint();
				try {
					Thread.sleep(20);
				} catch (InterruptedException ex) {
					
				}
				if (pm.getLife() == 1) {
					gameFrame.remove(Shield);
					gameFrame.repaint();
					return;
				}
			}

		}
	}
}