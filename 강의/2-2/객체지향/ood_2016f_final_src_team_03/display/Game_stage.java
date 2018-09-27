package display;

import java.awt.*;
import java.net.URL;

import javax.swing.*;
import character.*;
import chopsticks.Patterns;
import item.RandomBox;
import score.ScorePane;
import sound.SoundManager;

/**
 * ����ȭ�� Ŭ����
 * 
 * @author ������
 * @see DisplayManager
 */
public class Game_stage extends DisplayManager {
	/**�÷��̾� �Ŵ��� ��ü
	 * @author ������
	 */
	public PlayerManager player;
	/** ���� �̹��� �� 
	 * @author ������
	 */
	public JLabel[] ganjang = new JLabel[21];
	/** ������ ���������� ǥ���ϴ� ��ü
	 * @author ������
	 */
	public ScorePane scorepane;
	public Game_stage() {
		/**�̹��� URL*/
		URL imageURL;
		ImageIcon dishIcon = new ImageIcon(imageURL=getClass().getClassLoader().getResource("background.png"));
		JLabel dish = new JLabel(dishIcon);
		dish.setBounds(-335, 60, 1500, 900);
		setContentPane(dish);
		Container contentpane = getContentPane();// ����Ʈ ���� �˾Ƴ���
		contentpane.setLayout(null);// ���̾ƿ�����
		contentpane.setVisible(true);
		
		
		for (int i = 0; i < 21; i++) {
			ganjang[i] = new JLabel();
			contentpane.add(ganjang[i]);
		}

		scorepane = new ScorePane(this);
		Thread score = new Thread(scorepane);
		score.setPriority(10);

		ImageIcon stage = new ImageIcon(imageURL=getClass().getClassLoader().getResource("stage.png"));
		JLabel stage1 = new JLabel(stage);
		stage1.setBounds(0, 0, 1500, 900);
		contentpane.add(stage1);

		MyKeyListener listener = new MyKeyListener();
		addKeyListener(listener);
		
		player = new PlayerManager();
		player.setCharacter(player.choice);
		contentpane.add(player.mandu);
		
		Patterns p = new Patterns(this);
		Thread pattern = new Thread(p);
		pattern.start();

	    Thread t = new Thread(new RandomBox(this));
		t.start();
		
		new SoundManager(this, 4);
		setVisible(true);
		score.start();
		
		new CheckLife(this).start();;
		
	}
}
/**
 * ������ ����� üũ�ϴ� Ŭ����
 * @author ������
 * */
class CheckLife extends Thread{
	/**���� ȭ��*/
	private Game_stage game;
	/**���� ȭ������ �ʱ�ȭ
	 * 
	 * @param game ����ȭ��
	 */
	public CheckLife(Game_stage game){
		this.game=game;
	}
	/**������ ���� üũ�ϴ� �޼ҵ�
	 * ���� ������ OverŬ������ ȣ����*/
	public void run(){
		while(true) {
			if (game.player.getLife() <= 0) {
				try {
					new SoundManager(game, 3);
					Thread.sleep(800);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				game.dispose();
				new Over(game.scorepane.getScore());
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}