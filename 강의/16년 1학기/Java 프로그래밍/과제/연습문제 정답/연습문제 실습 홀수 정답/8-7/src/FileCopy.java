import java.io.*;
public class FileCopy {
	public static void main(String[] args) {
		BufferedInputStream file1 = null;
		BufferedOutputStream file2 = null;
		try {
			file1 = new BufferedInputStream(new FileInputStream("a.jpg")); // ���� �Է� ��Ʈ���� ����
			file2 = new BufferedOutputStream(new FileOutputStream("b.jpg")); // ���� ��� ��Ʈ���� ����
			byte[] b = new byte[1024];
			int numRead = 1; // ù��° while�ݺ��� ���� ��
			while (numRead > 0) {
				numRead = file1.read(b, 0, b.length);
				if (numRead > 0)
					file2.write(b, 0, numRead);
			}
            if (file1 != null)
                file1.close();
            if (file2 != null)
            	file2.close();
		} catch (IOException e) {
			System.out.println("����� ������ �߻��߽��ϴ�.");
		}
	}
}
