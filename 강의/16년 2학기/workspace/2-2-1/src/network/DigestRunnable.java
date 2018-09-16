package network;
import java.io.*;
import java.security.*;
import javax.xml.bind.*; // for DatatypeConverter; requires Java 6 or JAXB 1.0


public class DigestRunnable implements Runnable {
	String 	word;
	int	delay;
	DigestRunnable(String whatToSay, int delayTime) {
		word = whatToSay;
		delay = delayTime;
	}
  @Override
	public void run(){
		try {
			for(;;) {
				System.out.println(word + " ");
				sleep(delay); 
			}
		} catch (InterruptedException e) {
			return;	// end this thread
		}
	}
  
	private void sleep(int delay2) throws InterruptedException {
	
		Thread.sleep(delay2);
	
}
	public static void main(String[] args){
		new PingPong("Ping", 33).start();	// 1/30 second
		new PingPong("Pong", 100).start(); 	// 1/10 second
	}
}
