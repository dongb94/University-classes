package sound;

import java.awt.*;
import java.applet.*;
import java.net.URL;
import javax.swing.*;

import character.MyKeyListener;

public class SoundManager extends JPanel {
	/**배경을을 재생할 Audioclop */
	private static AudioClip soundClip = null;
	/**효과음을 재생할 Audioclip */
	private AudioClip effectClip = null;
	/**기본 생성자*/
	private SoundManager(){}
	/** JFrame과 track 번호로 초기화 */
	public SoundManager(JFrame soundFrame, int track) {
		SoundManager sound=new SoundManager();
		sound.play(track);
		soundFrame.add(sound);
	}
	/** JLabel과 track 번호로 초기화*/
	public SoundManager(JLabel soundFrame, int track) {
		SoundManager sound=new SoundManager();
		sound.play(track);
		soundFrame.add(sound);
	}
	/** 음악 재생 */
	private void play(int track) {
		URL url;
		switch (track) {
		case 1: //titlescrean1
			if(soundClip!=null) soundClip.stop();
			url = getClass().getResource("TitleScreen1.wav");
			soundClip = Applet.newAudioClip(url);
			soundClip.loop();
			break;
		case 2: //titlescrean2
			if(soundClip!=null) soundClip.stop();
			url = getClass().getResource("TitleScreen2.wav");
			soundClip = Applet.newAudioClip(url);
			soundClip.loop();
			break;
		case 3: //사망시
			if(soundClip!=null) soundClip.stop();
			url = getClass().getResource("end.wav");
			soundClip = Applet.newAudioClip(url);
			soundClip.play();
			break;
		case 4: //게임 플레이
			if(soundClip!=null) soundClip.stop();
			url = getClass().getResource("gameplay.wav");
			soundClip = Applet.newAudioClip(url);
			soundClip.loop();
			break;
		case 10:
			url = getClass().getResource("chopstick.wav");
			effectClip = Applet.newAudioClip(url);
			effectClip.play();
			break;
		case 11:
			url = getClass().getResource("move.wav");
			effectClip = Applet.newAudioClip(url);
			effectClip.play();
			MyKeyListener.sound=true;
			break;
		case 12:
			url = getClass().getResource("boom.wav");
			effectClip = Applet.newAudioClip(url);
			effectClip.play();
			break;
		default:
			if(soundClip!=null) soundClip.stop();
			url = getClass().getResource("TitleScreen1.wav");
			soundClip = Applet.newAudioClip(url);
			soundClip.loop();
		}
	
	}

}