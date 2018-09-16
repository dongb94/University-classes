package chopsticks;

import javax.swing.JFrame;
/**젓가락의 기본정보를 포함하는 추상클래스
 *  
 * @author 변동건
 **/
public abstract class Chopstick {
	/**젓가락의 속도
	 * 1번에 움직이는 픽셀의 숫자*/
	protected int speed;
	/**젓가락의 가속도*/
	protected int acceleration;
	/**젓가락의 추적기능 여부*/
	protected boolean tracking;
	/**젓가락의 크기*/
	protected int size;
	/**젓가락을 출력할 프레임*/
	protected JFrame gameFrame;
	/** 젓가락을 출력할 프레임을 받아 초기화 
	 * 
	 * @param game 게임 프레임
	 */
	protected Chopstick(JFrame game){
		speed=10;
		size=40;
		this.gameFrame=game;
	}
	/** 추적기능을 포함한 초기화 
	 * 
	 * @param game 게임 프레임
	 * @param tracking 젓가락 유도 기능여부
	 */
	protected Chopstick(JFrame game, boolean tracking){
		speed=10;
		size=40;
		this.gameFrame=game;
		this.tracking=tracking;
	}
	/** 젓가락의 속도 조정 
	 * 
	 * @param chopSpeed 설정할 젓가락의 속도
	 */
	public void setSpeed(int chopSpeed){//젓가락 속도 조정
		speed=chopSpeed;
	}
	/** 젓가락의 크기조정 
	 * 
	 * @param chopSize 설정할 젓가락의 크기
	 */
	public void setSize(int chopSize){
		size=chopSize;
	}
}
