package effect;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**'쉴드'텍스트 효과를 출력하는 클래스
 * @author 변동건
 * @see EffectManager
 * */
public class ShieldTextEffect extends EffectManager implements Runnable{
	/**이미지 URL*/
	private URL imageURL;
	/** 텍스트를 출력할 프레임과 텍스트 라벨로 초기화
	 * 
	 * @param game 텍스트를 출력할 프레임
	 * @param shieldText 프레임에 출력할 텍스트 라벨
	 */
	public ShieldTextEffect(JFrame game, JLabel shieldText) {
		super(game, shieldText);
		effect.setLocation(effect.getX()-100, effect.getY()-190);
		effect.setSize(258, 151);
		game.add(shieldText);
	}
	/**효과를 출력하는 run 메소드*/
	public void run(){
		for(int i=1; i<5; i++){
			BufferedImage effectImage = null;
			try {
				Thread.sleep(150);
				effectImage=ImageIO.read(imageURL=getClass().getClassLoader().getResource("effect/shieldText"+i+".png"));
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
		try{
			Thread.sleep(300);
		}catch(InterruptedException e){
			
		}
		for(int i=4; i>0; i--){
			BufferedImage effectImage = null;
			try {
				Thread.sleep(150);
				effectImage=ImageIO.read(imageURL=getClass().getClassLoader().getResource("effect/shieldText"+i+".png"));
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