package display;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;

/** Display패키지 내 클래스를 상속하는 상위 클래스
 * Ranking, Exit 클래스 제외
 * @author 나희지
 * @see JFrame
 */
public class DisplayManager extends JFrame{
	static int MENU_HEIGHT = 300;
	static int BUTTON_HEIGHT = 100; //메인 프레임 생성
/**상위클래스의 기본생성자**/
	DisplayManager(){
		/**이미지 URL*/
		URL imageURL;
		setTitle("만두");//프레임의 타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임을 닫으면 프로그램 종료
		setSize(1500,900);//프레임 크기설정
		Toolkit kit = Toolkit. getDefaultToolkit(); 
		Image img= kit.getImage(imageURL=getClass().getClassLoader().getResource("mandoo.png"));
		setIconImage(img);
	}
}
