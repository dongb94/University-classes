import java.util.Scanner;
public class Trangle {
	public static void main (String args[])  {
		Scanner sin = new Scanner(System.in);
		System.out.println("���� 3���� �Է��Ͻÿ�>>");
		int l1 = sin.nextInt();
		int l2 = sin.nextInt();
		int l3 = sin.nextInt();
		if ((l1+12)<l3 || (l1+l3)<l2 ||(l2+l3)<l1) // �κ��� ���� �ٸ� �Ѻ����� ���� ���
			System.out.println("�ﰢ�� ������ ���̰� �� �� �����ϴ�.");
		else
			System.out.println("�ﰢ�� ������ ���̰� �� �� �ֽ��ϴ�.");
	}
}
