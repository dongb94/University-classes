package ¼÷Á¦4;
public class Operator2 {
	public static void main(String[] args) {
		int x = 0;
		int y = 10;
		for (int c = 0; c < 5; c++) {
			if (y-- > 7 || (++x) > 2)
				y--;
		}
		System.out.println(x + " " + y);
	}
}