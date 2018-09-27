package chopsticks;
import java.awt.Rectangle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import chopsticks.Shooting;
import display.Game_stage;
/**���� �߻� ����2 Ŭ����
 * @author ������
 * */
public class Pattern5 {
	/**���� �߻� ����2
	 * �����ʿ��� �������� 1�ٷ� ���ÿ� �߻�ȴ�.
	 * @param game ���� ȭ��
	 * */
	public Pattern5(Game_stage game) {
		ExecutorService es = Executors.newFixedThreadPool(10);
		for(int i=1; i<=10 ; i++){
			Rectangle r=new Rectangle();
			r.setBounds(0, i*80-40, 0, 0);
			Shooting shot = new Shooting(game, 1000, i*80-40, r);
			es.execute(shot);
		}
		es.shutdown();
	}
}