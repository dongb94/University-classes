package ¼÷Á¦4;
public class LogicalOperator {
	public static void main(String[] args){
		boolean b1 = true;
		boolean b2 = false;
		boolean b3 = true;
		if(b1&b2|b2|b3&b2)
			System.out.print("C++" + " ");
		if(b1&b2|b2&b3|b2|b1)
			System.out.println("Java");
		
		boolean qwer= 3+2<2;
		//27~44¹ø ±îÁö
		System.out.println(7 % 4 + 3 - 2 / 6 * 'Z');
		System.out.println(5.0 / 3 + 3/3 );
		System.out.println(53 % 21 < 45 / 18);
		System.out.println((4 < 6) || true && false || false && (2 > 3));
		System.out.println(27/13 + 4.0);
		System.out.println(42.7 % 3 + 18);
		System.out.println(2.0 + 'a');
		System.out.println(2 + 'a');
		System.out.println(3 + 4.5 * 2 + 27 / 8);
		System.out.println(true || false && 3 < 4 || !(5 == 7));
		System.out.println(true || (3 < 5 && 6 >= 2));
		System.out.println(23 / 5 + 23 / 5.0);
		System.out.println('a' + 'b');
		System.out.println('a' / 'b');
		System.out.println((double)'a' / 'b');
		
		
	}
}