package item;

import java.net.URL;
import java.util.Random;

import javax.swing.*;
import display.Game_stage;
import effect.BigTextEffect;
import effect.GanjangEffect;
import effect.GanjangTextEffect;
import effect.ShieldTextEffect;
import effect.SmallTextEffect;

/**
 * �������� ������ ����ϴ� RandomBox Ŭ���� /
 * 
 * @author ������
 *
 */
public class RandomBox extends ItemManager implements Runnable {
	/** Random�� ��ü random */
	private Random random = new Random();
	/** ChangeSize�� ��ü change */
	private ChangeSize change = new ChangeSize();
	/** Shield�� ��ü shield */
	private Shield shield = new Shield();
	/** GanjangShot�� ��ü ganjang */
	private GanjangShot ganjang;
	/** �̹��� URL */
	private URL imageURL;
	/** ���� �ڽ� �̹��� ������ */
	private ImageIcon box = new ImageIcon(imageURL = getClass().getClassLoader().getResource("random.png"));
	/** ���� �ڽ� jlabel */
	private JLabel randombox = new JLabel();
	/** while�� �ݺ� ���� �����ϴ� �ʵ� */
	private boolean flag = false;

	/** �����ڽ� �⺻ ������ */
	public RandomBox() {

	}

	/**
	 * ����� �����ڽ� �ʱ�ȭ�ϴ� �����ڽ� ������
	 * 
	 * @param game
	 *            Game_stage
	 */
	public RandomBox(Game_stage game) {
		super(game);
		ganjang = new GanjangShot(game, game.ganjang);
	}

	/** ������ �����ϴ� run�޼ҵ� */
	@Override
	public void run() {
		randombox.setIcon(box);
		randombox.setSize(50, 50);
		randombox.setLocation(1500, 1500);
		gameFrame.add(randombox);
		int index = 1;
		while (true) {
			if (index == 1 && gameFrame.scorepane.getScore() > 1000) {
				BoxSetlocation();
				flag = true;
				index++;
			}

			if (flag && index == 2 && gameFrame.scorepane.getScore() > 1800) {
				randombox.setLocation(1500, 1500);
				gameFrame.repaint();
				index++;
			}

			if (index == 3 && gameFrame.scorepane.getScore() > 3000) {
				BoxSetlocation();
				flag = true;
				index++;
			}

			if (flag && gameFrame.scorepane.getScore() > 3800) {
				randombox.setLocation(1500, 1500);
				gameFrame.repaint();
				break;
			}
			
			if (flag || index == 2 || index == 4) {
				getItem();
				randombox.repaint();
				if(!flag) index++;
			}
			
			if (index == 5) break;
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {

			}
		}
	}

	/** �����ڽ��� ��ġ �������� ����ϴ� �޼ҵ� */
	public void BoxSetlocation() {
		int x = (int) (Math.random() * 400);
		int y = (int) (Math.random() * 400) + 50;
		randombox.setLocation(x, y);

	}

	/** ������ ����� �Ǻ����ִ� �޼ҵ� */
	public void getItem() {
		// ������ ������ �̹����� ��������ϰ� ȿ�� ����
		double distance;
		int x = randombox.getX() - pm.getMandu().getX();
		int y = randombox.getY() - pm.getMandu().getY();
		distance = Math.sqrt(x * x + y * y);

		if (flag == true && distance < 50) {
			flag = false;
			randombox.setLocation(1500, 1500);

			JLabel text = new JLabel();
			text.setLocation(gameFrame.player.mandu.getLocation());
			switch (random.nextInt(4) + 1) {
			case 1:
				new Thread(new ShieldTextEffect(gameFrame, text)).start();
				new Thread(shield).start();
				;
				// ���� �ҷ�����
				break;
			case 2:
				new Thread(new BigTextEffect(gameFrame, text)).start();
				change.appearBig();
				// ����ȭ �ҷ�����
				break;
			case 3:
				new Thread(new SmallTextEffect(gameFrame, text)).start();
				change.appearSmall();
				// ����ȭ �ҷ�����
				break;
			case 4:
				new Thread(new GanjangTextEffect(gameFrame, text)).start();
				ganjang.start();
				ganjang.ganjang[20].setLocation(1115, 500);
				new Thread(new GanjangEffect(gameFrame, ganjang.ganjang[20])).start();
				// ���� �ҷ�����
				break;
			}

		}

	}

}
