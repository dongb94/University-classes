package character;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**Class Description of PlayerManager*/
public class PlayerManager {
	/**Field Description of life*/
	int life = 1;  //life는 0이면 gameover
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
	void controlSize(int a, int b) { //ItemManager에서 거대화 소형화에 사용
		mandu.setSize(a,b);
	}
	public JLabel getMandu(){
		return mandu;
	}
	

//Char1, Char2, Char3중에 선택한거 new Char n()로 부름
/**Class Description of Character1*/
class Char1 extends PlayerManager{
	//character마다 image다르게 줘서 jlabel생성. 기능은 똑같이. 
	Char1() {
		ImageIcon image = new ImageIcon("image/꽃만두.png");
		mandu = new JLabel(image);
		mandu.setSize(50,50);
		mandu.setLocation(450,400);
	}
	
}
/**Class Description of Character2*/
class Char2 extends PlayerManager{
	Char2() {
		ImageIcon image = new ImageIcon("image/탄만두.png");
		mandu = new JLabel(image);
		mandu.setSize(50,50);
		mandu.setLocation(450,400);
	}
	
}
/**Class Description of Character3*/
class Char3 extends PlayerManager{
	Char3() {
		ImageIcon image = new ImageIcon("image/수염만두.png");
		mandu = new JLabel(image);
		mandu.setSize(50,50);
		mandu.setLocation(450,400);
	}
	
}
}
