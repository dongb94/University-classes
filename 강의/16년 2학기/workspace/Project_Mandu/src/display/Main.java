package display;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

import javax.swing.*;
import sound.SoundManager;
/** 메인 클래스이고 게임의 첫화면
 * 
 * @author 나희지
 * @see DisplayManager
 */
public class Main extends DisplayManager{
	static int MENU_HEIGHT = 300;
	static int BUTTON_HEIGHT = 100; //메인 프레임 생성
	/**메인화면 구현되있는  기본 생성자**/
	public Main(){
		/**이미지 URL*/
		Container contentpane;
		contentpane =getContentPane();//컨텐트 팬을 알아낸다
		contentpane.setLayout(null);//레이아웃변경
		//타이틀 생성
		URL imageURL1=getClass().getClassLoader().getResource("game.png");
		ImageIcon startimage=new ImageIcon(imageURL1);//이미지 로딩
		JButton start=new JButton("start",startimage);
		MyMouseListener listener_start = new MyMouseListener();
		start.addMouseListener(listener_start);
		contentpane.add(start);
		
		URL imageURL2=getClass().getClassLoader().getResource("how.png");
		ImageIcon howToimage=new ImageIcon(imageURL2);//이미지 로딩
		JButton howTo=new JButton("howTo",howToimage);
		MyMouseListener listener_how = new MyMouseListener();
		howTo.addMouseListener(listener_how);
		contentpane.add(howTo);
		
		URL imageURL3=getClass().getClassLoader().getResource("option.png");
		ImageIcon optionimage=new ImageIcon(imageURL3);//이미지 로딩
		JButton option=new JButton("option",optionimage);
		MyMouseListener listener_op = new MyMouseListener();
		option.addMouseListener(listener_op);
		contentpane.add(option);
		
		URL imageURL4=getClass().getClassLoader().getResource("rank.png");
		ImageIcon rankimage=new ImageIcon(imageURL4);//이미지 로딩
		JButton ranking=new JButton("ranking",rankimage);
		MyMouseListener listener_rank = new MyMouseListener();
		ranking.addMouseListener(listener_rank);
		contentpane.add(ranking);
		
		URL imageURL5=getClass().getClassLoader().getResource("close.png");
		ImageIcon closeimage=new ImageIcon(imageURL5);//이미지 로딩
		JButton exit=new JButton("exit",closeimage);
		MyMouseListener listener_exit = new MyMouseListener();
		exit.addMouseListener(listener_exit);
		contentpane.add(exit);

		//타이틀 메뉴 배치
		start.setBounds(600,MENU_HEIGHT,295,BUTTON_HEIGHT);
		howTo.setBounds(600,MENU_HEIGHT+BUTTON_HEIGHT,295,BUTTON_HEIGHT);
		option.setBounds(600,MENU_HEIGHT+BUTTON_HEIGHT*2,295,BUTTON_HEIGHT);
		ranking.setBounds(600,MENU_HEIGHT+BUTTON_HEIGHT*3,295,BUTTON_HEIGHT);
		exit.setBounds(600,MENU_HEIGHT+BUTTON_HEIGHT*4,295,BUTTON_HEIGHT);

		//만두아이콘
		URL imageURL;
		ImageIcon mandooimage = new ImageIcon(imageURL=getClass().getClassLoader().getResource("mandoo.png"));
		JLabel mandoo = new JLabel(mandooimage);
		mandoo.setBounds(190, 5, 300, 300);
		contentpane.add(mandoo);
		ImageIcon mandooimage1 = new ImageIcon(imageURL=getClass().getClassLoader().getResource("mandoo.png"));
		JLabel mandoo1 = new JLabel(mandooimage1);
		mandoo1.setBounds(1000, 5, 300, 300);
		contentpane.add(mandoo1);
		//타이틀 배경
		ImageIcon Background1=new ImageIcon(imageURL=getClass().getClassLoader().getResource("배경이.JPG"));//이미지 로딩
		JLabel titleBackground=new JLabel(Background1);//레이블 컴포넌트 생성
		titleBackground.setBounds(0, 0, 1500,900);//위치설정
		contentpane.add(titleBackground);
		
		new SoundManager(this,1);
		
		setVisible(true);
	}
	public static void main(String[] args) {		
		new Main();	
	}
	//프레임을 화면에 출력
	/** Main 클래스의 내부클래스로서 
	 *  프레임에 부착 된 버튼을 해당하는 창으로 보내는 클래스
	 *  @author 나희지
	 *  
	 */
	class MyMouseListener implements MouseListener, MouseMotionListener{
		public void mouseClicked(MouseEvent e){}
		public void mousePressed(MouseEvent e){}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		/** 스타트 버튼을 클릭하면 캐릭터 선택화면 창으로 뜨게 하는 메소드
		 * 
		 * @param e
		*/
		public void mouseReleased(MouseEvent e){
			JButton choose = (JButton) e.getSource();
			new SoundManager(choose,13);
			if(choose.getText()=="start"){
				dispose();
				new Character_choose();	
			}else if(choose.getText()==("howTo")){
				dispose();
				new Howto();
			}else if(choose.getText()=="option"){
				dispose();	
				new Option();
			}else if(choose.getText()=="ranking"){
				dispose();
				try {
					new Ranking();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(choose.getText()=="exit")
				new Exit();
		}
		public void mouseDragged(MouseEvent e){}
		public void mouseMoved(MouseEvent e){}
	}
}
