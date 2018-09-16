package chopsticks;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import character.PlayerManager;
import display.Game_stage;
import effect.BoomEffect;
import sound.SoundManager;
/**�������� �߻��ϴ� Ŭ����
 * 
 * @author ������
 * @see Chopstick
 *
 */
 
public class Shooting extends Chopstick implements Runnable {
	/** 1 Radian to degree*/
	private final double RADIAN=57.2958;
	/**�������� ��ġ����*/
	private Rectangle chopLocation;	//�������� ���� ��ġ
	/**������ ��ġ���� (�������� ���� ����)*/
	private Rectangle destination;//������ ��ġ ����
	/**������ */
	private JLabel chop=new JLabel();//�߻�Ǵ� ������
	/**�̹��� URL*/
	private URL imageURL;
	/**�������� �̹���*/
	private BufferedImage chopImage;//�������� �̹���
	/**�������� ��� ��ǥ x,y ����Ŀ��� �������� x��, y�� �ӵ�*/
	private int x,y;				//�������� �����ġ, setDirection() ȣ�� �� �������� �ӵ�
	/**�������� �ǰ� ���� �����ġ
	 * {{x,y},{x,y}}*/
	private int attackPoint[][]=new int [2][2]; // �ǰ� ���� �����ġ {{x,y},{x,y}}
	/**������ ��ġ�� �ҷ��� �÷��̾� �޴���*/
	private PlayerManager player;
	/** ������ ����Ǵ� �����Ӱ� �������� �����ǥ (x,y)�� �ʱ�ȭ
	 * 
	 * @param game ���� �������� ��ü
	 * @param x ��� x��ǥ
	 * @param y ��� y��ǥ
	 */
	public Shooting(Game_stage game, int x, int y)
	{//�����ǥ x,y:int , ������ ��ġ mandu:Rectangle
		super(game);
		destination=game.player.getMandu().getBounds();
		this.x=x;
		this.y=y;
		chop.setBounds(x, y, size, size);
		player=game.player;
	}
	
	/** ������ ����Ǵ� �����Ӱ� �������� �����ǥ (x,y), �������� �߻��� �������� �ʱ�ȭ
	 * r�� �������� �߻��� ����
	 * 
	 * @param game ���� �������� ��ü
	 * @param x ��� x��ǥ
	 * @param y ��� y��ǥ
	 * @param destination ������
	 */
	public Shooting(Game_stage game, int x, int y, Rectangle destination)
	{
		super(game);
		this.destination=destination;
		this.x=x;
		this.y=y;
		chop.setBounds(x, y, size, size);
		player=game.player;
	}
	/** ������ ����Ǵ� �����Ӱ� �������� �����ǥ (x,y), �������� �������η� �ʱ�ȭ
	 * 
	 * tracking�� true�̸� ����
	 * @param game ���� �������� ��ü
	 * @param x ��� x��ǥ
	 * @param y ��� y��ǥ
	 * @param tracking ���� ��� ����
	 */
	public Shooting(Game_stage game, int x, int y, boolean tracking)
	{
		super(game,tracking);
		destination=game.player.getMandu().getBounds();
		this.x=x;
		this.y=y;
		chop.setBounds(x, y, size, size);
		player=game.player;
	}
	/** run�޼ҵ� 
	 * �������� �ൿ�� ���������� ������
	 * */
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
			//ȭ���� ���ù����� ����� ������ ����
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
				attackDicision();	//�ǰ� �Ǻ�
				if(player.getLife()<1){
					break;
				}//life�� 0�Ͻ� break
				Thread.sleep(100);
				chopLocation=chop.getBounds();
			}
			gameFrame.remove(chop);
		} catch (InterruptedException e){
			return;
		}
	}
	/**�������� ���� ���� ����*/
	private void setDirection1()	// ���ʹ��� ���� (x,y�� ��� 0�̵Ǵ°�� ó��)
	{			
		x=(int) (destination.getCenterX()-x-size/2);
		y=(int) (destination.getCenterY()-y-size/2);
		double r=Math.sqrt(x*x+y*y);		//�밢���� ����
		double degree;						// �������� ����
		if(y>0)
			degree=Math.acos(-x/r);
		else
			degree=Math.acos(x/r)+3.14;
		x=(int) (speed*x/r);
		y=(int) (speed*y/r);
		setImage(degree*RADIAN);
		setAttackPoint(degree);
	}
	/**��������� ������ �������� �߰� ���� ����*/
	private void setDirection2()	// ������ �߰� ���� ����
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
	/**�������� ���⿡ ���� �̹����� �����ϴ� �޼ҵ�
	 * 
	 * @param degree �������� ���� ����
	 */
	private void setImage(double degree)
	{
		try 
		{
			if(degree%360<12)
				chopImage=ImageIO.read(imageURL=getClass().getClassLoader().getResource("chopstick.png"));
			else if(degree%360<37)
				chopImage=ImageIO.read(imageURL=getClass().getClassLoader().getResource("chopstick22.png"));
			else if(degree%360<57)
				chopImage=ImageIO.read(imageURL=getClass().getClassLoader().getResource("chopstick45.png"));
			else if(degree%360<79)
				chopImage=ImageIO.read(imageURL=getClass().getClassLoader().getResource("chopstick67.png"));
			else if(degree%360<102)
				chopImage=ImageIO.read(imageURL=getClass().getClassLoader().getResource("chopstick90.png"));
			else if(degree%360<124)
				chopImage=ImageIO.read(imageURL=getClass().getClassLoader().getResource("chopstick112.png"));
			else if(degree%360<147)
				chopImage=ImageIO.read(imageURL=getClass().getClassLoader().getResource("chopstick135.png"));
			else if(degree%360<169)
				chopImage=ImageIO.read(imageURL=getClass().getClassLoader().getResource("chopstick157.png"));
			else if(degree%360<195)
				chopImage=ImageIO.read(imageURL=getClass().getClassLoader().getResource("chopstick180.png"));
			else if(degree%360<220)
				chopImage=ImageIO.read(imageURL=getClass().getClassLoader().getResource("chopstick202.png"));
			else if(degree%360<235)
				chopImage=ImageIO.read(imageURL=getClass().getClassLoader().getResource("chopstick225.png"));
			else if(degree%360<259)
				chopImage=ImageIO.read(imageURL=getClass().getClassLoader().getResource("chopstick247.png"));
			else if(degree%360<282)
				chopImage=ImageIO.read(imageURL=getClass().getClassLoader().getResource("chopstick270.png"));
			else if(degree%360<304)
				chopImage=ImageIO.read(imageURL=getClass().getClassLoader().getResource("chopstick292.png"));
			else if(degree%360<327)
				chopImage=ImageIO.read(imageURL=getClass().getClassLoader().getResource("chopstick315.png"));
			else if(degree%360<349)
				chopImage=ImageIO.read(imageURL=getClass().getClassLoader().getResource("chopstick337.png"));
			else
				chopImage=ImageIO.read(imageURL=getClass().getClassLoader().getResource("chopstick.png"));
		} catch (IOException e) {
			System.err.println("�̹��� �ε� ����");
		}
	}
	/**�ǰ� �Ǻ����� ����
	 * 
	 * @param degree ������ ����
	 */
	private void setAttackPoint(double degree)
	{
		attackPoint[0][0]=(int) (chopLocation.getCenterX()+size*Math.cos(degree)/2);
		attackPoint[0][1]=(int) (chopLocation.getCenterY()+size*Math.sin(degree)/2);
		attackPoint[1][0]=(int) (chopLocation.getCenterX()-size*Math.cos(degree)/2);
		attackPoint[1][1]=(int) (chopLocation.getCenterY()-size*Math.sin(degree)/2);
	}
	/**�������� ������ �ǰ� ����*/
	private void attackDicision()
	{
		for(int i=0; i<2; i++)
		{
			int x=(int) (attackPoint[i][0]-player.getMandu().getX()-player.getMandu().getWidth()/2);
			int y=(int) (attackPoint[i][1]-player.getMandu().getY()-player.getMandu().getHeight()/2-3);
			double r=Math.sqrt(x*x+y*y)+2;
			if(r<player.getMandu().getWidth()/2)
			{
				chop.setLocation(-500, -500);
				player.downLife();
				JLabel boomL=new JLabel();
				boomL.setBounds(player.getMandu().getBounds());
				BoomEffect boomEffect=new BoomEffect(gameFrame,boomL);
				Thread boom=new Thread(boomEffect);
				boom.start();
				new SoundManager(gameFrame,12);
				return;
			}
		}
	}
}
