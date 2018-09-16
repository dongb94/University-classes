package display;

import java.awt.*;
import javax.swing.*;
import character.*;
import chopsticks.Patterns;
import score.ScorePane;
import sound.SoundManager;

public class Game_stage extends JFrame{
	public PlayerManager player;
	Game_stage(){
		setTitle("����");//�������� Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1500,900);//������ ũ�⼳��
		setLayout(null);//���̾ƿ�����

		ImageIcon dishIcon = new ImageIcon("image/background.png");
		JLabel dish = new JLabel(dishIcon);
		dish.setBounds(-335, 60, 1500, 900);
		setContentPane(dish);
		Container contentpane =getContentPane();//����Ʈ ���� �˾Ƴ���
		contentpane.setLayout(null);//���̾ƿ�����

		ScorePane scorepane=new ScorePane(this);
		Thread score=new Thread(scorepane);
		score.setPriority(10);
		
		ImageIcon stage = new ImageIcon("image/stage.png");
		JLabel stage1 = new JLabel(stage);
		stage1.setBounds(0, 0, 1500, 900);
		contentpane.add(stage1);
		
		MyKeyListener listener = new MyKeyListener();
	    addKeyListener(listener);
	    
		Patterns p=new Patterns(this);
		
	    
	    player = new PlayerManager(1);
	    contentpane.add(player.getMandu());
	    
	    new SoundManager(this,4);
		
		setVisible(true);//�������� ȭ�鿡 ���
		
		score.start();
		for(int i=0; i<20&&player.getLife()!=0; i++){
			p.pattern1();
			if(i%5==4) p.pattern2();
			p.pattern3();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    new SoundManager(this,3);
	}
	public static void main(String[] args) {
		Game_stage game =  new Game_stage();
	}
}