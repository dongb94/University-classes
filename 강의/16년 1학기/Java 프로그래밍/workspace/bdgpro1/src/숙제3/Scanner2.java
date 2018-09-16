package 숙제3;

import java.util.Scanner;

public class Scanner2 {

	public static void main(String[] as) {
		Scanner scan=new Scanner(System.in);
		int ar,br,cr;
		int ap,bp,cp;
		float PI=3.14f;
		System.out.println("각 피자의 직경(cm)을 띄어쓰기로 구분하여 순서대로 입력하시오.");
		ar=scan.nextInt();
		br=scan.nextInt();
		cr=scan.nextInt();
		System.out.println("각 피자의 가격(원)을 띄어쓰기로 구분하여 순서대로 입력하시오.");
		ap=scan.nextInt();
		bp=scan.nextInt();
		cp=scan.nextInt();
		System.out.println("A피자의 ㎠당 가격은"+(ap/(PI*ar*ar*0.25))+"원 입니다.");
		System.out.println("B피자의 ㎠당 가격은"+(bp/(PI*br*br*0.25))+"원 입니다.");
		System.out.println("C피자의 ㎠당 가격은"+(cp/(PI*cr*cr*0.25))+"원 입니다.");
		
	}
}
