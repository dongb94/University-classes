package chopsticks;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import character.PlayerManager;
import display.Game_stage;
import effect.BoomEffect;
import sound.SoundManager;

public class Shooting extends Chopstick implements Runnable {
	/** 1 Radian to degree*/
	private final double RADIAN=57.2958;
	/**젓가락의 위치정보*/
	private Rectangle chopLocation;	//젓가락의 현재 위치
	/**만두의 위치정보 (젓가락이 향할 방향)*/
	private Rectangle destination;//만두의 위치 정보
	/**젓가락 */
	private JLabel chop=new JLabel();//발사되는 젓가락
	/**젓가락의 이미지*/
	private BufferedImage chopImage;//젓가락의 이미지
	/**젓가락의 출발 좌표 x,y 출발후에는 젓가락의 x축, y축 속도*/
	private int x,y;				//젓가락의 출발위치, setDirection() 호출 후 젓가락의 속도
	/**젓가락의 피격 판정 계산위치
	 * {{x,y},{x,y}}*/
	private int attackPoint[][]=new int [2][2]; // 피격 판정 계산위치 {{x,y},{x,y}}
	/**만두의 위치를 불러올 플레이어 메니저*/
	private PlayerManager player;
	/** 게임이 진행되는 프레임과 젓가락의 출발좌표 (x,y)로 초기화*/
	public Shooting(Game_stage game, int x, int y)
	{//출발좌표 x,y:int , 만두의 위치 mandu:Rectangle
		super(game);
		destination=game.player.getMandu().getBounds();
		this.x=x;
		this.y=y;
		chop.setBounds(x, y, size, size);
		player=game.player;
	}
	
	/** 게임이 진행되는 프레임과 젓가락의 출발좌표 (x,y), 젓가락을 발사할 방향으로 초기화
	 * r은 젓가락을 발사할 방향*/
	public Shooting(Game_stage game, int x, int y, Rectangle destination)
	{
		super(game);
		this.destination=destination;
		this.x=x;
		this.y=y;
		chop.setBounds(x, y, size, size);
		player=game.player;
	}
	/** 게임이 진행되는 프레임과 젓가락의 출발좌표 (x,y), 젓가락의 추적여부로 초기화
	 * tracking이 true이면 추적*/
	public Shooting(Game_stage game, int x, int y, boolean tracking)
	{
		super(game,tracking);
		destination=game.player.getMandu().getBounds();
		this.x=x;
		this.y=y;
		chop.setBounds(x, y, size, size);
		player=game.player;
	}
	/** run메소드*/
	public void run()
	{
		chopLocation=chop.getBounds();
		setDirection1();
		ImageIcon chopstick = new ImageIcon(chopImage);
		chop.setIcon(chopstick);
		gameFrame.add(chop);
		chop.setVisible(true);
		new SoundManager(gameFrame,10);
		try	
		{
			//화살이 접시범위를 벗어나면 쓰레드 중지
			for(;(-400<chopLocation.x&&chopLocation.x<1200)&&(-400<chopLocation.y&&chopLocation.y<1200);)
			{
				if(tracking)
				{
					destination=player.getMandu().getBounds();
					setDirection2();
					chopstick = new ImageIcon(chopImage);
					chop.setIcon(chopstick);
				}
				else
				{
					attackPoint[0][0]+=x;
					attackPoint[0][1]+=y;
					attackPoint[1][0]+=x;
					attackPoint[1][1]+=y;
				}
				chop.setLocation(chopLocation.x+x, chopLocation.y+y);
				attackDicision();	//피격 판별
				if(player.getLife()<1){
					break;
				}//life가 0일시 break
				Thread.sleep(100);
				chopLocation=chop.getBounds();
			}
			gameFrame.remove(chop);
		} catch (InterruptedException e){
			return;
		}
	}
	/**최초 방향 설정*/
	private void setDirection1()	// 최초방향 설정 (x,y가 모두 0이되는경우 처리)
	{			
		x=(int) (destination.getCenterX()-x-size/2);
		y=(int) (destination.getCenterY()-y-size/2);
		double r=Math.sqrt(x*x+y*y);		//대각선의 길이
		double degree;						// 젓가락의 각도
		if(y>0)
			degree=Math.acos(-x/r);
		else
			degree=Math.acos(x/r)+3.14;
		x=(int) (speed*x/r);
		y=(int) (speed*y/r);
		setImage(degree*RADIAN);
		setAttackPoint(degree);
	}
	/**유도시 중간 방향 설정*/
	private void setDirection2()	// 유도시 중간 방향 설정
	{		
		if(destination.getCenterX()-chopLocation.getCenterX()<0) x--;
		else x++;
		if(destination.getCenterY()-chopLocation.getCenterY()<0) y--;
		else y++;
		double r=Math.sqrt(x*x+y*y);
		double degree;
		if(y>0)
			degree=Math.acos(-x/r);
		else
			degree=Math.acos(x/r)+3.14;
		setImage(degree*RADIAN);
		setAttackPoint(degree);
	}
	/**젓가락의 방향에 따른 이미지를 결정하는 메소드*/
	private void setImage(double degree)
	{
		try 
		{
			if(degree%360<12)
				chopImage=ImageIO.read(new File("image/chopstick.png"));
			else if(degree%360<37)
				chopImage=ImageIO.read(new File("image/chopstick22.png"));
			else if(degree%360<57)
				chopImage=ImageIO.read(new File("image/chopstick45.png"));
			else if(degree%360<79)
				chopImage=ImageIO.read(new File("image/chopstick67.png"));
			else if(degree%360<102)
				chopImage=ImageIO.read(new File("image/chopstick90.png"));
			else if(degree%360<124)
				chopImage=ImageIO.read(new File("image/chopstick112.png"));
			else if(degree%360<147)
				chopImage=ImageIO.read(new File("image/chopstick135.png"));
			else if(degree%360<169)
				chopImage=ImageIO.read(new File("image/chopstick157.png"));
			else if(degree%360<195)
				chopImage=ImageIO.read(new File("image/chopstick180.png"));
			else if(degree%360<220)
				chopImage=ImageIO.read(new File("image/chopstick202.png"));
			else if(degree%360<235)
				chopImage=ImageIO.read(new File("image/chopstick225.png"));
			else if(degree%360<259)
				chopImage=ImageIO.read(new File("image/chopstick247.png"));
			else if(degree%360<282)
				chopImage=ImageIO.read(new File("image/chopstick270.png"));
			else if(degree%360<304)
				chopImage=ImageIO.read(new File("image/chopstick292.png"));
			else if(degree%360<327)
				chopImage=ImageIO.read(new File("image/chopstick315.png"));
			else if(degree%360<349)
				chopImage=ImageIO.read(new File("image/chopstick337.png"));
			else
				chopImage=ImageIO.read(new File("image/chopstick.png"));
		} catch (IOException e) {
			System.err.println("이미지 로딩 실패");
		}
	}
	/**피격 판별지점 설정*/
	private void setAttackPoint(double degree)
	{
		attackPoint[0][0]=(int) (chopLocation.getCenterX()+size*Math.cos(degree)/2);
		attackPoint[0][1]=(int) (chopLocation.getCenterY()+size*Math.sin(degree)/2);
		attackPoint[1][0]=(int) (chopLocation.getCenterX()-size*Math.cos(degree)/2);
		attackPoint[1][1]=(int) (chopLocation.getCenterY()-size*Math.sin(degree)/2);
	}
	/**피격 판정*/
	private void attackDicision()
	{
		for(int i=0; i<2; i++)
		{
			int x=(int) (attackPoint[i][0]-player.getMandu().getX()-player.getMandu().getWidth()/2);
			int y=(int) (attackPoint[i][1]-player.getMandu().getY()-player.getMandu().getHeight()/2);
			double r=Math.sqrt(x*x+y*y);
			if(r<player.getMandu().getWidth()/2)
			{
				player.downLife();
				BoomEffect boomEffect=new BoomEffect(gameFrame,player.getMandu().getBounds());
				Thread boom=new Thread(boomEffect);
				boom.start();
				SoundManager chop=new SoundManager(gameFrame,12);
			}
		}
	}
}
