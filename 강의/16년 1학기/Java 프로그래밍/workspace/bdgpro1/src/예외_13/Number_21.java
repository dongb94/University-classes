package ¿¹¿Ü_13;

public class Number_21 {
	public static void main(String[] args) {
		try {
			method();
		} catch (Exception e) {
			System.out.print("A");
		}
	}
	static void method() {
		try {
			wrench();
			System.out.print("B");
		} catch (ArithmeticException e) {
			System.out.print("C");
		} finally {
			System.out.print("D");
		}
		System.out.print("E");
	}

	static void wrench() {
		throw new NullPointerException();
	}
}
