package chopsticks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;

import chopsticks.Shooting;
import display.Game_stage;
/**6���⿡�� ���ù߻� ����*/
public class Pattern2 {
	/**6���⿡�� ���ù߻� ����*/
	public Pattern2(Game_stage game){
		ExecutorService es = Executors.newFixedThreadPool(6);
		for(int i=0; i<6; i++)
		{
			Shooting shot=new Shooting(game,(int)(425+600*Math.cos(45*i)),(int)(425+600*Math.sin(45*i)));
			es.execute(shot);
		}
		es.shutdown();
	}
}