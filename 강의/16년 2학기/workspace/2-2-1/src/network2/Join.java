package network2;

public class Join {
	public static void main(String[] args) {
		double[] random=new double[1000];
		for(int i=0;i<random.length;i++)
			random[i]=Math.random();
		Joined joined=new Joined(random);
		Thread t=new Thread(joined);
		t.start();
		try{
			t.join();
			System.out.println(joined.getMax());
			System.out.println(joined.getMin());
		}catch(InterruptedException ex){
			System.out.println("interrupt");
		}
	}
}

class Joined implements Runnable{
	double[] random;
	double max,min;
	Joined(double[] d){
		random=d;
	}
	public void run(){
		for(int i=0;i<random.length;i++){
			for(int j=0;j<i;j++){
				if(random[j]>random[i]){
					double temp=random[i];
					random[i]=random[j];
					random[j]=temp;
				}
			}
		}
		max=random[random.length-1];
		min=random[0];
	}
	public double getMax(){
		return max;
	}
	public double getMin(){
		return min;
	}
}