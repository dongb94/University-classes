package ����3;

import java.util.Scanner;

public class Scanner2 {

	public static void main(String[] as) {
		Scanner scan=new Scanner(System.in);
		int ar,br,cr;
		int ap,bp,cp;
		float PI=3.14f;
		System.out.println("�� ������ ����(cm)�� ����� �����Ͽ� ������� �Է��Ͻÿ�.");
		ar=scan.nextInt();
		br=scan.nextInt();
		cr=scan.nextInt();
		System.out.println("�� ������ ����(��)�� ����� �����Ͽ� ������� �Է��Ͻÿ�.");
		ap=scan.nextInt();
		bp=scan.nextInt();
		cp=scan.nextInt();
		System.out.println("A������ ���� ������"+(ap/(PI*ar*ar*0.25))+"�� �Դϴ�.");
		System.out.println("B������ ���� ������"+(bp/(PI*br*br*0.25))+"�� �Դϴ�.");
		System.out.println("C������ ���� ������"+(cp/(PI*cr*cr*0.25))+"�� �Դϴ�.");
		
	}
}
