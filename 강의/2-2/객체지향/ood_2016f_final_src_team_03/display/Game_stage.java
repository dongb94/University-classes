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
 * 게임화면 클래스
 * 
 * @author 나희지
 * @see DisplayManager
 */
public class Game_stage extends DisplayManager {
	/**플레이어 매니저 객체
	 * @author 심지영
	 */
	public PlayerManager player;
	/** 간장 이미지 라벨 
	 * @author 변동건
	 */
	public JLabel[] ganjang = new JLabel[21];
	/** 점수와 스테이지를 표시하는 객체
	 * @author 변동건
	 */
	public ScorePane scorepane;
	public Game_stage() {
		/**이미지 URL*/
		URL imageURL;
		ImageIcon dishIcon = new ImageIcon(imageURL=getClass().getClassLoader().getResource("background.png"));
		JLabel dish = new JLabel(dishIcon);
		dish.setBounds(-335, 60, 1500, 900);
		setContentPane(dish);
		Container contentpane = getContentPane();// 컨텐트 팬을 알아낸다
		contentpane.setLayout(null);// 레이아웃변경
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
 * 만두의 목숨을 체크하는 클레스
 * @author 변동건
 * */
class CheckLife extends Thread{
	/**게임 화면*/
	private Game_stage game;
	/**게임 화면으로 초기화
	 * 
	 * @param game 게임화면
	 */
	public CheckLife(Game_stage game){
		this.game=game;
	}
	/**만두의 목을 체크하는 메소드
	 * 게임 종료후 Over클래스를 호출함*/
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