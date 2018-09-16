import java.util.Scanner;
public class system {
	public static void main(String [] args){

		char y=12,z=1000;
		boolean x='A'<'['&&'['<'a';
		boolean t=y<z;
		Scanner a=new Scanner(System.in);
		
		System.out.println(x+""+t);
		for(char b='A'; b<'a';b++){
			System.out.print(b);
		}
		System.out.println(4+" "+(2*y+5-y));
		
		int q=1, p=2;
		q=q&p;
		p=q^p;
		System.out.println(q+" "+p);
		
		for(int i=1; i<10; i++){
			for (int j=1; j<10; j++){
				System.out.print((i^j)+"\t");
			}
			System.out.println();
		}
	}
}
