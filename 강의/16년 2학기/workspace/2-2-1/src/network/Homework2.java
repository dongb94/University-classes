package network;

//쓰레드를 실행시켜보는 문제

class Hello implements Runnable {

	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("Hello Software");
				Thread.sleep(3000);
			}
		} catch (InterruptedException e) {
			System.out.println("err");
			return;
		}
	}

}

class PrintRandom implements Runnable {
	public void run() {
		try {
			for (int i = 0; i < 6; i++) {
				System.out.println("변동건"+Math.random());
				Thread.sleep(5000);
			}
		} catch (InterruptedException e) {
			System.out.println("err");
			return;
		}
	}
}

public class Homework2 {

	public static void main(String[] args) {
		Hello H=new Hello();
		PrintRandom P=new PrintRandom();
		Thread t1=new Thread(H);
		Thread t2=new Thread(P);
		t1.start();
		t2.start();
		
	}


}
