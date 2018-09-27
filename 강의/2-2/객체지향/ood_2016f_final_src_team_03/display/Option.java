package display;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;
import javax.swing.event.*;

import sound.SoundManager;

/** 배경음악 및 효과음 조절하는 디스플레이 
 * 
 * @author 나희지,변동건
 * @see DisplayManager
 */
public class Option extends DisplayManager {

	/**option의 기본생성자*/
	Option() {
		/**이미지 URL*/
		URL imageURL;
		
		ImageIcon title = new ImageIcon(imageURL=getClass().getClassLoader().getResource("opt.png"));
		JLabel title1 = new JLabel(title);
		title1.setBounds(0, 0, 1500, 900);
		setContentPane(title1);
		
		Container contentpane = getContentPane();// 컨텐트 팬을 알아낸다
		contentpane.setLayout(null);// 레이아웃변경
		
		ImageIcon back = new ImageIcon(imageURL=getClass().getClassLoader().getResource("back.png"));
		JButton back1 = new JButton(back);
		MyMouseListener listener_back = new MyMouseListener();
		back1.addMouseListener(listener_back);
		back1.setBounds(70, 700, 230, 110);
		contentpane.add(back1);

		ImageIcon image = new ImageIcon(imageURL=getClass().getClassLoader().getResource("mando1.png")); // 만두 이미지 로딩
		JLabel image1 = new JLabel(image);
		image1.setBounds(100, -150, 500, 500);
		contentpane.add(image1);

		ImageIcon image2 = new ImageIcon(imageURL=getClass().getClassLoader().getResource("mando1.png"));// 만두 이미지 로딩
		JLabel image11 = new JLabel(image2);
		image11.setBounds(850, -150, 500, 500);
		contentpane.add(image11);
		
		/** 슬라이더의 상태 변화을 인식하는 ChangeListener
		 * @author 변동건 */
		ChangeListener listener = new ChangeListener() {
			/** 슬라이더의 값을 가져와 음악의 크기를 조절하는 이벤트
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
		
		/** 배경음을 조절하는 슬라이드 
		 * @author 변동건*/
		JSlider slider1 = new JSlider();
		slider1.setValue((SoundManager.getSoundVol()+20)*4);
		slider1.setName("background sound");
		slider1.setPaintTicks(true);// 슬라이더 하단에 틱 생성
		slider1.setSnapToTicks(true);// 슬라이더 틱이 있는곳에만 바가 멈춤
		slider1.setMajorTickSpacing(20);// 슬라이더 틱(대)가 20틱마다 있음
		slider1.setMinorTickSpacing(5);// 슬라이더 틱(소)가 5틱마다 있음
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
		
		/** 효과음을 조절하는 슬라이드
		 * @author 변동건 */
		JSlider slider2 = new JSlider();
		slider2.setValue((SoundManager.getEffectVol()+20)*4);
		slider2.setName("effect sound");
		slider2.setPaintTicks(true);// 슬라이더 하단에 틱 생성
		slider2.setSnapToTicks(true);// 슬라이더 틱이 있는곳에만 바가 멈춤
		slider2.setMajorTickSpacing(20);// 슬라이더 틱(대)가 20틱마다 있음
		slider2.setMinorTickSpacing(5);// 슬라이더 틱(소)가 5틱마다 있음
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
		
		setVisible(true);// 프레임을 화면에 출력
	}
/**Option 클래스의 내부클래스로서
 * 프레임에 부착 된 버튼을 해당하는 창으로 보내는 클래스
 * @author 나희지
 * 
 */
	class MyMouseListener implements MouseListener, MouseMotionListener {
		public void mouseClicked(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		/**Main화면으로 돌아가는 Back버튼의 기능을 구현해준다
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
