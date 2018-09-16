package network;
public class Caller {
    
	public static void getAverage(Thread t,double ave){
		System.out.println(t.getName()+"ÀÇ Æò±Õ : "+ave);
	}
	
	public static void main(String[] args) {
	 Callee[] callee=new Callee[50];
	 
	 Thread[] thread=new Thread[50];
	 for(int i=0; i<callee.length; i++){
		 callee[i]=new Callee();
		 thread[i]=new Thread(callee[i],(i+1)+"¹øÂ° Thread");
		 thread[i].start();
	 }

	}

}