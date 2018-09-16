package programing_2;
import java.util.*;

public class Two {
	static boolean sign;
	static void print(String a){
		System.out.print(a);
	}
	static void print(int a){
		System.out.print(a);
	}
	static void print(int[] a){
		for(int i:a) 
			print(i);
		System.out.println();
	}
//1의보수 출력
	static void printC(int[] a){
		for(int i=0; i<a.length; i++)
			print(a[i]==0?1:0);
		System.out.println();
	}
//2진수 출력
	static void printB(int[] a){
		int start=0;
		if (sign==false)
			print("-");

		for(int i=1;i<a.length;i++){
			if(a[i]==0&&start==0)
				continue;
			else start++;
			print(a[i]);
		}
		System.out.println();
	}
//16진수 출력
	static void printX(int[] a){
		int start=0;
		if (sign==false){
			print("-");
		}
		for(int i=0; i<a.length;i+=4){
			int x=a[i]*8+a[i+1]*4+a[i+2]*2+a[i+3];
			if(x==0&&start==0)
				continue;
			else start++;
			if(x<10)
				print(x);
			else
				switch(x){
				case 10 : print("A");
				break;
				case 11 : print("B");
				break;
				case 12 : print("C");
				break;
				case 13 : print("D");
				break;
				case 14 : print("E");
				break;
				case 15 : print("F");
				break;
				}
		}
		System.out.println();
	}
//부호반전
	static int change(int a){
		if(a<0){
			a=-a;
			sign=false;
		}
		else {
			a=-a;
			sign=true;
		}
		return a;
	}
//비트화
	static void set(int a,int[] b){
		for(int i=0;i<32;i++){
			if(a>0)
				b[31-i]=a%2;
			else
				b[31-i]=-a%2;
			a=a>>>1;
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] A = new int[32], B=new int[32];
		int number, complement;
		print("십진수값 : ");
		number=sc.nextInt();
		complement=change(number);
		set(complement,A);
		set(number,B);
		print("이진수값 :\t");
		printB(number>0?B:A);
		print("16진수값 :\t");
		printX(number>0?B:A);
		print("비트값 :\t");
		print(B);
		print("1의보수값 :");
		printC(B);
		print("2의보수값 :");
		print(A);
	}
}