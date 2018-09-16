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
			listener = new ServerSocket(9999); // 서버 소켓 생성
			socket = listener.accept(); // 클라이언트로부터 연결 요청 대기
			System.out.println("연결됨");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 클라이언트로부터의 입력 스트림
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); 
			String expression;
			expression = in.readLine(); // 클라이언트에서 수식 읽음
			System.out.println(expression); // 클라이언트가 보낸 수식 화면에 출력
			out.write(doCalc(expression)); // 결과 전송
			out.flush();
			socket.close(); // 클라이언트와 통신용 소켓 닫기
			listener.close(); // 서버 소켓 닫기
		} catch (IOException e) {
			System.out.println("입출력 오류가 발생했습니다.");
		}
	}

	private static String doCalc(String expression) {
		char opr;
		Double oprnd1, oprnd2, answer = null;
		StringTokenizer st = new StringTokenizer(expression,"+-*/", true);
		int n = st.countTokens(); // 단어 개수
		try {
			if (n == 3) { // 피연산자 2개와 연산자 1개
				oprnd1 = Double.parseDouble(st.nextToken());
				if ((opr = getOperator(st.nextToken()))=='@')
					return "잘못된 연산자입니다.";
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
				return "잘못된 수식입니다.";
		} catch (NumberFormatException e) {
			return "잘못된 피연산자입니다.";
		}
		return("수식의 결과값은 " + answer);
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
		return '@'; // 잘못된 연산자인 경우
	}
}
