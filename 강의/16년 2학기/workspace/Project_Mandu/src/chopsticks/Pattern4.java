package chopsticks;
import java.awt.Rectangle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import chopsticks.Shooting;
import display.Game_stage;
/**���� �߻� ����1 Ŭ����
 * @author ������
 * */
public class Pattern4 {
	/**���� �߻� ����1
	 * �ϴܺο��� �������� 1�ٷ� ���ÿ� �߻�ȴ�.
	 * @param game ���� ȭ��
	 * */
	public Pattern4(Game_stage game) {
		ExecutorService es = Executors.newFixedThreadPool(10);
		for(int i=1; i<=10 ; i++){
			Rectangle r=new Rectangle();
			r.setBounds(i*80, 0, 0, 0);
			Shooting shot = new Shooting(game, i*80, 900, r);
			es.execute(shot);
		}
		es.shutdown();
	}
}