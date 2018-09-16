package display;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;
import character.PlayerManager;
import sound.SoundManager;

/** ĳ���͸� �� �� �ִ� ������ â ���� Ŭ���� 
 * 
 * @author ������
 * @see DisplayManager
 */
public class Character_choose extends DisplayManager{
	/**�̹��� URL*/
	URL imageURL;
	static int MENU_HEIGHT = 300;
	static int BUTTON_HEIGHT = 480; //���� ������ ����
	static int i=-1;
	/**�ش��ϴ� ĳ���͸� ���������� ȣ���ϴ� �ʵ� **/
	PlayerManager player = new PlayerManager();
	/**���� ĳ���� �迭 **/
	JButton[] mandooclick;
	/** ĳ���͸� �� �� �ִ� ������ â ���� �⺻ ������ **/
	public Character_choose(){
		player.choice = 1;
		Container contentpane =getContentPane();//����Ʈ ���� �˾Ƴ���
		contentpane.setLayout(null);//���̾ƿ�����

		ImageIcon image = new ImageIcon(imageURL=getClass().getClassLoader().getResource("mando1.png")); // ���� �̹��� �ε�
		JLabel image1 = new JLabel(image);
		image1.setBounds(100, -100, 500, 500);
		contentpane.add(image1);

		ImageIcon image2 = new ImageIcon(imageURL=getClass().getClassLoader().getResource("mando1.png"));// ���� �̹��� �ε�
		JLabel image11 = new JLabel(image2);
		image11.setBounds(850, -100, 500, 500);
		contentpane.add(image11);

		ImageIcon title = new ImageIcon(imageURL=getClass().getClassLoader().getResource("ĳ���ͼ���.JPG")); //����
		JLabel title1 = new JLabel(title);
		title1.setBounds(530, 10, 400, 300);
		contentpane.add(title1);

		mandooclick= new JButton[3];

		ImageIcon click1 = new ImageIcon(imageURL=getClass().getClassLoader().getResource("�Ϲ�.png")); // ĳ���� 1����
		mandooclick[0] = new JButton("1",click1); 
		MyMouseListener listener_click1 = new MyMouseListener();
		mandooclick[0].addMouseListener(listener_click1);
		MyKeyListener listener_key1 = new MyKeyListener();
		mandooclick[0].addKeyListener(listener_key1);

		ImageIcon click2 = new ImageIcon(imageURL=getClass().getClassLoader().getResource("�̹�.png")); //ĳ���� 2����
		mandooclick[1] = new JButton("2",click2);
		MyMouseListener listener_click2 = new MyMouseListener();
		mandooclick[1].addMouseListener(listener_click2);
		MyKeyListener listener_key2 = new MyKeyListener();
		mandooclick[1].addKeyListener(listener_key2);

		ImageIcon click3 = new ImageIcon(imageURL=getClass().getClassLoader().getResource("���.png")); //ĳ����3����
		mandooclick[2] = new JButton("3",click3);
		MyMouseListener listener_click3 = new MyMouseListener();
		mandooclick[2].addMouseListener(listener_click3);
		MyKeyListener listener_key3 = new MyKeyListener();
		mandooclick[2].addKeyListener(listener_key3);

		ImageIcon start = new ImageIcon(imageURL=getClass().getClassLoader().getResource("start.png")); //�ǵ��ư���
		JButton start1 = new JButton("start",start);
		MyMouseListener listener_start = new MyMouseListener();
		start1.addMouseListener(listener_start);

		ImageIcon back = new ImageIcon(imageURL=getClass().getClassLoader().getResource("back.png")); //�ǵ��ư���
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

		ImageIcon Background1=new ImageIcon(imageURL=getClass().getClassLoader().getResource("ĳ�����.JPG"));//�̹��� �ε�
		JLabel titleBackground=new JLabel(Background1);//���̺� ������Ʈ ����
		titleBackground.setBounds(0, 0, 1500,900);//��ġ����
		contentpane.add(titleBackground);

		setVisible(true);//�������� ȭ�鿡 ���
	}
	/**Character_chooseŬ������ ����Ŭ�����μ� 
	 * ������ ĳ���� ��ü�� �θ��� Ŭ����
	 * @author ������
	 * 
	 */  
	class MyMouseListener implements MouseListener, MouseMotionListener{	
		public void mouseClicked(MouseEvent e){}
		public void mousePressed(MouseEvent e){}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		/** ������ ĳ���� ��ü�� ȣ���Ͽ� Game_stage�� �ش� ĳ���͸� ������ ���� �޼ҵ�
		 * 
		 * @param e
		*/
		public void mouseReleased(MouseEvent e){
			mandooclick[0].setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("�Ϲ�.png")));
			mandooclick[1].setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("�̹�.png")));
			mandooclick[2].setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("���.png")));

			JButton choose = (JButton)e.getSource();
			new SoundManager(choose,13);
			if(choose.getText()=="1"){
				choose.setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("�Ϲ���.png")));
				player.choice = 1;
			}else if(choose.getText()==("2")){
				choose.setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("�̹���.png")));
				player.choice = 2;
			}else if(choose.getText()=="3"){
				choose.setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("�����.png")));
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
	/**Character_choose���� Ŭ�����μ� ������ ĳ���� ��ü�� �θ���.
	 * 
	 * @author ������
	 * @see KeyAdapter
	 */
	class MyKeyListener extends KeyAdapter {
		/**������ ĳ���� ��ü�� ȣ���Ͽ� Game_stage�� �ش� ĳ���͸� ������ ���� �޼ҵ�
		 * 
		 * @param e
		*/
		public void keyPressed(KeyEvent e){

			JButton choose;
			int keycode = e.getKeyCode();

			if(keycode==KeyEvent.VK_RIGHT){				
				++i; if(i>2) i=0;
				choose=mandooclick[i];
				mandooclick[0].setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("�Ϲ�.png")));
				mandooclick[1].setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("�̹�.png")));
				mandooclick[2].setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("���.png")));
				if(choose==mandooclick[0]){
					choose.setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("�Ϲ���.png")));
					player.choice = 1;
				}else if(choose==mandooclick[1]){
					choose.setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("�̹���.png")));
					player.choice = 2;
				}else if(choose==mandooclick[2]){
					choose.setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("�����.png")));
					player.choice = 3;
				}
			}
			else if(keycode==KeyEvent.VK_LEFT){	
				--i; if(i<0) i=2;	
				choose=mandooclick[i];

				mandooclick[0].setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("�Ϲ�.png")));
				mandooclick[1].setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("�̹�.png")));
				mandooclick[2].setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("���.png")));
				if(choose==mandooclick[0]){
					choose.setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("�Ϲ���.png")));
					player.choice = 1;
				}else if(choose==mandooclick[1]){					
					choose.setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("�̹���.png")));
					player.choice = 2;
				}else if(choose==mandooclick[2]){
					choose.setIcon(new ImageIcon(imageURL=getClass().getClassLoader().getResource("�����.png")));
					player.choice = 3;
				}
				choose= mandooclick[i];
			}
		}
	}
}
