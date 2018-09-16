package chopsticks;
import java.awt.Rectangle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import chopsticks.Shooting;
import display.Game_stage;
/**병렬 발사 패턴2 클래스
 * @author 변동건
 * */
public class Pattern5 {
	/**병렬 발사 패턴2
	 * 오른쪽에서 젓가락이 1줄로 동시에 발사된다.
	 * @param game 게임 화면
	 * */
	public Pattern5(Game_stage game) {
		ExecutorService es = Executors.newFixedThreadPool(10);
		for(int i=1; i<=10 ; i++){
			Rectangle r=new Rectangle();
			r.setBounds(0, i*80-40, 0, 0);
			Shooting shot = new Shooting(game, 1000, i*80-40, r);
			es.execute(shot);
		}
		es.shutdown();
	}
}