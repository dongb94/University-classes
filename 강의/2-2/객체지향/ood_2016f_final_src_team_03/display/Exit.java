package display;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;
import sound.SoundManager;
/**게임종료 버튼을 누르면 종료 여부를 묻는 클래스
 *
 * @author 나희지
 * @see JFrame
 */
public class Exit extends JFrame{
	/**게임종료 버튼을 누르면 종료 여부를 묻는 기본생성자**/
	Exit(){
		/**이미지 URL*/
		URL imageURL;
		setTitle("만두");//프레임의 타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임을 닫으면 프로그램 종료
		setSize(700,300);//프레임 크기설정
		Container contentpane =getContentPane();//컨텐트 팬을 알아낸다
		contentpane.setLayout(null);//레이아웃변경

		Toolkit kit = Toolkit. getDefaultToolkit(); 
		Image img= kit.getImage(imageURL=getClass().getClassLoader().getResource("mandoo.png"));
		setIconImage(img);

		ImageIcon exit=new ImageIcon(imageURL=getClass().getClassLoader().getResource("종료.png"));//이미지 로딩
		JLabel exit1=new JLabel(exit);//레이블 컴포넌트 생성
		exit1.setBounds(0, -100, 700,300);//위치설정
		contentpane.add(exit1);

		ImageIcon yes = new ImageIcon(imageURL=getClass().getClassLoader().getResource("yes.png")); //캐릭터 2선택
		JButton yes1 = new JButton("yes",yes);
		yes1.setBounds(90, 100, 180, 90);
		MyMouseListener listener_yes = new MyMouseListener();
		yes1.addMouseListener(listener_yes);
		contentpane.add(yes1);

		ImageIcon no = new ImageIcon(imageURL=getClass().getClassLoader().getResource("No.png")); //캐릭터 2선택
		JButton no1 = new JButton("no",no);
		no1.setBounds(400, 100, 180, 90);
		MyMouseListener listener_no = new MyMouseListener();
		no1.addMouseListener(listener_no);
		contentpane.add(no1);

		ImageIcon Background1=new ImageIcon(imageURL=getClass().getClassLoader().getResource("핑크.png"));//이미지 로딩
		JLabel titleBackground=new JLabel(Background1);//레이블 컴포넌트 생성
		titleBackground.setBounds(0, 0, 700,300);//위치설정
		contentpane.add(titleBackground);
		setVisible(true);
	}
	/**Exit클래스의 내부클래스로서 종료 여부를 묻는 클래스
	 * 
	 * @author 나희지 
	 * 
	 */
	class MyMouseListener implements MouseListener, MouseMotionListener{
		public void mouseClicked(MouseEvent e){}
		public void mousePressed(MouseEvent e){}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		/** 종료여부를 물어 메인창 또는 창이 종료되는 메소드
		 * 
		 * @param e
		*/
		public void mouseReleased(MouseEvent e){
			JButton choose = (JButton) e.getSource();
			new SoundManager(choose,13);
			if(choose.getText()=="yes"){
				System.exit(0);
			}else if(choose.getText()==("no")){
				setVisible(false);
			}
		}
		public void mouseDragged(MouseEvent e){}
		public void mouseMoved(MouseEvent e){}
	}
}
