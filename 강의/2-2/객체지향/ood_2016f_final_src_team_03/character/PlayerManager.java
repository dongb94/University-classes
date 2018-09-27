package character;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**캐릭터 관리하는 PlayerManager class
 * 
 * @author jiyoung sim
 *
 */

public class PlayerManager {
	/**만두의  생명*/
	static int life = 1;  //life는 0이면 gameover
	/**만두 라벨*/
	public static JLabel mandu;
	/**만두 움직이는 속도*/ 
	public static int speed = 5;  //픽셀 15
	/**캐릭터 선택, 기본 설정은 1*/
	public static int choice = 1;
	/**image, image_s, image_b 이미지 아이콘*/
	public static ImageIcon image, image_s, image_b;
	/**만두 크기, 기본 50*/
	public int size=50;
	
	/**PlayerManager생성자
	 * 
	 * PlayerMove초기화
	 * 
	 *  */
	public PlayerManager() {
		life = 1;
		PlayerMove pm=new PlayerMove();
		Thread thread=new Thread(pm);
		thread.setPriority(10);
		thread.start();
	}
	/**캐릭터 선택 설정
	 * 
	 * @param r 캐릭터 선택 경우
	 * */
	public void setCharacter(int r){
		if(r==1)
			new Char1();
		if(r==2)
			new Char2();
		if(r==3)
			new Char3();
	}
	/**캐릭터의 생명 얻기
	 *
	 *	 @return life의 값
	 */
	public int getLife(){
		return life;
	}
	/**캐릭터의 생명 하나 올림*/
	public void upLife() {
		life+=1;
	}
	/**캐릭터의 생명 하나 내림*/
	public void downLife() {
		life-=1;
	}
	/**캐릭터의 스피드 느리게 설정*/
	public void setSpeed(){
		speed = 1;
	}
	/**캐릭터의 스피드 얻기*/
	public int getSpeed(){
		return speed;
	}
	/**캐릭터의 이미지 설정*/
	public void setImage(){
		mandu.setIcon(image);
		mandu.setSize(50,50);
	}
	/** 소형화 이미지 설정 */
	public void setSmallImage() {
		mandu.setIcon(image_s);
		mandu.setSize(40,40);
	}
	/** 거대화 이미지 설정 */
	public void setBigImage() {
		mandu.setIcon(image_b);
		mandu.setSize(70,70);
	}
	/**만두 얻기
	 * 
	 * @return mandu Instance
	 */
	public JLabel getMandu(){
		return mandu;
	}
	
}
//Char1, Char2, Char3중에 선택한거 new Char n()로 부름
/**Character1 설정하는 클래스 */
class Char1 extends PlayerManager{
	//character마다 image다르게 줘서 jlabel생성. 기능은 똑같이. 
	/**이미지 URL*/
	URL imageURL;
	/**Character1 설정하는 생성자 */
	Char1() {
		image = new ImageIcon(imageURL=getClass().getClassLoader().getResource("수염만두.png"));
		mandu = new JLabel(image);
		mandu.setSize(size,size);
		mandu.setLocation(450,400);
		image_s = new ImageIcon(imageURL=getClass().getClassLoader().getResource("수염만두small.png"));
		image_b = new ImageIcon(imageURL=getClass().getClassLoader().getResource("수염만두big.png"));
		
	}
	
}
/**Character2설정하는 클래스*/
class Char2 extends PlayerManager{
	/**이미지 URL*/
	URL imageURL;
	/**Character2설정하는 생성자*/
	Char2() {
		image = new ImageIcon(imageURL=getClass().getClassLoader().getResource("탄만두.png"));
		mandu = new JLabel(image);
		mandu.setSize(size,size);
		mandu.setLocation(450,400);
		image_s = new ImageIcon(imageURL=getClass().getClassLoader().getResource("탄만두small.png"));
		image_b = new ImageIcon(imageURL=getClass().getClassLoader().getResource("탄만두big.png"));
		
	}
	
}
/**Character3설정하는 클래스*/
class Char3 extends PlayerManager{
	/**이미지 URL*/
	URL imageURL;
	/**Character3설정하는 생성자*/
	Char3() {
		image = new ImageIcon(imageURL=getClass().getClassLoader().getResource("꽃만두.png"));
		mandu = new JLabel(image);
		mandu.setSize(size,size);
		mandu.setLocation(450,400);
		image_s = new ImageIcon(imageURL=getClass().getClassLoader().getResource("꽃만두small.png"));
		image_b = new ImageIcon(imageURL=getClass().getClassLoader().getResource("꽃만두big.png"));
		
	}
	
}

