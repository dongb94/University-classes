import java.util.Scanner;
public class Rectangle {
	public static void main (String args[])  {
		Scanner sin = new Scanner(System.in);
		System.out.print("�� (x,y)�� ��ǥ�� �Է��Ͻÿ�>>");
		int x = sin.nextInt();
		int y = sin.nextInt();
		if (x >= 50 && x <=100 && y >= 50 && y <= 100) // ���� �簢�� ���� �ִ� ���
			System.out.println("�簢�� �ȿ� ���� �ֽ��ϴ�.");
		else
			System.out.println("�簢�� �ȿ� ���� �����ϴ�.");
	}
}
