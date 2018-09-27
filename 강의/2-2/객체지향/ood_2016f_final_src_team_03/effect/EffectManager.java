package effect;

import javax.swing.JFrame;
import javax.swing.JLabel;
/** 이펙트 출력에 필요한 공통요소들을 모아놓은 추상클래스
 * @author 변동건
 * */
public abstract class EffectManager{
	/**이펙트를 출력할 프레임*/
	protected JFrame gameFrame;
	/**이펙트 라벨*/
	protected JLabel effect=new JLabel();
	/** 이펙트를 출력할 프레임과 이펙트 라벨로 초기화
	 * 
	 * @param game 이펙트를 출력할 프레임
	 * @param effect 이펙트 라벨
	 */
	protected EffectManager(JFrame game,JLabel effect){
		gameFrame=game;
		this.effect=effect;
	}
	
}
