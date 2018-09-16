package character;

import sound.SoundManager;

public class PlayerMove implements Runnable {
	/** up������ ���¸� true */
	public static boolean up = false;
	/** down������ ���¸� true */
	public static boolean down = false;
	/** left������ ���¸� true */
	public static boolean left = false;
	/** right������ ���¸� true */
	public static boolean right = false;

	/** ĳ���� ������ ������ ���� �޼ҵ� */
	public void run() {
		boolean sound = false;
		while (PlayerManager.life > 0) {
			int speed = PlayerManager.speed;
			sound = true;

			if (up) {
				if (PlayerManager.mandu.getY() - speed >= 30) {
					PlayerManager.mandu.setLocation(PlayerManager.mandu.getX(), PlayerManager.mandu.getY() - speed);
				}
				if (sound) {
					new SoundManager(PlayerManager.mandu, 11);
					sound = false;
				}
			}
			if (down) {
				if (PlayerManager.mandu.getY() + speed < 700) {
					PlayerManager.mandu.setLocation(PlayerManager.mandu.getX(), PlayerManager.mandu.getY() + speed);

				}
				if (sound) {
					new SoundManager(PlayerManager.mandu, 11);
					sound = false;
				}
			}
			if (left) {
				if (PlayerManager.mandu.getX() - speed >= 0) {
					PlayerManager.mandu.setLocation(PlayerManager.mandu.getX() - speed, PlayerManager.mandu.getY());

				}
				if (sound) {
					new SoundManager(PlayerManager.mandu, 11);
					sound = false;
				}
			}
			if (right) {
				if (PlayerManager.mandu.getX() + speed < 900) {
					PlayerManager.mandu.setLocation(PlayerManager.mandu.getX() + speed, PlayerManager.mandu.getY());

				}
				if (sound) {
					new SoundManager(PlayerManager.mandu, 11);
					sound = false;
				}
			}
			PlayerManager.mandu.repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {

			}
		}
	}

}
