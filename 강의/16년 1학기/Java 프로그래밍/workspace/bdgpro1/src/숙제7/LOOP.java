package ¼÷Á¦7;

import java.util.Scanner;

public class LOOP {

	public static void main(String[] args) {
		for (char cr = 'A'; cr < 'A' + 26; cr++) System.out.print(cr);
		int count=0;
		Scanner console = new Scanner(System.in);
		int sum = 0;
		while (count < 10) {
			int num = console.nextInt();
			sum = sum + num;
			count++;
		}
		System.out.println("Sum = " + sum);

	}

}
