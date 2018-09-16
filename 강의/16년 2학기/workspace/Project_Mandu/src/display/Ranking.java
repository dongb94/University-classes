package display;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

import javax.swing.*;
import javax.swing.event.*;
import rank.Rank;
import rank.showNS_end;
import sound.SoundManager;
import display.Howto.MyMouseListener;

/**������ ������ �����ִ� Ŭ����
 * 
 * @author ������
 * @see Rank
 */
public class Ranking extends Rank{
	/**rankingâ ������ ��ü**/
	JFrame ranking = new JFrame();
	/**�̹��� URL*/
	URL imageURL;
	/**������ ������ �����ִ� �⺻������**/
	Ranking() throws IOException{
		ranking.setTitle("����");//�������� Ÿ��Ʋ
		ranking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�������� ������ ���α׷� ����
		ranking.setSize(1500,900);//������ ũ�⼳��
		Container contentpane =ranking.getContentPane();//����Ʈ ���� �˾Ƴ���
		contentpane.setLayout(null);//���̾ƿ�����

		Toolkit kit = Toolkit. getDefaultToolkit(); 
		Image img= kit.getImage(imageURL=getClass().getClassLoader().getResource("mandoo.png"));
		ranking.setIconImage(img);

		ImageIcon back = new ImageIcon(imageURL=getClass().getClassLoader().getResource("back.png"));
		JButton back1 = new JButton(back);
		MyMouseListener listener_back = new MyMouseListener();
		back1.addMouseListener(listener_back);
		back1.setBounds(70, 700, 230, 110);
		contentpane.add(back1);

		ImageIcon image = new ImageIcon(imageURL=getClass().getClassLoader().getResource("mando1.png")); // ���� �̹��� �ε�
		JLabel image1 = new JLabel(image);
		image1.setBounds(100, -150, 500, 500);
		contentpane.add(image1);

		ImageIcon image2 = new ImageIcon(imageURL=getClass().getClassLoader().getResource("mando1.png"));// ���� �̹��� �ε�
		JLabel image11 = new JLabel(image2);
		image11.setBounds(850, -150, 500, 500);
		contentpane.add(image11);

		/* 1������ 5������ ��Ÿ���ִ� text */
		JLabel N1 = new JLabel("1��");
		N1.setSize(100,50);
		N1.setLocation(500,250);
		N1.setFont(new Font("Times",Font.BOLD,48));

		JLabel S1 = new JLabel(OpenFile()[0]);
		S1.setFont(new Font("Times",Font.BOLD,40));
		S1.setSize(430,50);
		S1.setLocation(600,250);

		JLabel N2 = new JLabel("2��");
		JLabel S2 = new JLabel(OpenFile()[1]);
		S2.setFont(new Font("Times",Font.BOLD,40));
		S2.setSize(430,50);
		S2.setLocation(600,350);
		N2.setSize(100,50);
		N2.setLocation(500,350);
		N2.setFont(new Font("Times",Font.BOLD,48));

		JLabel N3 = new JLabel("3��");
		JLabel S3 = new JLabel(OpenFile()[2]);
		S3.setFont(new Font("Times",Font.BOLD,40));
		S3.setSize(430,50);
		S3.setLocation(600,450);
		N3.setSize(100,50);
		N3.setLocation(500,450);
		N3.setFont(new Font("Times",Font.BOLD,48));

		JLabel N4 = new JLabel("4��");
		JLabel S4 = new JLabel(OpenFile()[3]);
		S4.setFont(new Font("Times",Font.BOLD,40));
		S4.setSize(430,50);
		S4.setLocation(600,550);
		N4.setSize(100,50);
		N4.setLocation(500,550);
		N4.setFont(new Font("Courier",Font.BOLD,48));

		JLabel N5 = new JLabel("5��");
		JLabel S5 = new JLabel(OpenFile()[4]);
		S5.setFont(new Font("Times",Font.BOLD,40));
		S5.setSize(430,50);
		S5.setLocation(600,650);	
		N5.setSize(100,50);
		N5.setLocation(500,650);
		N5.setFont(new Font("Times",Font.BOLD,48));

		ranking.add(N1);	ranking.add(N2);	ranking.add(N3);	ranking.add(N4);	ranking.add(N5); //1-5��
		ranking.add(S1); ranking.add(S2); 
		ranking.add(S3); ranking.add(S4); ranking.add(S5); 

		ImageIcon chart = new ImageIcon(imageURL=getClass().getClassLoader().getResource("rankchart.png"));// ���� �̹��� �ε�
		JLabel chart1 = new JLabel(chart);
		chart1.setBounds(430, 200, 600, 550);
		contentpane.add(chart1);

		ImageIcon title = new ImageIcon(imageURL=getClass().getClassLoader().getResource("rank���.png"));
		JLabel title1 = new JLabel(title);
		title1.setBounds(0, 0, 1500, 900);
		contentpane.add(title1);

		ranking.setVisible(true);//�������� ȭ�鿡 ���
	}
	/**RankingŬ������ ����Ŭ�����μ� 
	 * �����ӿ� ���� �� ��ư�� �ش��ϴ� â���� ������ Ŭ����
	 * @author ������
	 * 
	 */  
	class MyMouseListener implements MouseListener, MouseMotionListener{
		public void mouseClicked(MouseEvent e){}
		public void mousePressed(MouseEvent e){}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		/**Mainȭ������ ���ư��� Back��ư�� ����� �������ش�
		 * 
		 * @param e
		 */
		public void mouseReleased(MouseEvent e){
			JButton back1 = (JButton)e.getSource();
			new SoundManager(back1,13);
			ranking.dispose();
			new Main();
		}
		public void mouseDragged(MouseEvent e){}
		public void mouseMoved(MouseEvent e){}
	}
}