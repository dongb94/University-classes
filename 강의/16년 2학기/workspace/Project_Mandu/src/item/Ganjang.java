package item;

import java.awt.Rectangle;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import character.PlayerManager;
import display.Game_stage;
import sound.SoundManager;
/**간장을 발사하는 클래스
 * 1개의 간장 객체를 발사한다.
 * @author 변동건
 * */
public class Ganjang implements Runnable {
	/**게임 프레임*/
	private JFrame gameFrame;
	/**간장의 위치정보*/
	private Rectangle chopLocation;	//젓가락의 현재 위치
	/**간장 */
	private JLabel ganjang;//발사되는 젓가락
	/**이미지 URL*/
	private URL imageURL;
	/**간장의 출발 좌표 x,y 출발후에는 젓가락의 x축, y축 속도*/
	private int x,y;				//젓가락의 출발위치, setDirection() 호출 후 젓가락의 속도
	/**간장의 피격 판정 계산위치
	 * {x,y}*/
	private int attackPoint[]=new int [2]; // 피격 판정 계산위치 {{x,y},{x,y}}
	/**간장이 만두에 닿았는지 확인하는 boolean값
	 * 닿았을시 true
	 */
	private boolean hit=false;
	/**만두의 위치를 불러올 플레이어 메니저*/
	private PlayerManager player;
	/** 게임이 진행되는 프레임과 간장 라벨로 초기화
	 * 
	 * @param game 게임 스테이지 객체
	 * @param ganjang 간장이미지 라벨
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
	/** run메소드*/
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
			//화살이 접시범위를 벗어나면 쓰레드 중지
			for(;(-400<chopLocation.x&&chopLocation.x<1500)&&(-400<chopLocation.y&&chopLocation.y<1200);)
			{
				attackPoint[0]+=x;
				attackPoint[1]+=y;

				ganjang.setLocation(chopLocation.x+x, chopLocation.y+y);
				attackDicision();	//피격 판별
				if(player.getLife()<1||hit){
					break;
				}//life가 0일시 break
				Thread.sleep(100);
				chopLocation=ganjang.getBounds();
			}
			gameFrame.remove(ganjang);
		} catch (InterruptedException e){
			return;
		}
	}
	/**간장의 방향 설정*/
	private void setDirection1()	// 최초방향 설정 (x,y가 모두 0이되는경우 처리)
	{			
		x=(int) (Math.random()*800-x-2);
		y=(int) (Math.random()*800-y-2);
		double r=Math.sqrt(x*x+y*y);		//대각선의 길이
		x=(int) (10*x/r);
		y=(int) (10*y/r);
		setAttackPoint();
	}
	/**간장과 만두의 피격 판별지점 설정  */
	private void setAttackPoint()
	{
		attackPoint[0]=(int) (chopLocation.getCenterX());
		attackPoint[1]=(int) (chopLocation.getCenterY());
	}
	/**간장과 만두의 피격 판정*/
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
