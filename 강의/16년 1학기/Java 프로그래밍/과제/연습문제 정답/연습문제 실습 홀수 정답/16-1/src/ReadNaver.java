import java.io.*;
import java.net.*;

public class ReadNaver {
	public static void main(String[] args) {
		try {
			URL aURL = new URL("http://www.naver.com"); // POST�� ������ ����Ʈ URL ��ü ����
			URLConnection uc = aURL.openConnection(); // URLConnection ��ü ����
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream())); // �������� ������ �б� ���� �Է� ��Ʈ�� ���� 
			String inputLine;
			while ((inputLine = in.readLine()) != null) // ���� �� ����
				System.out.println(inputLine);
			in.close();
		} catch (IOException e) {
			System.out.println("URL�� �����͸� ����� �߿� ������ �߻��߽��ϴ�.");
		}
	}
}
