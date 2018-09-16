package character;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import sound.SoundManager;

/**Class Description of KeyListener*/
public class MyKeyListener extends PlayerManager implements KeyListener {
	public static boolean sound=false;
	static int counter=5;
	final int MOVE = 10;
	static SoundManager sm;
    public void keyPressed(KeyEvent e) {
       int keyCode = e.getKeyCode(); // 입력된 키코드 알아내기
 
       switch (keyCode) {
       case KeyEvent.VK_UP:
          mandu.setLocation(mandu.getX(), mandu.getY() - MOVE);
          break;
       case KeyEvent.VK_DOWN:
          mandu.setLocation(mandu.getX(), mandu.getY() + MOVE);
          break;
       case KeyEvent.VK_LEFT:
          mandu.setLocation(mandu.getX() - MOVE, mandu.getY());
          break;
       case KeyEvent.VK_RIGHT:
          mandu.setLocation(mandu.getX() + MOVE, mandu.getY());
          break;
       }
       if(sound==false){
    	   sm=null;
    	   sm=new SoundManager(mandu,11);
       }
       else counter--;
       if(counter<0)
       {
    	   counter=5;
    	   sound=false;
       }
    }

    @Override
    public void keyTyped(KeyEvent e) {
       // TODO Auto-generated method stub
    int keyCode = e.getKeyCode(); // 입력된 키코드 알아내기
       
       switch (keyCode) {
       case KeyEvent.VK_UP:
 
          break;
       case KeyEvent.VK_DOWN:
          break;
       case KeyEvent.VK_LEFT:
          break;
       case KeyEvent.VK_RIGHT:
          break;
       }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       // TODO Auto-generated method stub
        int keyCode = e.getKeyCode(); // 입력된 키코드 알아내기
        
        switch (keyCode) {
        case KeyEvent.VK_UP:
  
           break;
        case KeyEvent.VK_DOWN:
           break;
        case KeyEvent.VK_LEFT:
           break;
        case KeyEvent.VK_RIGHT:
           break;
        }
    }
 }