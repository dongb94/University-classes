package ¼÷Á¦8;

public class MethodeTest {
	static int sub( int a, int b)       { 
		return a - b; 
	}
	static double sub(double a, double b){
		return a - b;
	} 
	public static void main(String[] args){
		System.out.println(sub(2.0,1));
		System.out.println(sub(2,1));
		System.out.println(sub(2,1.0));
		System.out.println(sub(1.0,2.0));
	}
}
