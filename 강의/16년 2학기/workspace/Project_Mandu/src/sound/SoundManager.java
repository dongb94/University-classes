package sound;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.*;
import javax.swing.*;

/**
 * 사운드 매니저 클래스
 * 사운드를 프레임에 출력한다.
 * 
 * @author 변동건
 *
 */
public class SoundManager extends JPanel {
	/** 배경을을 재생할 Audioclop */
	private static Clip soundClip = null;
	/** 효과음을 재생할 Audioclip */
	private Clip effectClip = null;
	/** 배경음의 크기 */
	private static int soundVol=6;
	/** 효과음의 크기 */
	private static int effectVol=6;
	/**
	 * JFrame과 track 번호로 초기화
	 * 
	 * @param soundFrame
	 *            사운드 프레임
	 * @param track
	 *            음악 트랙
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
	 * JLabel과 track 번호로 초기화
	 * 
	 * @param soundFrame
	 *            사운드 라벨
	 * @param track
	 *            음악 트랙
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
	 * JButton과 track 번호로 초기화
	 * 
	 * @param soundFrame
	 *            사운드 버튼
	 * @param track
	 *            음악 트랙
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

	/**음악을 재생시키는 메소드
	 * 
	 * @param track 재생할 음악트렉 번호
	 * @throws LineUnavailableException
	 * @throws UnsupportedAudioFileException
	 * @throws IOException
	 * 
	 */
	private void play(int track) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
		AudioInputStream audioInputStream;
		FloatControl gainControl;
		/**사운드 URL*/
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
		case 3: // 사망시
			if (soundClip != null)
				soundClip.stop();
			audioInputStream = AudioSystem.getAudioInputStream(imageURL=getClass().getClassLoader().getResource("end.wav"));
			soundClip = AudioSystem.getClip();
			soundClip.open(audioInputStream);
			gainControl = (FloatControl) soundClip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(soundVol);
			soundClip.start();
			break;
		case 4: // 게임 플레이
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
	/** 배경음 조절 최저 -80 최대 6 
	 * 
	 * @param vol 적용할 볼륨
	 */
	public static void setSoundVol(int vol){
		soundVol=vol;
	}
	/** 효과음 조절 최저 -80 최대 6 
	 * 
	 * @param vol 적용할 볼륨
	 */
	public static void setEffectVol(int vol){
		effectVol=vol;
	}
	/** 
	 * 현재의 배경음 크기를 얻어온다
	 * 옵션창에서 슬라이드 값을 설정하는데 사용 
	 * @return 현재 볼륨을 리턴
	 */
	public static int getSoundVol(){
		return soundVol;
	}
	/** 
	 * 현재의 효과음 크기를 얻어온다
	 * 옵션창에서 슬라이드 값을 설정하는데 사용
	 * @return 현재 볼륨을 리턴
	 * */
	public static int getEffectVol(){
		return effectVol;
	}
}