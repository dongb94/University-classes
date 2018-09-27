package item;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JLabel;

import display.Game_stage;
/**���� ���� �߻� ���� Ŭ����
 * @author ������
 * */
public class GanjangShot extends Thread {
	/**������ �߻�� ���� ȭ��*/
	private Game_stage game;
	/**���� �̹����� ����� ��ü*/
	protected JLabel[] ganjang=new JLabel[20];
	/**������ �߻�� ���� ȭ��� ������ �̹����� ������ JLabel�� �ʱ�ȭ
	 * 
	 * @param game ������ �߻�� ���� ȭ��
	 * @param ganjang ������ �̹����� ������ JLabel
	 */
	public GanjangShot(Game_stage game,JLabel[] ganjang) {
		this.game=game;
		this.ganjang=ganjang;
	}
	/**Ganjang Ŭ������ ȣ���� ������ ������ ������ run�޼ҵ�*/
	public void run(){
		ExecutorService es = Executors.newFixedThreadPool(20);
		for(int i=0; i<20; i++){
			Ganjang shot=new Ganjang(game,ganjang[i]);
			es.execute(shot);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		es.shutdown();
	}
}