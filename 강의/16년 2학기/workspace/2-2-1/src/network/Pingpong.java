package network;

class PingPong extends Thread {
	String 	word;
	int	delay;
	PingPong(String whatToSay, int delayTime) {
		word = whatToSay;
		delay = delayTime;
	}
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
	public static void main(String[] args){
		new PingPong("Ping", 33).start();	// 1/30 second
		new PingPong("Pong", 100).start(); 	// 1/10 second
	}
}