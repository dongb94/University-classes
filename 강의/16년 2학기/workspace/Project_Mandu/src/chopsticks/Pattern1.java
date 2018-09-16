package chopsticks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import chopsticks.Shooting;
import display.Game_stage;
/**랜덤 발사 패턴 클래스
 * @author 변동건
 * */
public class Pattern1 {
	/**랜덤 발사 패턴
	 * 젓가락 1개를 만두를 향해 날아가게 한다.
	 * 출발 위치는 접시주변 랜덤한 위치이다.
	 * @param game 게임 화면
	 */
	public Pattern1(Game_stage game) {
		ExecutorService es = Executors.newFixedThreadPool(1);
		double ran = Math.random() * 10;
		Shooting shot = new Shooting(game, (int) (425 + 600 * Math.cos(45 * ran)),
				(int) (425 + 600 * Math.sin(45 * ran)));
		es.execute(shot);
		es.shutdown();
	}
}