package ¼÷Á¦7;

import java.util.Scanner;

public class qqw {
	public static void main(String[] args){
		/*
		int n = 1;
		do {
			System.out.print(n);
			if (n%5 == 0) break;
		} while(n++ < 5);




		Scanner console=new Scanner(System.in);
		int total=0, number;   
		while ((number = console.nextInt()) != -1) {
			total = total + number;
		}
		System.out.println(number);*/

		int[] score [];
		char [] names;
		int[] things;
		String animals[];
		float f = 42.0f;
		float[] f1 = new float[2];
		float[] f2 = new float[2];
		float[] f3 = f1;
		long x = 42;
		f1[0] = 42.0f;
		System.out.println( f1 == f3                    );
		
		int[] array = new int[] {2,3,5,7,11};
		byte[] byteArray = new byte[10];
		System.out.println(byteArray[1]);
		int[] a = new int[10];
		 int[] b = new int[10];
		 for (int i = 0; i < a.length; i++) a[i] = 2 * i - 1;
		 for (int i = 0; i < b.length; i++) b[i] = 2 * i + 1;
		 for (int i = 0; i < a.length; i++) a[i] = b[i] -1;
		 a = b;
		 for (int i=0; i<a.length; i++)
			 System.out.println(a[i]+" "+b[i]);
		 b = a;
		 for (int i=0; i<a.length; i++)
			 System.out.println(a[i]+" "+b[i]);
		 
		 char[] we = new char[10];
		 we[9] = 76;
		 System.out.println(we[9]);
	}
}
