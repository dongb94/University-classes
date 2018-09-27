package effect;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
/** 간장과 함께 나오는 효과를 출력하는 클래스
 * @author 변동건
 * @see EffectManager
 * */
public class GanjangEffect extends EffectManager implements Runnable{
	/**이미지 URL*/
	private URL imageURL;
	/**이펙트 출력할 프레임과 이펙트 라벨로 초기화
	 * 
	 * @param game
	 * @param ganjang
	 */
	public GanjangEffect(JFrame game, JLabel ganjang) {
		super(game, ganjang);
		effect.setSize(300, 317);
	}
	/**효과를 출력하는 run 메소드*/
	public void run(){
		for(int i=10; i>0; i--){
			BufferedImage effectImage = null;
			try {
				Thread.sleep(20);
				effectImage=ImageIO.read(imageURL=getClass().getClassLoader().getResource("effect/ganjang"+i+".png"));
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
			Thread.sleep(2000);
		}catch(InterruptedException e){
			
		}
		for(int i=1; i<=10; i++){
			BufferedImage effectImage = null;
			try {
				Thread.sleep(20);
				effectImage=ImageIO.read(imageURL=getClass().getClassLoader().getResource("effect/ganjang"+i+".png"));
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
