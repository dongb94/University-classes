package effect;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class EffectManager{
	/**����Ʈ�� ��µǴ� ������(�ʱ�ȭ�� ���ڷ� ����)*/
	protected JFrame gameFrame;
	/**����Ʈ*/
	protected JLabel effect=new JLabel();
	/** ����Ʈ�� ����� �����Ӱ� ��ġ�� �ʱ�ȭ*/
	protected EffectManager(JFrame game,Rectangle r){
		gameFrame=game;
		effect.setBounds(r);
		game.add(effect);
	}
}
