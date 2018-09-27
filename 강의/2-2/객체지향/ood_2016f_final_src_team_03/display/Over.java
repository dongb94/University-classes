package display;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import rank.Rank;
import rank.showNS_end;


/** 만두가 죽은 후 나타나는 창을 위한 클래스
 * @author 하수연
 * @see Rank
 **/
public class Over extends Rank{

	/** 게임점수 score */
	private int score;
	/** Over의 JFrame */
	private JFrame Over = new JFrame();
	/** 점수 저장 여부 JLabel */
	private JLabel Q = new JLabel("점수를 저장하시겠습니까?");
	/** YES버튼의 이미지 */
	private ImageIcon yes = new ImageIcon(imageURL=getClass().getClassLoader().getResource("yes.png"));
	/** Button"YES" */
	private JButton BY = new JButton("YES",yes);
	/** NO버튼의 이미지 */
	private ImageIcon no = new ImageIcon(imageURL=getClass().getClassLoader().getResource("No.png"));
	/** Button"NO" */
	private JButton BN = new JButton("NO",no);
	/** Button"OK" */
	static JButton OK = new JButton("OK");
	/** Nickname창의 JFrame */
	private JFrame nick = new JFrame("NICKNAME");
	/**이미지 URL*/
	URL imageURL;

	/** 
	 * 게임 오버시 보여지는 창구현하는 생성자
	 * @param score
	 * */

	Over(int score){
		this.score=score;
		/* 프레임 구현 */
		int width=1500; //너비
		int height = 900; //높이
		Color c1 = new Color(255,187,194); // 컬러 세팅
		Over.setTitle("만두");// 프레임 이름 "Game Over"
		Over.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x누르면 닫힘
		Over.setLayout(null);
		Over.setSize(width,height);//창 사이즈  1500*900으로  만들기

		/* YES 버튼 */
		BY.setSize(200,100);
		BY.setLocation(480,520);
		BY.setBackground(c1);

		/* NO 버튼 */
		BN.setSize(200,100);
		BN.setLocation(780,520);
		BN.setBackground(c1);

		myMouseListener yes = new myMouseListener();
		BY.addMouseListener(yes);
		myMouseListener no = new myMouseListener();
		BN.addMouseListener(no);

		/* 배경 image 라벨  */
		ImageIcon background = new ImageIcon(imageURL=getClass().getClassLoader().getResource("dd2.jpg"));
		JLabel back = new JLabel(background);
		back.setBounds( 0, 0, width, height);

		/* GAME OVER 라벨 */
		JLabel go = new JLabel("GAME OVER");
		go.setSize(500,70);
		go.setFont(new Font("Times",Font.BOLD,80));
		go.setLocation(505,65);

		/* 점수 문자열로 바꾸어 라벨로 나타냄 */
		String N = Integer.toString(score);//점수 문자열로 바꾸기
		JLabel sn = new JLabel(N);//바꾼 문자열 라벨로 만들기
		sn.setSize(250,80);
		sn.setLocation(630,290);
		sn.setFont(new Font("Times",Font.BOLD,100));

		/* 점수 물어보는 라벨  */
		Q.setSize(800,70);
		Q.setLocation(410,410);
		Q.setFont(new Font("Times",Font.BOLD,55));

		Over.add(BY); Over.add(BN); //버튼 더하기
		Over.add(go); Over.add(Q); Over.add(sn); //라벨 더하기
		Over.add(back);	//배경더하기
		Toolkit kit = Toolkit. getDefaultToolkit(); 
		Image img= kit.getImage(imageURL=getClass().getClassLoader().getResource("mandoo.png"));
		Over.setIconImage(img);
		Over.setVisible(true); // 프레임 보여주기
		
	}

	/** 
	 * 닉네임 입력하는 창 메소드
	 * */
	public void enterNickname(){

		JFrame nick = new JFrame("만두");
		nick.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x누르면 닫힘
		nick.setLayout(null);
		nick.setResizable(false);
		nick.setSize(480,160);
		nick.setLocation(520,450);
		
		Toolkit kit = Toolkit. getDefaultToolkit(); 
		Image img= kit.getImage(imageURL=getClass().getClassLoader().getResource("mandoo.png"));
		nick.setIconImage(img);

		JLabel enter = new JLabel("NICKNAME :");
		enter.setSize(200,50);
		enter.setFont(new Font("Times",Font.BOLD,23));
		enter.setLocation(10,10);

		JTextField field = new JTextField("( 5자이내로 ) ");
		field.setSize(300,50);
		field.setLocation(160,10);
		field.setFont(new Font("Times",Font.BOLD,18));

		OK.setSize(200,35);
		OK.setLocation(260,80);
		OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = field.getText();
				nick.dispose();
				Input(score,s);
				new showNS_end(Over);	
			}
		});
		nick.add(enter); nick.add(field);
		nick.add(OK);
		nick.setVisible(true);	
	}
	/** Returns void
	 * @return void
	 * */

	/** YES버튼과 NO버튼 구별을 위한 MouseListener를 implements한 클래스
	 * @author 하수연
	 */
	class myMouseListener implements MouseListener{

		/** 
		 * @param e
		 */
		public void actionPerformed(ActionEvent e) {}
		/** Returns void
		 * @return void
		 * */

		/**
		 * 마우스 클릭한 버튼에 따라 나오는 창이 다르게 하는 메소드
		 * @param e 
		 */
		public void mouseClicked(MouseEvent e) {
			JButton button = (JButton)e.getSource();
			if(button.getText().equals("YES")) {
				Q.setVisible(false);				
				BY.setVisible(false);
				BN.setVisible(false);
				enterNickname();
			}
			else if(button.getText().equals("NO")){
				new showNS_end(Over);	
			}
		}
		/** Returns void
		 * @return void
		 * */

		/**
		 * @param e 
		 */
		public void mouseEntered(MouseEvent e) {}
		/** Returns void
		 * @return void
		 * */

		/** 
		 * @param e 
		 */
		public void mouseExited(MouseEvent e) {}
		/** Returns void
		 * @return void
		 * */

		/** 
		 * @param e 
		 */
		public void mousePressed(MouseEvent e) {}
		/** Returns void
		 * @return void
		 * */

		/** 
		 * @param e 
		 */
		public void mouseReleased(MouseEvent e) {}
		/** Returns void
		 * @return void
		 * */
	}
}
