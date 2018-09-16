import java.util.Scanner;
public class Rectangle {
	public static void main (String args[])  {
		Scanner sin = new Scanner(System.in);
		System.out.print("점 (x,y)의 좌표를 입력하시오>>");
		int x = sin.nextInt();
		int y = sin.nextInt();
		if (x >= 50 && x <=100 && y >= 50 && y <= 100) // 점이 사각형 내에 있는 경우
			System.out.println("사각형 안에 점이 있습니다.");
		else
			System.out.println("사각형 안에 점이 없습니다.");
	}
}
