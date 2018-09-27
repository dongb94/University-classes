package display;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;
import sound.SoundManager;

/**���� ����� �������ִ� â Ŭ����
 * 
 * @author ������ 
 * @see DisplayManager
 */
public class Howto extends DisplayManager{
	static int MENU_HEIGHT = 300;
	static int BUTTON_HEIGHT = 100; //���� ������ ����
/**���� ����� �������ִ� â �⺻������**/
	Howto(){
		/**�̹��� URL*/
		URL imageURL;
		Container contentpane=null;
		contentpane =getContentPane();//����Ʈ ���� �˾Ƴ���
		contentpane.setLayout(null);//���̾ƿ�����
		
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

		ImageIcon title2 = new ImageIcon(imageURL=getClass().getClassLoader().getResource("��ũ��.png"));
		JLabel title3 = new JLabel(title2);
		title3.setBounds(0, 0, 1500, 900);
		contentpane.add(title3);

		ImageIcon title4 = new ImageIcon(imageURL=getClass().getClassLoader().getResource("Gamerule.png"));
		JLabel title5 = new JLabel(title4);
		title5.setBounds(260, 50, 900, 100);
		contentpane.add(title5);

		ImageIcon title = new ImageIcon(imageURL=getClass().getClassLoader().getResource("��ũ.png"));
		JLabel title1 = new JLabel(title);
		title1.setBounds(0, 0, 1500, 900);
		contentpane.add(title1);

		setVisible(true);//�������� ȭ�鿡 ���
	}
	/**HowtoŬ������ ����Ŭ�����μ� 
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
			setVisible(false);
			new Main();
		}
		public void mouseDragged(MouseEvent e){}
		public void mouseMoved(MouseEvent e){}
	}
}