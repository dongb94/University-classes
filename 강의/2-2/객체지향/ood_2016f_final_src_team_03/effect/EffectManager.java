package effect;

import javax.swing.JFrame;
import javax.swing.JLabel;
/** ����Ʈ ��¿� �ʿ��� �����ҵ��� ��Ƴ��� �߻�Ŭ����
 * @author ������
 * */
public abstract class EffectManager{
	/**����Ʈ�� ����� ������*/
	protected JFrame gameFrame;
	/**����Ʈ ��*/
	protected JLabel effect=new JLabel();
	/** ����Ʈ�� ����� �����Ӱ� ����Ʈ �󺧷� �ʱ�ȭ
	 * 
	 * @param game ����Ʈ�� ����� ������
	 * @param effect ����Ʈ ��
	 */
	protected EffectManager(JFrame game,JLabel effect){
		gameFrame=game;
		this.effect=effect;
	}
	
}
