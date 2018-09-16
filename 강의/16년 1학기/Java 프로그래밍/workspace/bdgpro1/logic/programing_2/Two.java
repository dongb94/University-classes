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
//1�Ǻ��� ���
	static void printC(int[] a){
		for(int i=0; i<a.length; i++)
			print(a[i]==0?1:0);
		System.out.println();
	}
//2���� ���
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
//16���� ���
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
//��ȣ����
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
//��Ʈȭ
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
		print("�������� : ");
		number=sc.nextInt();
		complement=change(number);
		set(complement,A);
		set(number,B);
		print("�������� :\t");
		printB(number>0?B:A);
		print("16������ :\t");
		printX(number>0?B:A);
		print("��Ʈ�� :\t");
		print(B);
		print("1�Ǻ����� :");
		printC(B);
		print("2�Ǻ����� :");
		print(A);
	}
}