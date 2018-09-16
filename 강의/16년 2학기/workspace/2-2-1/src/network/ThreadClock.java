package network;

class Time {
	static int Second=0;
	static int Minute=0;
	static int Hour=0;
}

class Switch{
	private boolean inUse = true;
	public synchronized void on() {
		while(inUse) {
			try{
				wait();
			}
			catch(InterruptedException e){};
		}
		inUse = true;
	}
	public synchronized void off() {
		inUse = false;
		notify();
	}
}

class Second implements Runnable {
	private Switch swtch;
	public Second(Switch swtch){
		this.swtch = swtch;
	}
	public void run() {
		while(true) {
			try{
				Thread.sleep(1000);
			}catch (InterruptedException e){}
			if(Time.Second == 59){
				swtch.off();
				Time.Second = 0;
			}
			else {
				Time.Second ++;
				System.out.println(Time.Hour+":"+Time.Minute+":"+Time.Second);
			}
		}
	}
}
class Minute implements Runnable {
	private Switch swtch1;
	private Switch swtch2;
	public Minute(Switch swtch1, Switch swtch2){
		this.swtch1 = swtch1;
		this.swtch2 = swtch2;
	}
	public void run() {
		while(true) {
			swtch1.on();
			if(Time.Minute ==59){
				swtch2.off();
				Time.Minute = 0;
			}
			else {
				Time.Minute ++;
				System.out.println(Time.Hour+":"+Time.Minute+":"+Time.Second);
			}
		}
	}
}
class Hour implements Runnable {
	private Switch swtch;
	public Hour(Switch swtch){
		this.swtch = swtch;
	}
	public void run() {
		while(true) {
			swtch.on();
			Time.Hour ++;
			System.out.println(Time.Hour+":"+Time.Minute+":"+Time.Second);
		}
	}
}
public class ThreadClock {

	public static void main(String[] args) {
		Switch switch1=new Switch();
		Switch switch2=new Switch();
		Second second = new Second(switch1);
		Thread t1 = new Thread(second);
		Minute minute = new Minute(switch1,switch2);
		Thread t2 = new Thread(minute);
		Hour hour = new Hour(switch2);
		Thread t3 = new Thread(hour);
		t1.start();
		t2.start();
		t3.start();
	}

}
