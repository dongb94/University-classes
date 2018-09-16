import java.util.Scanner;
public class Trangle {
	public static void main (String args[])  {
		Scanner sin = new Scanner(System.in);
		System.out.println("정수 3개를 입력하시오>>");
		int l1 = sin.nextInt();
		int l2 = sin.nextInt();
		int l3 = sin.nextInt();
		if ((l1+12)<l3 || (l1+l3)<l2 ||(l2+l3)<l1) // 두변의 합이 다른 한변보다 작은 경우
			System.out.println("삼각형 세변의 길이가 될 수 없습니다.");
		else
			System.out.println("삼각형 세변의 길이가 될 수 있습니다.");
	}
}
