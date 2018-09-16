package display;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;
import javax.swing.event.*;

import sound.SoundManager;

/** ������� �� ȿ���� �����ϴ� ���÷��� 
 * 
 * @author ������,������
 * @see DisplayManager
 */
public class Option extends DisplayManager {

	/**option�� �⺻������*/
	Option() {
		/**�̹��� URL*/
		URL imageURL;
		
		ImageIcon title = new ImageIcon(imageURL=getClass().getClassLoader().getResource("opt.png"));
		JLabel title1 = new JLabel(title);
		title1.setBounds(0, 0, 1500, 900);
		setContentPane(title1);
		
		Container contentpane = getContentPane();// ����Ʈ ���� �˾Ƴ���
		contentpane.setLayout(null);// ���̾ƿ�����
		
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
		
		/** �����̴��� ���� ��ȭ�� �ν��ϴ� ChangeListener
		 * @author ������ */
		ChangeListener listener = new ChangeListener() {
			/** �����̴��� ���� ������ ������ ũ�⸦ �����ϴ� �̺�Ʈ
			 * @param event ChangeEvent
			 * */
			public void stateChanged(ChangeEvent event) {
				// update text field when the slider value changes
				JSlider source = (JSlider) event.getSource();
				
				int vol=(int)(source.getValue()*0.26)-20;
				
				if(source.getName()=="background sound"){
					SoundManager.setSoundVol(vol);
				}else{
					SoundManager.setEffectVol(vol);
				}
			}
		};
		
		/** ������� �����ϴ� �����̵� 
		 * @author ������*/
		JSlider slider1 = new JSlider();
		slider1.setValue((SoundManager.getSoundVol()+20)*4);
		slider1.setName("background sound");
		slider1.setPaintTicks(true);// �����̴� �ϴܿ� ƽ ����
		slider1.setSnapToTicks(true);// �����̴� ƽ�� �ִ°����� �ٰ� ����
		slider1.setMajorTickSpacing(20);// �����̴� ƽ(��)�� 20ƽ���� ����
		slider1.setMinorTickSpacing(5);// �����̴� ƽ(��)�� 5ƽ���� ����
		slider1.setBounds(250, 63, 360, 70);

		slider1.addChangeListener(listener);
		ImageIcon optionImage = new ImageIcon(imageURL=getClass().getClassLoader().getResource("optionPane.png"));
		ImageIcon backgroundSoundImage = new ImageIcon(imageURL=getClass().getClassLoader().getResource("backgroundSound.png"));
		JLabel panel = new JLabel(optionImage);
		panel.setBounds(405, 220, 644, 193);
		JLabel backgroundSoundText = new JLabel(backgroundSoundImage);
		backgroundSoundText.setBounds(-10, 33, 284, 141);
		panel.add(backgroundSoundText);
		panel.add(slider1);
		contentpane.add(panel);
		
		/** ȿ������ �����ϴ� �����̵�
		 * @author ������ */
		JSlider slider2 = new JSlider();
		slider2.setValue((SoundManager.getEffectVol()+20)*4);
		slider2.setName("effect sound");
		slider2.setPaintTicks(true);// �����̴� �ϴܿ� ƽ ����
		slider2.setSnapToTicks(true);// �����̴� ƽ�� �ִ°����� �ٰ� ����
		slider2.setMajorTickSpacing(20);// �����̴� ƽ(��)�� 20ƽ���� ����
		slider2.setMinorTickSpacing(5);// �����̴� ƽ(��)�� 5ƽ���� ����
		slider2.setBounds(250, 63, 360, 70);

		slider2.addChangeListener(listener);
		ImageIcon effectSoundImage = new ImageIcon(imageURL=getClass().getClassLoader().getResource("effectSound.png"));
		JLabel panel2 = new JLabel(optionImage);
		panel2.setBounds(405, 450, 644, 193);
		JLabel effectSoundText = new JLabel(effectSoundImage);
		effectSoundText.setBounds(-10, 33, 284, 141);
		panel2.add(effectSoundText);
		panel2.add(slider2);
		contentpane.add(panel2);
		
		setVisible(true);// �������� ȭ�鿡 ���
	}
/**Option Ŭ������ ����Ŭ�����μ�
 * �����ӿ� ���� �� ��ư�� �ش��ϴ� â���� ������ Ŭ����
 * @author ������
 * 
 */
	class MyMouseListener implements MouseListener, MouseMotionListener {
		public void mouseClicked(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		/**Mainȭ������ ���ư��� Back��ư�� ����� �������ش�
		 * 
		 * @param e
		*/
		public void mouseReleased(MouseEvent e) {
			JButton back1 = (JButton) e.getSource();
			new SoundManager(back1,13);
			setVisible(false);
			new Main();
		}
		public void mouseDragged(MouseEvent e){}
		public void mouseMoved(MouseEvent e){}
	}
}
