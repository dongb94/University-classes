import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

public class CalculatorServer {
	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		try {
			listener = new ServerSocket(9999); // ���� ���� ����
			socket = listener.accept(); // Ŭ���̾�Ʈ�κ��� ���� ��û ���
			System.out.println("�����");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Ŭ���̾�Ʈ�κ����� �Է� ��Ʈ��
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); 
			String expression;
			expression = in.readLine(); // Ŭ���̾�Ʈ���� ���� ����
			System.out.println(expression); // Ŭ���̾�Ʈ�� ���� ���� ȭ�鿡 ���
			out.write(doCalc(expression)); // ��� ����
			out.flush();
			socket.close(); // Ŭ���̾�Ʈ�� ��ſ� ���� �ݱ�
			listener.close(); // ���� ���� �ݱ�
		} catch (IOException e) {
			System.out.println("����� ������ �߻��߽��ϴ�.");
		}
	}

	private static String doCalc(String expression) {
		char opr;
		Double oprnd1, oprnd2, answer = null;
		StringTokenizer st = new StringTokenizer(expression,"+-*/", true);
		int n = st.countTokens(); // �ܾ� ����
		try {
			if (n == 3) { // �ǿ����� 2���� ������ 1��
				oprnd1 = Double.parseDouble(st.nextToken());
				if ((opr = getOperator(st.nextToken()))=='@')
					return "�߸��� �������Դϴ�.";
				oprnd2 = Double.parseDouble(st.nextToken());
				switch (opr) {
				case '+':
					answer = oprnd1 + oprnd2;
					break;
				case '-':
					answer = oprnd1 - oprnd2;
					break;
				case '*':
					answer = oprnd1 * oprnd2;
					break;
				case '/':
					answer = oprnd1 / oprnd2;
				}
			} else
				return "�߸��� �����Դϴ�.";
		} catch (NumberFormatException e) {
			return "�߸��� �ǿ������Դϴ�.";
		}
		return("������ ������� " + answer);
	}

	private static char getOperator(String token) {
		if (token.equals("+"))
			return '+';
		else if (token.equals("-"))
			return '-';
		else if (token.equals("*"))
			return '*';
		else if (token.equals("/"))
			return '/';
		return '@'; // �߸��� �������� ���
	}
}
