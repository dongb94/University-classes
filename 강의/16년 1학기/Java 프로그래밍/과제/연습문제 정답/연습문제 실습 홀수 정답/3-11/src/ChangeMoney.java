import java.util.Scanner;

public class ChangeMoney {
	public static void main (String args[])  {
		int [] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1}; // ȯ���� ���� ����
		int res;
		int money;
		Scanner sin = new Scanner(System.in);
		System.out.print("�ݾ��� �Է��Ͻÿ�>>");
		money = sin.nextInt();
		for(int i=0; i<unit.length; i++) {
			res = money/unit[i]; // unit[i]�� ���� ���
			String str1, str2;
			if (res > 0) {
				if (i <= 2) { // 50000, 10000, 1000�� ���
					str1 = "���� ";
					str2 = "��";
				} else {
					str1 = "��¥�� ���� ";
					str2 = "��";				
				}
				System.out.println(unit[i] + str1 + res + str2);
				money = money%unit[i]; // money ����
			}
		}
	}
}