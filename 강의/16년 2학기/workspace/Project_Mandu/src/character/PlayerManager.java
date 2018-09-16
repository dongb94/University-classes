package character;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**ĳ���� �����ϴ� PlayerManager class
 * 
 * @author jiyoung sim
 *
 */

public class PlayerManager {
	/**������  ����*/
	static int life = 1;  //life�� 0�̸� gameover
	/**���� ��*/
	public static JLabel mandu;
	/**���� �����̴� �ӵ�*/ 
	public static int speed = 5;  //�ȼ� 15
	/**ĳ���� ����, �⺻ ������ 1*/
	public static int choice = 1;
	/**image, image_s, image_b �̹��� ������*/
	public static ImageIcon image, image_s, image_b;
	/**���� ũ��, �⺻ 50*/
	public int size=50;
	
	/**PlayerManager������
	 * 
	 * PlayerMove�ʱ�ȭ
	 * 
	 *  */
	public PlayerManager() {
		life = 1;
		PlayerMove pm=new PlayerMove();
		Thread thread=new Thread(pm);
		thread.setPriority(10);
		thread.start();
	}
	/**ĳ���� ���� ����
	 * 
	 * @param r ĳ���� ���� ���
	 * */
	public void setCharacter(int r){
		if(r==1)
			new Char1();
		if(r==2)
			new Char2();
		if(r==3)
			new Char3();
	}
	/**ĳ������ ���� ���
	 *
	 *	 @return life�� ��
	 */
	public int getLife(){
		return life;
	}
	/**ĳ������ ���� �ϳ� �ø�*/
	public void upLife() {
		life+=1;
	}
	/**ĳ������ ���� �ϳ� ����*/
	public void downLife() {
		life-=1;
	}
	/**ĳ������ ���ǵ� ������ ����*/
	public void setSpeed(){
		speed = 1;
	}
	/**ĳ������ ���ǵ� ���*/
	public int getSpeed(){
		return speed;
	}
	/**ĳ������ �̹��� ����*/
	public void setImage(){
		mandu.setIcon(image);
		mandu.setSize(50,50);
	}
	/** ����ȭ �̹��� ���� */
	public void setSmallImage() {
		mandu.setIcon(image_s);
		mandu.setSize(40,40);
	}
	/** �Ŵ�ȭ �̹��� ���� */
	public void setBigImage() {
		mandu.setIcon(image_b);
		mandu.setSize(70,70);
	}
	/**���� ���
	 * 
	 * @return mandu Instance
	 */
	public JLabel getMandu(){
		return mandu;
	}
	
}
//Char1, Char2, Char3�߿� �����Ѱ� new Char n()�� �θ�
/**Character1 �����ϴ� Ŭ���� */
class Char1 extends PlayerManager{
	//character���� image�ٸ��� �༭ jlabel����. ����� �Ȱ���. 
	/**�̹��� URL*/
	URL imageURL;
	/**Character1 �����ϴ� ������ */
	Char1() {
		image = new ImageIcon(imageURL=getClass().getClassLoader().getResource("��������.png"));
		mandu = new JLabel(image);
		mandu.setSize(size,size);
		mandu.setLocation(450,400);
		image_s = new ImageIcon(imageURL=getClass().getClassLoader().getResource("��������small.png"));
		image_b = new ImageIcon(imageURL=getClass().getClassLoader().getResource("��������big.png"));
		
	}
	
}
/**Character2�����ϴ� Ŭ����*/
class Char2 extends PlayerManager{
	/**�̹��� URL*/
	URL imageURL;
	/**Character2�����ϴ� ������*/
	Char2() {
		image = new ImageIcon(imageURL=getClass().getClassLoader().getResource("ź����.png"));
		mandu = new JLabel(image);
		mandu.setSize(size,size);
		mandu.setLocation(450,400);
		image_s = new ImageIcon(imageURL=getClass().getClassLoader().getResource("ź����small.png"));
		image_b = new ImageIcon(imageURL=getClass().getClassLoader().getResource("ź����big.png"));
		
	}
	
}
/**Character3�����ϴ� Ŭ����*/
class Char3 extends PlayerManager{
	/**�̹��� URL*/
	URL imageURL;
	/**Character3�����ϴ� ������*/
	Char3() {
		image = new ImageIcon(imageURL=getClass().getClassLoader().getResource("�ɸ���.png"));
		mandu = new JLabel(image);
		mandu.setSize(size,size);
		mandu.setLocation(450,400);
		image_s = new ImageIcon(imageURL=getClass().getClassLoader().getResource("�ɸ���small.png"));
		image_b = new ImageIcon(imageURL=getClass().getClassLoader().getResource("�ɸ���big.png"));
		
	}
	
}

