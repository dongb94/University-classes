package chopsticks;

import display.Game_stage;
/**Pattern Ŭ�������� ���հ����Ͽ� �߻��ϴ� Ŭ����
 * @author ������
 * */
public class Patterns implements Runnable {
	/**������ ����Ǵ� ȭ��*/
	private Game_stage game;
	
	/**Game_stage��ü�� �ʱ�ȭ ��Ų��.
	 * 
	 * @param game ���� ȭ��
	 */
	public Patterns(Game_stage game) {
		this.game = game;
	}
	/**���� 1 ����*/
	private void pattern1() {
		new Pattern1(game);
	}
	/**���� 2 ����*/
	private void pattern2() {
		new Pattern2(game);
	}
	/**���� 3 ����*/
	private void pattern3() {
		new Pattern3(game);
	}
	/**���� 4 ����*/
	private void pattern4() {
		new Pattern4(game);
	}
	/**���� 5 ����*/
	private void pattern5() {
		new Pattern5(game);
	}
	/** ���ϵ��� �����ϴ� run �޼ҵ� */
	public void run() {
		int i=0;
		while (game.player.getLife() > 0) {
			pattern1();
			if (i>45||(i % 3 == 2 && i > 20))
				pattern3();
			if (i == 10 || i == 30 || i == 40)
				pattern4();
			if (i == 15 || i == 35 || i == 40)
				pattern5();
			if (i % 5 == 1 && i > 5)
				pattern2();
			try{
				i++;
				Thread.sleep(1000);
			}catch(InterruptedException ex){
				
			}
		}
	}
}
