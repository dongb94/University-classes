package ¼÷Á¦6;

import java.util.Scanner;

public class For3475 {
	public static void main(String [] arge){
		Scanner number=new Scanner(System.in);
		int n;
		n=number.nextInt();
		for(;n!=0;n/=10)
			System.out.println(n%10);
		
	}
}
