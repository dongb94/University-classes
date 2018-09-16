import java.util.Scanner;

public class Kawibawibo {
	public static void main (String[] args) {
		Scanner sin = new Scanner(System.in);
		final String s[] = {"����", "����", "��"};
		int userChoice, computerChoice;
		while (true) {
			System.out.print("����(1), ����(2), ��(3), ������(4) �� �ϳ��� �����ϼ���>>");
			userChoice = sin.nextInt();
			if (userChoice == 4)
				break; // ���� ������
			computerChoice = (int) Math.round(Math.random() * 2 + 1); // 1���� 3������ ��
			if (userChoice < 1 || userChoice > 3) { 
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			} else {
				System.out.println("��ǻ�ʹ� " + s[computerChoice-1] + "�� �½��ϴ�.");
				int diff = userChoice - computerChoice; 
				switch (diff) {
				case 0: // ���� ���� �� ���
					System.out.println("�����ϴ�.");
					break;
				case -1: // ����ڰ� ����, ��ǻ�Ͱ� ���� �Ǵ� ����ڰ� ����, ��ǻ�Ͱ� ��
				case 2:	// ����ڰ� ��, ��ǻ�Ͱ� ����
					System.out.println("����� �����ϴ�.");
					break;
				case 1: // ����ڰ� ����, ��ǻ�Ͱ� ���� �Ǵ� ����ڰ� ��, ��ǻ�Ͱ� ����
				case -2: // ����ڰ� ����, ��ǻ�Ͱ� ��
					System.out.println("����� �̰���ϴ�.");
				}
			}
		}
	}
}
