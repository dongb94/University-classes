package chopsticks;

import javax.swing.JFrame;

public abstract class Chopstick {
	/**젓가락의 속도*/
	protected int speed;
	/**젓가락의 가속도*/
	protected int acceleration;
	/**젓가락의 추적기능 여부*/
	protected boolean tracking;
	/**젓가락의 크기*/
	protected int size;
	/**젓가락을 출력할 프레임*/
	protected JFrame gameFrame;
	/** 초기화 */
	protected Chopstick(JFrame game){
		speed=10;
		size=40;
		this.gameFrame=game;
	}
	/** 추적기능을 포함한 초기화 */
	protected Chopstick(JFrame game, boolean tracking){
		speed=10;
		size=40;
		this.gameFrame=game;
		this.tracking=tracking;
	}
	/** 젓가락의 속도 조정 */
	public void setSpeed(int chopSpeed){//젓가락 속도 조정
		speed=chopSpeed;
	}
	/** 젓가락의 크기조정 */
	public void setSize(int chopSize){
		size=chopSize;
	}
}


