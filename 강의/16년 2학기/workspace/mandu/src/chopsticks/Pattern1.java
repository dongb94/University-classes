package chopsticks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;

import chopsticks.Shooting;
import display.Game_stage;
/**랜덤 발사 패턴*/
public class Pattern1 {
	/**랜덤 발사 패턴*/
	public Pattern1(Game_stage game) {
		ExecutorService es = Executors.newFixedThreadPool(20);
		double ran = Math.random() * 10;
		Shooting shot = new Shooting(game, (int) (425 + 600 * Math.cos(45 * ran)),
				(int) (425 + 600 * Math.sin(45 * ran)));
		es.execute(shot);
		es.shutdown();
	}
}