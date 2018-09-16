package network2;

public class WaitNotifyAverage {
	public static void main(String[] args) {
		int numbers[]={1,2,3,4,5};
		Average ave=new Average();
		Notify notify=new Notify(numbers,ave);
		Wait wait=new Wait(ave);
		Thread thread1=new Thread(notify);
		Thread thread2=new Thread(wait);
		try{
			thread2.start();
			Thread.sleep(1000);
			thread1.start();
		}catch(InterruptedException ex){
			
		}
	}
}
class Average{
	private int average;
	public void setAverage(int n){
		average=n;
	}
	public int getAverage(){
		return average;
	}
}
class Wait implements Runnable {
	Average ave;
	Wait(Average a){
		ave=a;
	}
	public void run(){
		synchronized (ave) {
			try{
				ave.wait();
				System.out.println(ave.getAverage());
			}catch(InterruptedException e){
				System.err.println();
			}
		}	
	}
}
class Notify implements Runnable{
	Average ave;
	int[] numbers;
	Notify(int[] numbers, Average a){
		this.numbers=numbers;
		ave=a;
	}
	public void run() {
		synchronized (ave) {
			int sum=0;
			for(int i=0; i<numbers.length; i++){
				sum+=numbers[i];
			}
			sum/=numbers.length;
			ave.setAverage(sum);
			ave.notify();
		}	
	}
}