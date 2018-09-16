import java.util.Scanner;

public class PrintBinary {
	public static void main (String[] args) {
		Scanner sin = new Scanner(System.in);
		System.out.print("������ ������ �Է��Ͻÿ�>>");
		byte result[] = new byte[64];	// 0 �Ǵ� 1�� �����ϱ� ���� byte �迭
		int num = sin.nextInt();
		int remainder, numberOfOne = 0, index=0;
		if (num <=0) {
			System.out.println("0���� Ŀ�� �մϴ�.");
			return;
		}
		while (num > 0) {
			remainder = num % 2; // 2�� ���� �������� 0 �Ǵ� 1�� ��
			result[index++] = (byte) remainder; // �������� �迭�� ����
			if (index == result.length) {
				System.out.println(result.length + "��Ʈ �̻��� ó���� �� �����ϴ�.");
				return;
			}
			if (remainder == 1)
				numberOfOne++;
			num = num /2;
		}
		for (--index; index >=0; index--) // �迭�� ����� �������� ���
			System.out.print(result[index]);
		System.out.println("\n1�� ������ " + numberOfOne);
	}
}
