package chopsticks;

import javax.swing.JFrame;

public abstract class Chopstick {
	/**�������� �ӵ�*/
	protected int speed;
	/**�������� ���ӵ�*/
	protected int acceleration;
	/**�������� ������� ����*/
	protected boolean tracking;
	/**�������� ũ��*/
	protected int size;
	/**�������� ����� ������*/
	protected JFrame gameFrame;
	/** �ʱ�ȭ */
	protected Chopstick(JFrame game){
		speed=10;
		size=40;
		this.gameFrame=game;
	}
	/** ��������� ������ �ʱ�ȭ */
	protected Chopstick(JFrame game, boolean tracking){
		speed=10;
		size=40;
		this.gameFrame=game;
		this.tracking=tracking;
	}
	/** �������� �ӵ� ���� */
	public void setSpeed(int chopSpeed){//������ �ӵ� ����
		speed=chopSpeed;
	}
	/** �������� ũ������ */
	public void setSize(int chopSize){
		size=chopSize;
	}
}


