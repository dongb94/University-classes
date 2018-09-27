package item;

import java.net.URL;
import javax.swing.*;

/**
 * ���� �̹��� ��°� ȿ�� �����ϴ� Ŭ����
 * 
 * @author ������
 *
 */
class Shield extends ItemManager implements Runnable {
	/** �̹��� URL */
	private URL imageURL;
	/** ���� �̹��� ������ */
	public ImageIcon Shieldimg = new ImageIcon(imageURL = getClass().getClassLoader().getResource("shield.png"));
	/** ���� jlabel */
	public JLabel Shield = new JLabel();

	/** ���� �⺻ ������ */
	public Shield() {
	}

	/** ���� ����ϴ� �޼ҵ� */
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