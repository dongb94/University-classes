package chopsticks;

import display.Game_stage;
/**Pattern 클래스들을 통합관리하여 발사하는 클래스
 * @author 변동건
 * */
public class Patterns implements Runnable {
	/**게임이 진행되는 화면*/
	private Game_stage game;
	
	/**Game_stage객체로 초기화 시킨다.
	 * 
	 * @param game 게임 화면
	 */
	public Patterns(Game_stage game) {
		this.game = game;
	}
	/**패턴 1 실행*/
	private void pattern1() {
		new Pattern1(game);
	}
	/**패턴 2 실행*/
	private void pattern2() {
		new Pattern2(game);
	}
	/**패턴 3 실행*/
	private void pattern3() {
		new Pattern3(game);
	}
	/**패턴 4 실행*/
	private void pattern4() {
		new Pattern4(game);
	}
	/**패턴 5 실행*/
	private void pattern5() {
		new Pattern5(game);
	}
	/** 패턴들을 실행하는 run 메소드 */
	public void run() {
		int i=0;
		while (game.player.getLife() > 0) {
			pattern1();
			if (i>45||(i % 3 == 2 && i > 20))
				pattern3();
			if (i == 10 || i == 30 || i == 40)
				pattern4();
			if (i == 15 || i == 35 || i == 40)
				pattern5();
			if (i % 5 == 1 && i > 5)
				pattern2();
			try{
				i++;
				Thread.sleep(1000);
			}catch(InterruptedException ex){
				
			}
		}
	}
}
