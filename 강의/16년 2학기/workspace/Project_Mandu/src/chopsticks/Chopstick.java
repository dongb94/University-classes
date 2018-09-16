package chopsticks;

import javax.swing.JFrame;
/**�������� �⺻������ �����ϴ� �߻�Ŭ����
 *  
 * @author ������
 **/
public abstract class Chopstick {
	/**�������� �ӵ�
	 * 1���� �����̴� �ȼ��� ����*/
	protected int speed;
	/**�������� ���ӵ�*/
	protected int acceleration;
	/**�������� ������� ����*/
	protected boolean tracking;
	/**�������� ũ��*/
	protected int size;
	/**�������� ����� ������*/
	protected JFrame gameFrame;
	/** �������� ����� �������� �޾� �ʱ�ȭ 
	 * 
	 * @param game ���� ������
	 */
	protected Chopstick(JFrame game){
		speed=10;
		size=40;
		this.gameFrame=game;
	}
	/** ��������� ������ �ʱ�ȭ 
	 * 
	 * @param game ���� ������
	 * @param tracking ������ ���� ��ɿ���
	 */
	protected Chopstick(JFrame game, boolean tracking){
		speed=10;
		size=40;
		this.gameFrame=game;
		this.tracking=tracking;
	}
	/** �������� �ӵ� ���� 
	 * 
	 * @param chopSpeed ������ �������� �ӵ�
	 */
	public void setSpeed(int chopSpeed){//������ �ӵ� ����
		speed=chopSpeed;
	}
	/** �������� ũ������ 
	 * 
	 * @param chopSize ������ �������� ũ��
	 */
	public void setSize(int chopSize){
		size=chopSize;
	}
}
