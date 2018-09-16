package chopsticks;
import java.awt.Rectangle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import chopsticks.Shooting;
import display.Game_stage;
/**병렬 발사 패턴1 클래스
 * @author 변동건
 * */
public class Pattern4 {
	/**병렬 발사 패턴1
	 * 하단부에서 젓가락이 1줄로 동시에 발사된다.
	 * @param game 게임 화면
	 * */
	public Pattern4(Game_stage game) {
		ExecutorService es = Executors.newFixedThreadPool(10);
		for(int i=1; i<=10 ; i++){
			Rectangle r=new Rectangle();
			r.setBounds(i*80, 0, 0, 0);
			Shooting shot = new Shooting(game, i*80, 900, r);
			es.execute(shot);
		}
		es.shutdown();
	}
}