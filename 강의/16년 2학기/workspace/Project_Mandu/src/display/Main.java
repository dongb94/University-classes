package display;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

import javax.swing.*;
import sound.SoundManager;
/** ���� Ŭ�����̰� ������ ùȭ��
 * 
 * @author ������
 * @see DisplayManager
 */
public class Main extends DisplayManager{
	static int MENU_HEIGHT = 300;
	static int BUTTON_HEIGHT = 100; //���� ������ ����
	/**����ȭ�� �������ִ�  �⺻ ������**/
	public Main(){
		/**�̹��� URL*/
		Container contentpane;
		contentpane =getContentPane();//����Ʈ ���� �˾Ƴ���
		contentpane.setLayout(null);//���̾ƿ�����
		//Ÿ��Ʋ ����
		URL imageURL1=getClass().getClassLoader().getResource("game.png");
		ImageIcon startimage=new ImageIcon(imageURL1);//�̹��� �ε�
		JButton start=new JButton("start",startimage);
		MyMouseListener listener_start = new MyMouseListener();
		start.addMouseListener(listener_start);
		contentpane.add(start);
		
		URL imageURL2=getClass().getClassLoader().getResource("how.png");
		ImageIcon howToimage=new ImageIcon(imageURL2);//�̹��� �ε�
		JButton howTo=new JButton("howTo",howToimage);
		MyMouseListener listener_how = new MyMouseListener();
		howTo.addMouseListener(listener_how);
		contentpane.add(howTo);
		
		URL imageURL3=getClass().getClassLoader().getResource("option.png");
		ImageIcon optionimage=new ImageIcon(imageURL3);//�̹��� �ε�
		JButton option=new JButton("option",optionimage);
		MyMouseListener listener_op = new MyMouseListener();
		option.addMouseListener(listener_op);
		contentpane.add(option);
		
		URL imageURL4=getClass().getClassLoader().getResource("rank.png");
		ImageIcon rankimage=new ImageIcon(imageURL4);//�̹��� �ε�
		JButton ranking=new JButton("ranking",rankimage);
		MyMouseListener listener_rank = new MyMouseListener();
		ranking.addMouseListener(listener_rank);
		contentpane.add(ranking);
		
		URL imageURL5=getClass().getClassLoader().getResource("close.png");
		ImageIcon closeimage=new ImageIcon(imageURL5);//�̹��� �ε�
		JButton exit=new JButton("exit",closeimage);
		MyMouseListener listener_exit = new MyMouseListener();
		exit.addMouseListener(listener_exit);
		contentpane.add(exit);

		//Ÿ��Ʋ �޴� ��ġ
		start.setBounds(600,MENU_HEIGHT,295,BUTTON_HEIGHT);
		howTo.setBounds(600,MENU_HEIGHT+BUTTON_HEIGHT,295,BUTTON_HEIGHT);
		option.setBounds(600,MENU_HEIGHT+BUTTON_HEIGHT*2,295,BUTTON_HEIGHT);
		ranking.setBounds(600,MENU_HEIGHT+BUTTON_HEIGHT*3,295,BUTTON_HEIGHT);
		exit.setBounds(600,MENU_HEIGHT+BUTTON_HEIGHT*4,295,BUTTON_HEIGHT);

		//���ξ�����
		URL imageURL;
		ImageIcon mandooimage = new ImageIcon(imageURL=getClass().getClassLoader().getResource("mandoo.png"));
		JLabel mandoo = new JLabel(mandooimage);
		mandoo.setBounds(190, 5, 300, 300);
		contentpane.add(mandoo);
		ImageIcon mandooimage1 = new ImageIcon(imageURL=getClass().getClassLoader().getResource("mandoo.png"));
		JLabel mandoo1 = new JLabel(mandooimage1);
		mandoo1.setBounds(1000, 5, 300, 300);
		contentpane.add(mandoo1);
		//Ÿ��Ʋ ���
		ImageIcon Background1=new ImageIcon(imageURL=getClass().getClassLoader().getResource("�����.JPG"));//�̹��� �ε�
		JLabel titleBackground=new JLabel(Background1);//���̺� ������Ʈ ����
		titleBackground.setBounds(0, 0, 1500,900);//��ġ����
		contentpane.add(titleBackground);
		
		new SoundManager(this,1);
		
		setVisible(true);
	}
	public static void main(String[] args) {		
		new Main();	
	}
	//�������� ȭ�鿡 ���
	/** Main Ŭ������ ����Ŭ�����μ� 
	 *  �����ӿ� ���� �� ��ư�� �ش��ϴ� â���� ������ Ŭ����
	 *  @author ������
	 *  
	 */
	class MyMouseListener implements MouseListener, MouseMotionListener{
		public void mouseClicked(MouseEvent e){}
		public void mousePressed(MouseEvent e){}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		/** ��ŸƮ ��ư�� Ŭ���ϸ� ĳ���� ����ȭ�� â���� �߰� �ϴ� �޼ҵ�
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
