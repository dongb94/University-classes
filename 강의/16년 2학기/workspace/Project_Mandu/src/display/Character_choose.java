package display;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;
import character.PlayerManager;
import sound.SoundManager;

/** 캐릭터를 고를 수 있는 프레임 창 구현 클래스 
 * 
 * @author 나희지
 * @see DisplayManager
 */
public class Character_choose extends DisplayManager{
	/**이미지 URL*/
	URL imageURL;
	static int MENU_HEIGHT = 300;
	static int BUTTON_HEIGHT = 480; //메인 프레임 생성
	static int i=-1;
	/**해당하는 캐릭터를 스테이지에 호출하는 필드 **/
	PlayerManager player = new PlayerManager();
	/**만두 캐릭터 배열 **/
	JButton[] mandooclick;
	/** 캐릭터를 고를 수 있는 프레임 창 구현 기본 생성자 **/
	public Character_choose(){
		player.choice = 1;
		Container contentpane =getContentPane();//컨텐트 팬을 알아낸다
		contentpane.setLayout(null);//레이아웃변경

		ImageIcon image = new ImageIcon(imageURL=getClass().getClassLoader().getResource("mando1.png")); // 만두 이미지 로딩
		JLabel image1 = new JLabel(image);
		image1.setBounds(100, -100, 500, 500);
		contentpane.add(image1);

		ImageIcon image2 = new ImageIcon(imageURL=getClass().getClassLoader().getResource("mando1.png"));// 만두 이미지 로딩
		JLabel image11 = new JLabel(image2);
		image11.setBounds(850, -100, 500, 500);
		contentpane.add(image11);

		ImageIcon title = new ImageIcon(imageURL=getClass().getClassLoader().getResource("캐릭터선택.JPG")); //제목
		JLabel title1 = new JLabel(title);
		title1.setBounds(530, 10, 400, 300);
		contentpane.add(title1);

		mandooclick= new JButton[3];

		ImageIcon click1 = new ImageIcon(imageURL=getClass().getClassLoader().getResource("일번.png")); // 캐릭터 1선택
		mandooclick[0] = new JButton("1",click1); 
		MyMouseListener listener_click1 = new MyMouseListener();
		mandooclick[0].addMouseListener(listener_click1);
		MyKeyListener listener_key1 = new MyKeyListener();
		mandooclick[0].addKeyListener(listener_key1);

		ImageIcon click2 = new ImageIcon(imageURL=getClass().getClassLoader().getResource("이번.png")); //캐릭터 2선택
		mandooclick[1] = new JButton("2",click2);
		MyMouseListener listener_click2 = new MyMouseListener();
		mandooclick[1].addMouseListener(listener_click2);
		MyKeyListener listener_key2 = new MyKeyListener();
		mandooclick[1].addKeyListener(listener_key2);

		ImageIcon click3 = new ImageIcon(imageURL=getClass().getClassLoader().getResource("삼번.png")); //캐릭터3선택
		mandooclick[2] = new JButton("3",click3);
		MyMouseListener listener_click3 = new MyMouseListener();
		mandooclick[2].addMouseListener(listener_click3);
		MyKeyListener listener_key3 = new MyKeyListener();
		mandooclick[2].addKeyListener(listener_key3);

		ImageIcon start = new ImageIcon(imageURL=getClass().getClassLoader().getResource("start.png")); //되돌아가기
		JButton start1 = new JButton("start",start);
		MyMouseListener listener_start = new MyMouseListener();
		start1.addMouseListener(listener_start);

		ImageIcon back = new ImageIcon(imageURL=getClass().getClassLoader().getResource("back.png")); //되돌아가기
		JButton back1 = new JButton("back",back);
		MyMouseListener listener_back = new MyMouseListener();
		back1.addMouseListener(listener_back);

		mandooclick[0].setBounds(250, 300, MENU_HEIGHT, BUTTON_HEIGHT);
		contentpane.add(mandooclick[0]);
		mandooclick[1].setBounds(570, 300, MENU_HEIGHT, BUTTON_HEIGHT);
		contentpane.add(mandooclick[1]);
		mandooclick[2].setBounds(890, 300, MENU_HEIGHT, BUTTON_HEIGHT);
		contentpane.add(mandooclick[2]);
		back1.setBounds(20, 650, 230, 110);
		contentpane.add(back1);
		start1.setBounds(1200, 650, 230, 110);
		contentpane.add(start1);

		ImageIcon Background1=new ImageIcon(imageURL=getClass().getClassLoader().getResource("캐릭배경.JPG"));//이미지 로딩
		JLabel titleBackground=new JLabel(Background1);//레이블 컴포넌트 생성
		titleBackground.setBounds(0, 0, 1500,900);//위치설정
		contentpane.add(titleBackground);

		setVisible(true);//프레임을 화면에 출력
	}
	/**Character_choose클래스의 내부클래스로서 
	 * 선택한 캐릭터 객체를 부르는 클래스
	 * @author 나희지
	 * 
	 */  
	class MyMouseListener implements MouseListener, MouseMotionListener{	
		public void mouseClicked(MouseEvent e){}
		public void mousePressed(MouseEvent e){}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		/** 선택한 캐릭터 객체를 호출하여 Game_stage에 해당 캐릭터를 가져다 놓는 메소드
		 * 
		 * @param e
		*/
		public void mouseReleased(MouseEvent e){
			mandooclick[0].setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("일번.png")));
			mandooclick[1].setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("이번.png")));
			mandooclick[2].setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("삼번.png")));

			JButton choose = (JButton)e.getSource();
			new SoundManager(choose,13);
			if(choose.getText()=="1"){
				choose.setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("일번젓.png")));
				player.choice = 1;
			}else if(choose.getText()==("2")){
				choose.setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("이번젓.png")));
				player.choice = 2;
			}else if(choose.getText()=="3"){
				choose.setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("삼번젓.png")));
				player.choice = 3;
			}else if(choose.getText()=="back"){
				dispose();  
				new Main();
			}else if(choose.getText()=="start"){
				dispose();  
				new Game_stage();
			}
			++i;
			if(i>2)i=0;
		}
		public void mouseDragged(MouseEvent e){}
		public void mouseMoved(MouseEvent e){}
	}
	/**Character_choose내부 클래스로서 선택한 캐릭터 객체를 부른다.
	 * 
	 * @author 나희지
	 * @see KeyAdapter
	 */
	class MyKeyListener extends KeyAdapter {
		/**선택한 캐릭터 객체를 호출하여 Game_stage에 해당 캐릭터를 가져다 놓는 메소드
		 * 
		 * @param e
		*/
		public void keyPressed(KeyEvent e){

			JButton choose;
			int keycode = e.getKeyCode();

			if(keycode==KeyEvent.VK_RIGHT){				
				++i; if(i>2) i=0;
				choose=mandooclick[i];
				mandooclick[0].setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("일번.png")));
				mandooclick[1].setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("이번.png")));
				mandooclick[2].setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("삼번.png")));
				if(choose==mandooclick[0]){
					choose.setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("일번젓.png")));
					player.choice = 1;
				}else if(choose==mandooclick[1]){
					choose.setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("이번젓.png")));
					player.choice = 2;
				}else if(choose==mandooclick[2]){
					choose.setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("삼번젓.png")));
					player.choice = 3;
				}
			}
			else if(keycode==KeyEvent.VK_LEFT){	
				--i; if(i<0) i=2;	
				choose=mandooclick[i];

				mandooclick[0].setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("일번.png")));
				mandooclick[1].setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("이번.png")));
				mandooclick[2].setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("삼번.png")));
				if(choose==mandooclick[0]){
					choose.setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("일번젓.png")));
					player.choice = 1;
				}else if(choose==mandooclick[1]){					
					choose.setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("이번젓.png")));
					player.choice = 2;
				}else if(choose==mandooclick[2]){
					choose.setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("삼번젓.png")));
					player.choice = 3;
				}
				choose= mandooclick[i];
			}
		}
	}
}
