package effect;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**폭발 효과를 출력하는 클래스
 * 
 * @author 변동건
 * @see EffectManager
 */
public class BoomEffect extends EffectManager implements Runnable{
	/**이미지 URL*/
	private URL imageURL;
	/** 효과를 출력할 프레임과 이펙트 라벨로 초기화
	 * 
	 * @param game
	 * @param boom
	 */
	public BoomEffect(JFrame game, JLabel boom) {
		super(game, boom);
		effect.setLocation(effect.getX()-20, effect.getY()-20);
		effect.setSize(90, 90);
		game.add(boom);
	}
	/**효과를 출력하는 run 메소드*/
	public void run(){
		for(int i=1; i<=25; i++){
			BufferedImage effectImage = null;
			try {
				Thread.sleep(20);
				effectImage=ImageIO.read(imageURL=getClass().getClassLoader().getResource("effect/boom"+i+".png"));
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