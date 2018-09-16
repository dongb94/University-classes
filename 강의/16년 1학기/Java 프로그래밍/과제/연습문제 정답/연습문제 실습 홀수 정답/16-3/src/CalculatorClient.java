import java.io.*;
import java.net.Socket;

public class CalculatorClient {
	public static void main(String[] args) {
		BufferedReader stin = null;
		BufferedWriter out = null;
		BufferedReader in = null;
		Socket socket = null;
		try {
			socket = new Socket("localhost", 9999); // 클라이언트 소켓 생성
			stin = new BufferedReader(new InputStreamReader(System.in)); // 키보드로부터의 입력 스트림
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 서버로의 출력 스트림
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String outputMessage;
			outputMessage = stin.readLine(); // 키보드에서 수식을 읽음
			out.write(outputMessage+"\n"); // 키보드에서 읽은 수식 전송
			out.flush();
			System.out.println(in.readLine()); // 서버에서 전송한 답 출력
			socket.close();
		} catch (IOException e) {
			System.out.println("입출력 오류가 발생했습니다.");
		}
	}
}
