package programing_2;

import java.util.Scanner;

public class one{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		double number, binary, decimal=0, b1=0, b2=0;
		String hexadecimal = "";
		/* 
		number= 십진수 입력값
		binary= 이진수 표현
		decimal = 십진수의 소수부분
		b1= 이진수의 정수부분
		b2= 이진수의 소수부분
		hexadecimal= 16진수 표현
		 */
		double D=1,i=1;
		System.out.print("십진수 값 : ");
		number=sc.nextDouble();

		int integer=(int)number; // integer = 십진수의 정수부분

		for(decimal = number-integer ; i!=0 ; D /= 2, i /= 10)
		{
			if ((decimal>0) && (decimal-D>=0))
			{
				b2 += i;
				decimal -= D;
			}
			if ((decimal<0) && (decimal+D<=0))
			{
				b2 -= i;
				decimal += D;
			}
		}

		for(i=1 ; integer!=0 ; i*=10)
		{
			b1 += (integer%2)*i;
			integer /= 2;
		}

		binary = b1 + b2; //TODO 2진수 표현 완성

		String[] h=new String[20];
		for(int x=0; b1>=1; b1/=10000, x++){
			int a= (int)(b1%10000);

			switch(a){
			case 0 : h[x]="0";
			break;
			case 1 : h[x]="1";
			break;
			case 10 : h[x]="2";
			break;
			case 11 : h[x]="3";
			break;
			case 100 : h[x]="4";
			break;
			case 101 : h[x]="5";
			break;
			case 110 : h[x]="6";
			break;
			case 111 : h[x]="7";
			break;
			case 1000 : h[x]="8";
			break;
			case 1001 : h[x]="9";
			break;
			case 1010 : h[x]="A";
			break;
			case 1011 : h[x]="B";
			break;
			case 1100 : h[x]="C";
			break;
			case 1101 : h[x]="D";
			break;
			case 1110 : h[x]="E";
			break;
			case 1111 : h[x]="F";
			break;
			}
		}
		for(int x=1; x<=h.length; x++){
			if(h[h.length-x]!=null)
				hexadecimal+=h[h.length-x];
		}
		hexadecimal+=".";
		h=new String[20];
		for(int x=0; b2>0; b2=(b2-(int)b2), x++){
			b2*=10000;
			int a=(int)b2;
			switch(a){
			case 0 : h[x]="0";
			break;
			case 1 : h[x]="1";
			break;
			case 10 : h[x]="2";
			break;
			case 11 : h[x]="3";
			break;
			case 100 : h[x]="4";
			break;
			case 101 : h[x]="5";
			break;
			case 110 : h[x]="6";
			break;
			case 111 : h[x]="7";
			break;
			case 1000 : h[x]="8";
			break;
			case 1001 : h[x]="9";
			break;
			case 1010 : h[x]="A";
			break;
			case 1011 : h[x]="B";
			break;
			case 1100 : h[x]="C";
			break;
			case 1101 : h[x]="D";
			break;
			case 1110 : h[x]="E";
			break;
			case 1111 : h[x]="F";
			break;
			}
		}
		for(int x=0; x<h.length; x++){
			if(h[x]!=null)
				hexadecimal+=h[x];
		}
		
		
		System.out.println(number+"의 2진수값은 "+binary+"입니다.");
		System.out.println(number+"의 16진수값은 "+hexadecimal+"입니다.");

	}
}