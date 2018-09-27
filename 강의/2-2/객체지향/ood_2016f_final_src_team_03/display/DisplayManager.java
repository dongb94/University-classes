package display;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;

/** Display��Ű�� �� Ŭ������ ����ϴ� ���� Ŭ����
 * Ranking, Exit Ŭ���� ����
 * @author ������
 * @see JFrame
 */
public class DisplayManager extends JFrame{
	static int MENU_HEIGHT = 300;
	static int BUTTON_HEIGHT = 100; //���� ������ ����
/**����Ŭ������ �⺻������**/
	DisplayManager(){
		/**�̹��� URL*/
		URL imageURL;
		setTitle("����");//�������� Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�������� ������ ���α׷� ����
		setSize(1500,900);//������ ũ�⼳��
		Toolkit kit = Toolkit. getDefaultToolkit(); 
		Image img= kit.getImage(imageURL=getClass().getClassLoader().getResource("mandoo.png"));
		setIconImage(img);
	}
}
