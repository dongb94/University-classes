package ¿¹¿Ü_13;

public class Number_22 {
	public static void main(String[] args) {
		showNumber();
		System.out.println("end of main()");
	}
	static void showNumber() {
		int count = 0;
		try {
			while(true) {
				if(++count > 3) return;
				System.out.println( (char)(64+count) );
			}
		} catch(Exception e) {
		} finally {
			System.out.println("end of showNumber()");
		}
	}
}
