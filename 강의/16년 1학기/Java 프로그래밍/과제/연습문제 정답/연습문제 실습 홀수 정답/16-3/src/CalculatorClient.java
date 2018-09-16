import java.io.*;
import java.net.Socket;

public class CalculatorClient {
	public static void main(String[] args) {
		BufferedReader stin = null;
		BufferedWriter out = null;
		BufferedReader in = null;
		Socket socket = null;
		try {
			socket = new Socket("localhost", 9999); // Ŭ���̾�Ʈ ���� ����
			stin = new BufferedReader(new InputStreamReader(System.in)); // Ű����κ����� �Է� ��Ʈ��
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // �������� ��� ��Ʈ��
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String outputMessage;
			outputMessage = stin.readLine(); // Ű���忡�� ������ ����
			out.write(outputMessage+"\n"); // Ű���忡�� ���� ���� ����
			out.flush();
			System.out.println(in.readLine()); // �������� ������ �� ���
			socket.close();
		} catch (IOException e) {
			System.out.println("����� ������ �߻��߽��ϴ�.");
		}
	}
}
