package character;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**캐릭터 움직이기 위한 키보드 입력 클래스 */
public class MyKeyListener extends PlayerManager implements KeyListener {
	/**
	 * get key pressed
	 * 
	 * @param e keyevent
	 */
	public void keyPressed(KeyEvent e) {

		int keyCode = e.getKeyCode(); 

		switch (keyCode) {
		case KeyEvent.VK_UP:
			PlayerMove.up = true;
			break;
		case KeyEvent.VK_DOWN:
			PlayerMove.down = true;
			break;
		case KeyEvent.VK_LEFT:
			PlayerMove.left = true;
			break;
		case KeyEvent.VK_RIGHT:
			PlayerMove.right = true;
			break;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * get keyReleased
	 * 
	 * @param e keyevent
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			PlayerMove.up = false;
			break;
		case KeyEvent.VK_DOWN:
			PlayerMove.down = false;
			break;
		case KeyEvent.VK_LEFT:
			PlayerMove.left = false;
			break;
		case KeyEvent.VK_RIGHT:
			PlayerMove.right = false;
			break;
		}
	}
}