package item;

import java.awt.Rectangle;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import character.PlayerManager;
import display.Game_stage;
import sound.SoundManager;
/**������ �߻��ϴ� Ŭ����
 * 1���� ���� ��ü�� �߻��Ѵ�.
 * @author ������
 * */
public class Ganjang implements Runnable {
	/**���� ������*/
	private JFrame gameFrame;
	/**������ ��ġ����*/
	private Rectangle chopLocation;	//�������� ���� ��ġ
	/**���� */
	private JLabel ganjang;//�߻�Ǵ� ������
	/**�̹��� URL*/
	private URL imageURL;
	/**������ ��� ��ǥ x,y ����Ŀ��� �������� x��, y�� �ӵ�*/
	private int x,y;				//�������� �����ġ, setDirection() ȣ�� �� �������� �ӵ�
	/**������ �ǰ� ���� �����ġ
	 * {x,y}*/
	private int attackPoint[]=new int [2]; // �ǰ� ���� �����ġ {{x,y},{x,y}}
	/**������ ���ο� ��Ҵ��� Ȯ���ϴ� boolean��
	 * ������� true
	 */
	private boolean hit=false;
	/**������ ��ġ�� �ҷ��� �÷��̾� �޴���*/
	private PlayerManager player;
	/** ������ ����Ǵ� �����Ӱ� ���� �󺧷� �ʱ�ȭ
	 * 
	 * @param game ���� �������� ��ü
	 * @param ganjang �����̹��� ��
	 */
	public Ganjang(Game_stage game, JLabel ganjang)
	{
		gameFrame=game;
		x=1255;
		y=665;
		ganjang.setBounds(x, y, 15, 15);
		player=game.player;
		this.ganjang=ganjang;
	}
	/** run�޼ҵ�*/
	public void run()
	{
		chopLocation=ganjang.getBounds();
		setDirection1();
		ImageIcon chopstick = new ImageIcon(imageURL=getClass().getClassLoader().getResource("ganjang.png"));
		ganjang.setIcon(chopstick);
		ganjang.setVisible(true);
		new SoundManager(gameFrame,13);
		try	
		{
			//ȭ���� ���ù����� ����� ������ ����
			for(;(-400<chopLocation.x&&chopLocation.x<1500)&&(-400<chopLocation.y&&chopLocation.y<1200);)
			{
				attackPoint[0]+=x;
				attackPoint[1]+=y;

				ganjang.setLocation(chopLocation.x+x, chopLocation.y+y);
				attackDicision();	//�ǰ� �Ǻ�
				if(player.getLife()<1||hit){
					break;
				}//life�� 0�Ͻ� break
				Thread.sleep(100);
				chopLocation=ganjang.getBounds();
			}
			gameFrame.remove(ganjang);
		} catch (InterruptedException e){
			return;
		}
	}
	/**������ ���� ����*/
	private void setDirection1()	// ���ʹ��� ���� (x,y�� ��� 0�̵Ǵ°�� ó��)
	{			
		x=(int) (Math.random()*800-x-2);
		y=(int) (Math.random()*800-y-2);
		double r=Math.sqrt(x*x+y*y);		//�밢���� ����
		x=(int) (10*x/r);
		y=(int) (10*y/r);
		setAttackPoint();
	}
	/**����� ������ �ǰ� �Ǻ����� ����  */
	private void setAttackPoint()
	{
		attackPoint[0]=(int) (chopLocation.getCenterX());
		attackPoint[1]=(int) (chopLocation.getCenterY());
	}
	/**����� ������ �ǰ� ����*/
	private void attackDicision()
	{
		for(int i=0; i<2; i++)
		{
			int x=(int) (attackPoint[0]-player.getMandu().getX()-player.getMandu().getWidth()/2);
			int y=(int) (attackPoint[1]-player.getMandu().getY()-player.getMandu().getHeight()/2);
			double r=Math.sqrt(x*x+y*y);
			if(r<player.getMandu().getWidth()/2)
			{
				PlayerManager.speed=1;
				new SoundManager(gameFrame,13);	
				gameFrame.remove(ganjang);
				hit=true;
			}
		}
	}
}
