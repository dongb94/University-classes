package effect;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**'����ȭ'�ؽ�Ʈ ȿ���� ����ϴ� Ŭ����
 * @author ������
 * @see EffectManager
 * */
public class SmallTextEffect extends EffectManager implements Runnable{
	/**�̹��� URL*/
	private URL imageURL;
	/**�ؽ�Ʈ�� ����� �����Ӱ� �ؽ�Ʈ �󺧷� �ʱ�ȭ
	 * 
	 * @param game �ؽ�Ʈ�� ����� ������
	 * @param smallText �����ӿ� ����� �ؽ�Ʈ ��
	 */
	public SmallTextEffect(JFrame game, JLabel smallText) {
		super(game, smallText);
		effect.setLocation(effect.getX()-150, effect.getY()-190);
		effect.setSize(371, 151);
		game.add(smallText);
	}
	/**ȿ���� ����ϴ� run �޼ҵ�*/
	public void run(){
		for(int i=1; i<5; i++){
			BufferedImage effectImage = null;
			try {
				Thread.sleep(150);
				effectImage=ImageIO.read(imageURL=getClass().getClassLoader().getResource("effect/smallText"+i+".png"));
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
				effectImage=ImageIO.read(imageURL=getClass().getClassLoader().getResource("effect/smallText"+i+".png"));
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