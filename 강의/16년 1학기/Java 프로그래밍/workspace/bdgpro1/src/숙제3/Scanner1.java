package 숙제3;

import java.util.Scanner;

public class Scanner1 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int a;
		int b;
		System.out.println("서로 더할 2개의 정수를 띄어쓰기로 구분하여 입력하시오");
		a=scan.nextInt();
		b=scan.nextInt();
		System.out.println("두 수의 합은"+(a+b)+"입니다.");
	}

}
