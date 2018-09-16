package effect;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class EffectManager{
	/**이펙트가 출력되는 프레임(초기화시 인자로 받음)*/
	protected JFrame gameFrame;
	/**이펙트*/
	protected JLabel effect=new JLabel();
	/** 이펙트를 출력할 프레임과 위치로 초기화*/
	protected EffectManager(JFrame game,Rectangle r){
		gameFrame=game;
		effect.setBounds(r);
		game.add(effect);
	}
}
