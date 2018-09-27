package display;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;
import sound.SoundManager;
/**�������� ��ư�� ������ ���� ���θ� ���� Ŭ����
 *
 * @author ������
 * @see JFrame
 */
public class Exit extends JFrame{
	/**�������� ��ư�� ������ ���� ���θ� ���� �⺻������**/
	Exit(){
		/**�̹��� URL*/
		URL imageURL;
		setTitle("����");//�������� Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�������� ������ ���α׷� ����
		setSize(700,300);//������ ũ�⼳��
		Container contentpane =getContentPane();//����Ʈ ���� �˾Ƴ���
		contentpane.setLayout(null);//���̾ƿ�����

		Toolkit kit = Toolkit. getDefaultToolkit(); 
		Image img= kit.getImage(imageURL=getClass().getClassLoader().getResource("mandoo.png"));
		setIconImage(img);

		ImageIcon exit=new ImageIcon(imageURL=getClass().getClassLoader().getResource("����.png"));//�̹��� �ε�
		JLabel exit1=new JLabel(exit);//���̺� ������Ʈ ����
		exit1.setBounds(0, -100, 700,300);//��ġ����
		contentpane.add(exit1);

		ImageIcon yes = new ImageIcon(imageURL=getClass().getClassLoader().getResource("yes.png")); //ĳ���� 2����
		JButton yes1 = new JButton("yes",yes);
		yes1.setBounds(90, 100, 180, 90);
		MyMouseListener listener_yes = new MyMouseListener();
		yes1.addMouseListener(listener_yes);
		contentpane.add(yes1);

		ImageIcon no = new ImageIcon(imageURL=getClass().getClassLoader().getResource("No.png")); //ĳ���� 2����
		JButton no1 = new JButton("no",no);
		no1.setBounds(400, 100, 180, 90);
		MyMouseListener listener_no = new MyMouseListener();
		no1.addMouseListener(listener_no);
		contentpane.add(no1);

		ImageIcon Background1=new ImageIcon(imageURL=getClass().getClassLoader().getResource("��ũ.png"));//�̹��� �ε�
		JLabel titleBackground=new JLabel(Background1);//���̺� ������Ʈ ����
		titleBackground.setBounds(0, 0, 700,300);//��ġ����
		contentpane.add(titleBackground);
		setVisible(true);
	}
	/**ExitŬ������ ����Ŭ�����μ� ���� ���θ� ���� Ŭ����
	 * 
	 * @author ������ 
	 * 
	 */
	class MyMouseListener implements MouseListener, MouseMotionListener{
		public void mouseClicked(MouseEvent e){}
		public void mousePressed(MouseEvent e){}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		/** ���Ῡ�θ� ���� ����â �Ǵ� â�� ����Ǵ� �޼ҵ�
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
