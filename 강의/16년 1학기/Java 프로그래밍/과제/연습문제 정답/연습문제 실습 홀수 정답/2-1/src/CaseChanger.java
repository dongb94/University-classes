import java.io.*;

public class CaseChanger {
	public static void main (String args[])  {
		InputStreamReader rd = new InputStreamReader(System.in);
		int a;
		while (true) {
			try {
				a = rd.read();
				if (a == -1)	// ctrl-z�� �ԷµǸ� read()�� -1�� ����
					break;
				else if (a == '\n' || a == '\r') // enterŰ�� �����ϰ� �������� �ݺ����� ����
					continue;
				if (a >= 'a' && a <= 'z') // �ҹ���
					a = a - ('a' - 'A'); // �빮�ڷ� ��ȯ
				else if (a >= 'A' && a <= 'Z') // �빮��
					a = a + ('a' - 'A'); // �ҹ��� ��ȯ
				else {
					System.out.println("�����ڰ� �ƴմϴ�.");
					continue;
				}
				System.out.println((char)a); // �Էµ� ���� ���
			} catch (IOException e) {
				System.out.println("�Է� ���� �߻�");
			}

		} 
	}
}
