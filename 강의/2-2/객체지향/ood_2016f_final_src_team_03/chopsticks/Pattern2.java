package chopsticks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import chopsticks.Shooting;
import display.Game_stage;
/**6방향에서 동시발사 패턴 클래스
 * @author 변동건
 * */
public class Pattern2 {
	/**6방향에서 동시발사 패턴
	 * 스테이지 주변에서 60도마다 젓가락이 1개씩 총 6개의 젓가락이 만두를 향해 날아간다.
	 * 
	 * @param game 게임 화면
	 */
	public Pattern2(Game_stage game){
		ExecutorService es = Executors.newFixedThreadPool(6);
		for(int i=0; i<6; i++)
		{
			Shooting shot=new Shooting(game,(int)(425+600*Math.cos(45*i)),(int)(425+600*Math.sin(45*i)));
			es.execute(shot);
		}
		es.shutdown();
	}
}