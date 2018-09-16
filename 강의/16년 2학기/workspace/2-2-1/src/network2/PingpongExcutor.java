package network2;

import java.util.concurrent.*;

public class PingpongExcutor{
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(2);
		Future ft1=es.submit(new PingPong("ping",33));
		Future ft2=es.submit(new PingPong("pong",100));
		System.out.println(ft1.get());
		System.out.println(ft2.get());
		es.shutdown();
	}
}

class PingPong implements Callable<String>  {
	String 	word;
	int	delay;
	PingPong(String whatToSay, int delayTime) {
		word = whatToSay;
		delay = delayTime;
	}
	public String call() throws Exception {
		try {
			for (int i=0;i<10;i++) {
				System.out.println(word + " ");
				Thread.sleep(delay);	
			}
		} catch (InterruptedException e) {
			return "PingPong 프로그램을 끝냅니다.";	// end this thread
		}
		return "PingPong 프로그램을 끝냅니다.";
	}
}