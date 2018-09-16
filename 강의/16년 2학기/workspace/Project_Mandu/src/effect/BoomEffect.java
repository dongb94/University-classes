package effect;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**���� ȿ���� ����ϴ� Ŭ����
 * 
 * @author ������
 * @see EffectManager
 */
public class BoomEffect extends EffectManager implements Runnable{
	/**�̹��� URL*/
	private URL imageURL;
	/** ȿ���� ����� �����Ӱ� ����Ʈ �󺧷� �ʱ�ȭ
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
	/**ȿ���� ����ϴ� run �޼ҵ�*/
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