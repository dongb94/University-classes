package chopsticks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import chopsticks.Shooting;
import display.Game_stage;
/**유도 패턴 클래스
 * @author 변동건
 * */
public class Pattern3 {
	/**유도 패턴
	 * 만두의 위치를 조금씩 추적하는 젓가락 1개를 생성한다.
	 * 출발위치는 접시주변 랜덤한 위치이다.
	 * @param game 게임 화면
	 * */
	public Pattern3(Game_stage game) {
		ExecutorService es = Executors.newFixedThreadPool(1);
		double ran = Math.random() * 10;
		Shooting shot = new Shooting(game, (int) (425 + 600 * Math.cos(45 * ran)),
				(int) (425 + 600 * Math.sin(45 * ran)), true);
		es.execute(shot);
		es.shutdown();
	}
}