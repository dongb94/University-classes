package stringµî_17;

public class Number_23 {

	public static void main(String[] args) {
		String inventor = "Charles Babbage";
		System.out.println(inventor.replace('a', 'e')); //
		System.out.println(inventor);

		String alphabet = "ABCDEFGHIJ";
		System.out.println("s = "+alphabet.substring(4, 5));
		System.out.println("s = "+alphabet.substring(4, 4));
		System.out.println("s = "+alphabet.substring(0, 4));
		System.out.println("s = "+alphabet.substring(4));
		String s1 = "Red";
		String s2 = "White";
		String s3 = s1;
		s1 = "Black";
		System.out.println(s1 + s2 + s3);
	}

}
