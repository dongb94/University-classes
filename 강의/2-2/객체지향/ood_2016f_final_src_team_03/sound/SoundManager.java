package sound;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.*;
import javax.swing.*;

/**
 * ���� �Ŵ��� Ŭ����
 * ���带 �����ӿ� ����Ѵ�.
 * 
 * @author ������
 *
 */
public class SoundManager extends JPanel {
	/** ������� ����� Audioclop */
	private static Clip soundClip = null;
	/** ȿ������ ����� Audioclip */
	private Clip effectClip = null;
	/** ������� ũ�� */
	private static int soundVol=6;
	/** ȿ������ ũ�� */
	private static int effectVol=6;
	/**
	 * JFrame�� track ��ȣ�� �ʱ�ȭ
	 * 
	 * @param soundFrame
	 *            ���� ������
	 * @param track
	 *            ���� Ʈ��
	 */
	public SoundManager(JFrame soundFrame, int track) {
		try {
			play(track);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		soundFrame.add(this);
	}

	/**
	 * JLabel�� track ��ȣ�� �ʱ�ȭ
	 * 
	 * @param soundFrame
	 *            ���� ��
	 * @param track
	 *            ���� Ʈ��
	 */
	public SoundManager(JLabel soundFrame, int track) {
		try {
			play(track);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		soundFrame.add(this);
	}
	/**
	 * JButton�� track ��ȣ�� �ʱ�ȭ
	 * 
	 * @param soundFrame
	 *            ���� ��ư
	 * @param track
	 *            ���� Ʈ��
	 */
	public SoundManager(JButton soundFrame, int track) {
		try {
			play(track);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		soundFrame.add(this);
	}

	/**������ �����Ű�� �޼ҵ�
	 * 
	 * @param track ����� ����Ʈ�� ��ȣ
	 * @throws LineUnavailableException
	 * @throws UnsupportedAudioFileException
	 * @throws IOException
	 * 
	 */
	private void play(int track) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
		AudioInputStream audioInputStream;
		FloatControl gainControl;
		/**���� URL*/
		URL imageURL;
		switch (track) {
		case 1: // titlescrean1
			if (soundClip != null)
				soundClip.stop();
			audioInputStream = AudioSystem.getAudioInputStream(imageURL=getClass().getClassLoader().getResource("TitleScreen1.wav"));
			soundClip = AudioSystem.getClip();
			soundClip.open(audioInputStream);
			gainControl = (FloatControl) soundClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(soundVol);
			soundClip.start();
			break;
		case 3: // �����
			if (soundClip != null)
				soundClip.stop();
			audioInputStream = AudioSystem.getAudioInputStream(imageURL=getClass().getClassLoader().getResource("end.wav"));
			soundClip = AudioSystem.getClip();
			soundClip.open(audioInputStream);
			gainControl = (FloatControl) soundClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(soundVol);
			soundClip.start();
			break;
		case 4: // ���� �÷���
			if (soundClip != null)
				soundClip.stop();
			audioInputStream = AudioSystem.getAudioInputStream(imageURL=getClass().getClassLoader().getResource("gameplay.wav"));
			soundClip = AudioSystem.getClip();
			soundClip.open(audioInputStream);
			gainControl = (FloatControl) soundClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(soundVol);
			soundClip.start();
			break;
		case 10:
			audioInputStream = AudioSystem.getAudioInputStream(imageURL=getClass().getClassLoader().getResource("chopstick.wav"));
			effectClip = AudioSystem.getClip();
			effectClip.open(audioInputStream);
			gainControl = (FloatControl) effectClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(effectVol);
			effectClip.start();
			break;
		case 11:
			audioInputStream = AudioSystem.getAudioInputStream(imageURL=getClass().getClassLoader().getResource("move.wav"));
			effectClip = AudioSystem.getClip();
			effectClip.open(audioInputStream);
			gainControl = (FloatControl) effectClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(effectVol);
			effectClip.start();
			break;
		case 12:
			audioInputStream = AudioSystem.getAudioInputStream(imageURL=getClass().getClassLoader().getResource("boom.wav"));
			effectClip = AudioSystem.getClip();
			effectClip.open(audioInputStream);
			gainControl = (FloatControl) effectClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(effectVol);
			effectClip.start();
			break;
		case 13:
			audioInputStream = AudioSystem.getAudioInputStream(imageURL=getClass().getClassLoader().getResource("bubble.wav"));
			effectClip = AudioSystem.getClip();
			effectClip.open(audioInputStream);
			gainControl = (FloatControl) effectClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(effectVol);
			effectClip.start();
			break;
		default:
			if (soundClip != null)
				soundClip.stop();
		}
	}
	/** ����� ���� ���� -80 �ִ� 6 
	 * 
	 * @param vol ������ ����
	 */
	public static void setSoundVol(int vol){
		soundVol=vol;
	}
	/** ȿ���� ���� ���� -80 �ִ� 6 
	 * 
	 * @param vol ������ ����
	 */
	public static void setEffectVol(int vol){
		effectVol=vol;
	}
	/** 
	 * ������ ����� ũ�⸦ ���´�
	 * �ɼ�â���� �����̵� ���� �����ϴµ� ��� 
	 * @return ���� ������ ����
	 */
	public static int getSoundVol(){
		return soundVol;
	}
	/** 
	 * ������ ȿ���� ũ�⸦ ���´�
	 * �ɼ�â���� �����̵� ���� �����ϴµ� ���
	 * @return ���� ������ ����
	 * */
	public static int getEffectVol(){
		return effectVol;
	}
}