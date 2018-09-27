package display;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;
import sound.SoundManager;

/**게임 방법을 설명해주는 창 클래스
 * 
 * @author 나희지 
 * @see DisplayManager
 */
public class Howto extends DisplayManager{
	static int MENU_HEIGHT = 300;
	static int BUTTON_HEIGHT = 100; //메인 프레임 생성
/**게임 방법을 설명해주는 창 기본생성자**/
	Howto(){
		/**이미지 URL*/
		URL imageURL;
		Container contentpane=null;
		contentpane =getContentPane();//컨텐트 팬을 알아낸다
		contentpane.setLayout(null);//레이아웃변경
		
		ImageIcon back = new ImageIcon(imageURL=getClass().getClassLoader().getResource("back.png"));
		JButton back1 = new JButton(back);
		MyMouseListener listener_back = new MyMouseListener();
		back1.addMouseListener(listener_back);
		back1.setBounds(70, 700, 230, 110);
		contentpane.add(back1);

		ImageIcon image = new ImageIcon(imageURL=getClass().getClassLoader().getResource("mando1.png")); // 만두 이미지 로딩
		JLabel image1 = new JLabel(image);
		image1.setBounds(100, -150, 500, 500);
		contentpane.add(image1);

		ImageIcon image2 = new ImageIcon(imageURL=getClass().getClassLoader().getResource("mando1.png"));// 만두 이미지 로딩
		JLabel image11 = new JLabel(image2);
		image11.setBounds(850, -150, 500, 500);
		contentpane.add(image11);

		ImageIcon title2 = new ImageIcon(imageURL=getClass().getClassLoader().getResource("스크린.png"));
		JLabel title3 = new JLabel(title2);
		title3.setBounds(0, 0, 1500, 900);
		contentpane.add(title3);

		ImageIcon title4 = new ImageIcon(imageURL=getClass().getClassLoader().getResource("Gamerule.png"));
		JLabel title5 = new JLabel(title4);
		title5.setBounds(260, 50, 900, 100);
		contentpane.add(title5);

		ImageIcon title = new ImageIcon(imageURL=getClass().getClassLoader().getResource("핑크.png"));
		JLabel title1 = new JLabel(title);
		title1.setBounds(0, 0, 1500, 900);
		contentpane.add(title1);

		setVisible(true);//프레임을 화면에 출력
	}
	/**Howto클래스의 내부클래스로서 
	 * 프레임에 부착 된 버튼을 해당하는 창으로 보내는 클래스
	 * @author 나희지
	 * 
	 */  
	class MyMouseListener implements MouseListener, MouseMotionListener{
		public void mouseClicked(MouseEvent e){}
		public void mousePressed(MouseEvent e){}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		/**Main화면으로 돌아가는 Back버튼의 기능을 구현해준다
		 * 
		 * @param e
		 */
		public void mouseReleased(MouseEvent e){
			JButton back1 = (JButton)e.getSource();
			new SoundManager(back1,13);
			setVisible(false);
			new Main();
		}
		public void mouseDragged(MouseEvent e){}
		public void mouseMoved(MouseEvent e){}
	}
}