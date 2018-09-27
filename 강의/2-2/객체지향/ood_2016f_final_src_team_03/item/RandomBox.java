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
 * 랜덤으로 아이템 출력하는 RandomBox 클래스 /
 * 
 * @author 심지영
 *
 */
public class RandomBox extends ItemManager implements Runnable {
	/** Random의 객체 random */
	private Random random = new Random();
	/** ChangeSize의 객체 change */
	private ChangeSize change = new ChangeSize();
	/** Shield의 객체 shield */
	private Shield shield = new Shield();
	/** GanjangShot의 객체 ganjang */
	private GanjangShot ganjang;
	/** 이미지 URL */
	private URL imageURL;
	/** 랜덤 박스 이미지 아이콘 */
	private ImageIcon box = new ImageIcon(imageURL = getClass().getClassLoader().getResource("random.png"));
	/** 랜덤 박스 jlabel */
	private JLabel randombox = new JLabel();
	/** while문 반복 여부 결정하는 필드 */
	private boolean flag = false;

	/** 랜덤박스 기본 생성자 */
	public RandomBox() {

	}

	/**
	 * 간장과 랜덤박스 초기화하는 랜덤박스 생성자
	 * 
	 * @param game
	 *            Game_stage
	 */
	public RandomBox(Game_stage game) {
		super(game);
		ganjang = new GanjangShot(game, game.ganjang);
	}

	/** 스레드 실행하는 run메소드 */
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

	/** 랜덤박스의 위치 랜덤으로 출력하는 메소드 */
	public void BoxSetlocation() {
		int x = (int) (Math.random() * 400);
		int y = (int) (Math.random() * 400) + 50;
		randombox.setLocation(x, y);

	}

	/** 아이템 얻는지 판별해주는 메소드 */
	public void getItem() {
		// 아이템 얻으면 이미지는 사라지게하고 효과 구현
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
				// 쉴드 불러오기
				break;
			case 2:
				new Thread(new BigTextEffect(gameFrame, text)).start();
				change.appearBig();
				// 대형화 불러오기
				break;
			case 3:
				new Thread(new SmallTextEffect(gameFrame, text)).start();
				change.appearSmall();
				// 소형화 불러오기
				break;
			case 4:
				new Thread(new GanjangTextEffect(gameFrame, text)).start();
				ganjang.start();
				ganjang.ganjang[20].setLocation(1115, 500);
				new Thread(new GanjangEffect(gameFrame, ganjang.ganjang[20])).start();
				// 간장 불러오기
				break;
			}

		}

	}

}
