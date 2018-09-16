import java.io.*;
import java.util.Scanner;

public class Compare {
	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		String src, dst;
		BufferedInputStream file1 = null;
		BufferedInputStream file2 = null;
		System.out.print("ù��° ���� �̸��� �Է��ϼ���>>");
		src = sin.nextLine();
		System.out.print("�ι�° ���� �̸��� �Է��ϼ���>>");
		dst = sin.nextLine();
		System.out.println(src + "�� " + dst + "�� ���մϴ�.");
		try {
			file1 = new BufferedInputStream(new FileInputStream(src)); // ���� �Է� ��Ʈ���� ����
			file2 = new BufferedInputStream(new FileInputStream(dst)); // ���� ��� ��Ʈ���� ����
			if (compareFile(file1, file2))
				System.out.println("������ �����ϴ�.");
			else
				System.out.println("������ �ٸ��ϴ�.");
            if (file1 != null)
                file1.close();
            if (file2 != null)
            	file2.close();
		} catch (IOException e) {
			System.out.println("����� ������ �߻��߽��ϴ�.");
		}
	}

	private static boolean compareFile(BufferedInputStream file1,BufferedInputStream file2) throws IOException {
		byte[] b1 = new byte[100];
		byte[] b2 = new byte[100];
		int numRead1,numRead2;
		numRead1 = 1; // ù��° while�ݺ��� ���� ��
		while (numRead1 > 0) {
			numRead1 = file1.read(b1, 0, b1.length);
			numRead2 = file2.read(b2, 0, b2.length);
			if (numRead1 != numRead2) // �о���� ����Ʈ ���� �ٸ��� ������ �ٸ� 
				return false;
			
			for (int i=0; i<numRead1; i++) {
				if (b1[i] != b2[i]) // ���� ������ �޶� ������ �ٸ�
					return false;
			}
		}
		return true;
	}
}
