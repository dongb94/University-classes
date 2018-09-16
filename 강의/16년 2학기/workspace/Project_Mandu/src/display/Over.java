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


/** ���ΰ� ���� �� ��Ÿ���� â�� ���� Ŭ����
 * @author �ϼ���
 * @see Rank
 **/
public class Over extends Rank{

	/** �������� score */
	private int score;
	/** Over�� JFrame */
	private JFrame Over = new JFrame();
	/** ���� ���� ���� JLabel */
	private JLabel Q = new JLabel("������ �����Ͻðڽ��ϱ�?");
	/** YES��ư�� �̹��� */
	private ImageIcon yes = new ImageIcon(imageURL=getClass().getClassLoader().getResource("yes.png"));
	/** Button"YES" */
	private JButton BY = new JButton("YES",yes);
	/** NO��ư�� �̹��� */
	private ImageIcon no = new ImageIcon(imageURL=getClass().getClassLoader().getResource("No.png"));
	/** Button"NO" */
	private JButton BN = new JButton("NO",no);
	/** Button"OK" */
	static JButton OK = new JButton("OK");
	/** Nicknameâ�� JFrame */
	private JFrame nick = new JFrame("NICKNAME");
	/**�̹��� URL*/
	URL imageURL;

	/** 
	 * ���� ������ �������� â�����ϴ� ������
	 * @param score
	 * */

	Over(int score){
		this.score=score;
		/* ������ ���� */
		int width=1500; //�ʺ�
		int height = 900; //����
		Color c1 = new Color(255,187,194); // �÷� ����
		Over.setTitle("����");// ������ �̸� "Game Over"
		Over.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x������ ����
		Over.setLayout(null);
		Over.setSize(width,height);//â ������  1500*900����  �����

		/* YES ��ư */
		BY.setSize(200,100);
		BY.setLocation(480,520);
		BY.setBackground(c1);

		/* NO ��ư */
		BN.setSize(200,100);
		BN.setLocation(780,520);
		BN.setBackground(c1);

		myMouseListener yes = new myMouseListener();
		BY.addMouseListener(yes);
		myMouseListener no = new myMouseListener();
		BN.addMouseListener(no);

		/* ��� image ��  */
		ImageIcon background = new ImageIcon(imageURL=getClass().getClassLoader().getResource("dd2.jpg"));
		JLabel back = new JLabel(background);
		back.setBounds( 0, 0, width, height);

		/* GAME OVER �� */
		JLabel go = new JLabel("GAME OVER");
		go.setSize(500,70);
		go.setFont(new Font("Times",Font.BOLD,80));
		go.setLocation(505,65);

		/* ���� ���ڿ��� �ٲپ� �󺧷� ��Ÿ�� */
		String N = Integer.toString(score);//���� ���ڿ��� �ٲٱ�
		JLabel sn = new JLabel(N);//�ٲ� ���ڿ� �󺧷� �����
		sn.setSize(250,80);
		sn.setLocation(630,290);
		sn.setFont(new Font("Times",Font.BOLD,100));

		/* ���� ����� ��  */
		Q.setSize(800,70);
		Q.setLocation(410,410);
		Q.setFont(new Font("Times",Font.BOLD,55));

		Over.add(BY); Over.add(BN); //��ư ���ϱ�
		Over.add(go); Over.add(Q); Over.add(sn); //�� ���ϱ�
		Over.add(back);	//�����ϱ�
		Toolkit kit = Toolkit. getDefaultToolkit(); 
		Image img= kit.getImage(imageURL=getClass().getClassLoader().getResource("mandoo.png"));
		Over.setIconImage(img);
		Over.setVisible(true); // ������ �����ֱ�
		
	}

	/** 
	 * �г��� �Է��ϴ� â �޼ҵ�
	 * */
	public void enterNickname(){

		JFrame nick = new JFrame("����");
		nick.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x������ ����
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

		JTextField field = new JTextField("( 5���̳��� ) ");
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

	/** YES��ư�� NO��ư ������ ���� MouseListener�� implements�� Ŭ����
	 * @author �ϼ���
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
		 * ���콺 Ŭ���� ��ư�� ���� ������ â�� �ٸ��� �ϴ� �޼ҵ�
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
