package ¼÷Á¦5;

public class NoIfOutput {
	public static void main(String [] args){
		int answer = 'a';
		if (answer == 'Y'); else System.out.println(" Hello");
		int  i = 20;
		if (i > 45) System.out.print ('A'); System.out.print ('E'); 
		if (i > 15) { System.out.print('B'); if (i < 55) System.out.print('C');
		else System.out.print('D');
		}
		int B = 3;
		switch (B) {
			case 1: System.out.println("One");
			case 2: System.out.println("Two");
			case 3: System.out.println("Three");
			case 4: System.out.println("Four");
			case 5: System.out.println("Five");
			default: System.out.println("Last");
		}
		final short x = 2;
		for (int a = 0; a < 4; a++) {
			switch (a) {
				case x: System.out.print("1");
				default: System.out.print("def");
				case x - 1: System.out.print("2"); break;
				case x - 2: 	System.out.print("3");
			}
		}
	}
}
