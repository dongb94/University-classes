package effect;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class BoomEffect extends EffectManager implements Runnable{
	/** 이펙트를 출력할 프레임과 위치로 초기화*/
	public BoomEffect(JFrame game, Rectangle r) {
		super(game, r);
		effect.setLocation(effect.getX()-20, effect.getY()-20);
		effect.setSize(90, 90);
	}
	/** boom 이펙트를 출력*/
	public void run(){
		for(int i=1; i<=25; i++){
			BufferedImage effectImage = null;
			try {
				Thread.sleep(20);
				effectImage=ImageIO.read(new File("image/effect/boom"+i+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ImageIcon effectIcon=new ImageIcon(effectImage);
			effect.setIcon(effectIcon);
			effect.validate();
			effect.repaint();
		}
		gameFrame.remove(effect);
		gameFrame.repaint();
	}
}