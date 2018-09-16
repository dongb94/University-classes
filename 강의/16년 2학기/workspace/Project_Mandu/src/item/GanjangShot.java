package item;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JLabel;

import display.Game_stage;
/**간장 랜덤 발사 패턴 클래스
 * @author 변동건
 * */
public class GanjangShot extends Thread {
	/**간장이 발사될 게임 화면*/
	private Game_stage game;
	/**간장 이미지로 사용할 객체*/
	protected JLabel[] ganjang=new JLabel[20];
	/**간장이 발사될 게임 화면과 간장의 이미지를 구현할 JLabel로 초기화
	 * 
	 * @param game 간장이 발사될 게임 화면
	 * @param ganjang 간장의 이미지를 구현할 JLabel
	 */
	public GanjangShot(Game_stage game,JLabel[] ganjang) {
		this.game=game;
		this.ganjang=ganjang;
	}
	/**Ganjang 클래스를 호출해 각각의 간장을 날리는 run메소드*/
	public void run(){
		ExecutorService es = Executors.newFixedThreadPool(20);
		for(int i=0; i<20; i++){
			Ganjang shot=new Ganjang(game,ganjang[i]);
			es.execute(shot);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		es.shutdown();
	}
}