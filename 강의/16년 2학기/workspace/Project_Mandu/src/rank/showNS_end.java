package rank;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import display.Character_choose;
import display.Main;
import rank.Rank;

/** 랭크차트 보여주는 클래스
 * @author 하수연
 * @see Rank
 */
public class showNS_end extends Rank{
	/**이미지 URL*/
	private URL imageURL;
	/** RankchartFrame */
	JFrame Rankchart = new JFrame();
	/**게임종료화면*/
	private JFrame Over;
	/**
	 * 랭킹 창을 보여주는 생성자
	 * Over창을 끄기 위해 객체를 가져온다
	 * @param over JFrame */
	public showNS_end(JFrame over){
		Over=over;
		try {
			/* 프레임 구현  */
			Rankchart.setTitle("만두");// 창이름
			Rankchart.setSize(310,410); // 창 크기
			Rankchart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x누르면 닫힘
			Rankchart.setLayout(null);
			Rankchart.setLocation(600,250);
			Rankchart.setResizable(false); // 창 크기 고정

			Toolkit kit = Toolkit. getDefaultToolkit(); 
			Image img= kit.getImage(imageURL=getClass().getClassLoader().getResource("mandoo.png"));
			Rankchart.setIconImage(img);
			
			/* 랭킹 차트 JLabel */

			JLabel textlabel = new JLabel("Rank Chart");
			textlabel.setLocation(90,0);
			textlabel.setSize(300,50);
			textlabel.setFont(new Font("Times",Font.BOLD,20));
			JLabel textback = new JLabel("");
			textback.setLocation(0,0);
			textback.setSize(300,48);
			textback.setOpaque(true);
			textback.setBackground(Color.pink);

			/* 1위부터 5위까지 나타내주는 text */
			JLabel N1 = new JLabel("1위");
			N1.setSize(40,30);
			N1.setLocation(35,70);
			N1.setFont(new Font("Times",Font.BOLD,23));

			JLabel S1 = new JLabel(OpenFile()[0]);
			S1.setFont(new Font("Times",Font.BOLD,21));
			S1.setSize(200,30);
			S1.setLocation(90,70);

			JLabel N2 = new JLabel("2위");
			JLabel S2 = new JLabel(OpenFile()[1]);
			S2.setFont(new Font("Times",Font.BOLD,21));
			S2.setSize(200,30);
			S2.setLocation(90,115);
			N2.setSize(40,30);
			N2.setLocation(35,115);
			N2.setFont(new Font("Times",Font.BOLD,23));

			JLabel N3 = new JLabel("3위");
			JLabel S3 = new JLabel(OpenFile()[2]);
			S3.setFont(new Font("Times",Font.BOLD,21));
			S3.setSize(200,30);
			S3.setLocation(90,160);
			N3.setSize(40,30);
			N3.setLocation(35,160);
			N3.setFont(new Font("Times",Font.BOLD,23));

			JLabel N4 = new JLabel("4위");
			JLabel S4 = new JLabel(OpenFile()[3]);
			S4.setFont(new Font("Times",Font.BOLD,21));
			S4.setSize(200,30);
			S4.setLocation(90,205);
			N4.setSize(40,30);
			N4.setLocation(35,205);
			N4.setFont(new Font("Courier",Font.BOLD,23));

			JLabel N5 = new JLabel("5위");
			JLabel S5 = new JLabel(OpenFile()[4]);
			S5.setFont(new Font("Times",Font.BOLD,21));
			S5.setSize(200,30);
			S5.setLocation(90,250);		
			N5.setSize(40,30);
			N5.setLocation(35,250);
			N5.setFont(new Font("Times",Font.BOLD,23));

			JButton B_main = new JButton("MAIN"); JButton B_Regame = new JButton("REGAME");// 버튼생성
			MyMouseListener mainListener = new MyMouseListener();
			B_main.addMouseListener(mainListener);
			MyMouseListener regameListener = new MyMouseListener();
			B_Regame.addMouseListener(regameListener);
			B_main.setSize(130,50);
			B_main.setLocation(10,310);
			B_Regame.setSize(130,50);
			B_Regame.setLocation(150,310);

			Rankchart.add(B_main); Rankchart.add(B_Regame); //메인화면으로 돌아가는 버튼과 다시게임시작하는 버튼
			Rankchart.add(textlabel); Rankchart.add(textback); //Ranking Chart
			Rankchart.add(N1);	Rankchart.add(N2);	Rankchart.add(N3);	Rankchart.add(N4);	Rankchart.add(N5); //1-5위
			Rankchart.add(S1); Rankchart.add(S2); Rankchart.add(S3); Rankchart.add(S4); Rankchart.add(S5); // 닉네임과 점수
			Rankchart.setVisible(true); // 프레임 보여줌 
		} catch (IOException e) {
			System.out.println("ErrorshowNS_end---"+e.toString());
		}
	}
	

	/** MAIN버튼과 REGAME버튼 동작을 위한 MouseListener implements한 클래스 
	 * @author 하수연
	 */
	class MyMouseListener implements MouseListener{

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
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("MAIN")) {
				Over.dispose();
				Rankchart.dispose();
				new Main();
			}
			else if(b.getText().equals("REGAME")){
				Over.dispose();
				Rankchart.dispose();
				new Character_choose();
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
