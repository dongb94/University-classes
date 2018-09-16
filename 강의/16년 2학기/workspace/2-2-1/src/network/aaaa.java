package network;
public class aaaa {
	public static void main(String[] args) {
		Integer integer = new Integer(100);
		Wait wait = new Wait(integer);
		Notify notify = new Notify(integer);
		Thread t1 = new Thread(wait, "WAIT");
		Thread t2 = new Thread(notify, "NOTIFY");
		t1.start();
		t2.start();
	}
}
class Wait implements Runnable {
	private Object lockObject;
	public Wait(Object obj){
		lockObject = obj;
	}
	public void run() {
		synchronized (lockObject) { 
			try {
				System.out.println("Sun() 1");
				lockObject.wait();
				System.out.println("Sun() 2");
			} catch (InterruptedException e) {
				System.out.println("Sun() 3");
			}
		}
	}
}
class Notify implements Runnable {
	private Object lockObject;
	public Notify(Object obj){
		lockObject = obj;
	}
	public void run() {
		synchronized (lockObject) {
			System.out.println("Moon() A");
			lockObject.notify();
			System.out.println("Moon() B");
		}
	}
}

