package network;
public class Callee implements Runnable {
	
	public void run(){
		double[] random=new double[1000];
		double average=0;
		
		for(int i=0; i<random.length; i++){
			random[i]=Math.random();
			average+=random[i];
		}
		
		average/=random.length;
		
		Thread t=Thread.currentThread();
		Caller.getAverage(t,average);
	}
}