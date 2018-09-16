package EE;

public class Example3{
	public static void main(String args[]){
		String s=null;
		for(int i=0; i<10; i++){
			s=new String("hello"+i);
			System.out.println(s);
		}
	}
}