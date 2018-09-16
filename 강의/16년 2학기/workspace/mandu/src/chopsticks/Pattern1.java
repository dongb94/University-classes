package chopsticks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;

import chopsticks.Shooting;
import display.Game_stage;
/**���� �߻� ����*/
public class Pattern1 {
	/**���� �߻� ����*/
	public Pattern1(Game_stage game) {
		ExecutorService es = Executors.newFixedThreadPool(20);
		double ran = Math.random() * 10;
		Shooting shot = new Shooting(game, (int) (425 + 600 * Math.cos(45 * ran)),
				(int) (425 + 600 * Math.sin(45 * ran)));
		es.execute(shot);
		es.shutdown();
	}
}