package character;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**Class Description of PlayerManager*/
public class PlayerManager {
	/**Field Description of life*/
	int life = 1;  //life�� 0�̸� gameover
	/**Field Description of mandu*/
	public static JLabel mandu;
	/**Construction Description of PlayerManager*/
	PlayerManager() {
		
	}
	public PlayerManager(int r){
		if(r==1)
			new Char1();
		if(r==2)
			new Char2();
		if(r==3)
			new Char3();
		
	}
	public int getLife(){
		return life;
	}
	public void upLife() {
		life+=1;
	}
	public void downLife() {
		life-=1;
	}
	
	/**Control the character's size*/
	void controlSize(int a, int b) { //ItemManager���� �Ŵ�ȭ ����ȭ�� ���
		mandu.setSize(a,b);
	}
	public JLabel getMandu(){
		return mandu;
	}
	

//Char1, Char2, Char3�߿� �����Ѱ� new Char n()�� �θ�
/**Class Description of Character1*/
class Char1 extends PlayerManager{
	//character���� image�ٸ��� �༭ jlabel����. ����� �Ȱ���. 
	Char1() {
		ImageIcon image = new ImageIcon("image/�ɸ���.png");
		mandu = new JLabel(image);
		mandu.setSize(50,50);
		mandu.setLocation(450,400);
	}
	
}
/**Class Description of Character2*/
class Char2 extends PlayerManager{
	Char2() {
		ImageIcon image = new ImageIcon("image/ź����.png");
		mandu = new JLabel(image);
		mandu.setSize(50,50);
		mandu.setLocation(450,400);
	}
	
}
/**Class Description of Character3*/
class Char3 extends PlayerManager{
	Char3() {
		ImageIcon image = new ImageIcon("image/��������.png");
		mandu = new JLabel(image);
		mandu.setSize(50,50);
		mandu.setLocation(450,400);
	}
	
}
}
