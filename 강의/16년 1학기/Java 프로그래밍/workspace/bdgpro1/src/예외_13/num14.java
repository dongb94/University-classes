package ¿¹¿Ü_13;

public class num14 {
	public static void main(String[] args) {
		try {
			System.out.println("Start of try block");
			int k = 0;
			int j = 2 / k;
			System.out.println("end of try block");
		} catch (RuntimeException e) {
			System.out.println("catch block");
		} finally {
			System.out.println("finally block");
		}
		System.out.println("Program all done");
	}
}
