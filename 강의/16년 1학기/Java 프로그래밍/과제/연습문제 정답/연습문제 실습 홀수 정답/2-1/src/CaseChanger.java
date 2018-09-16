import java.io.*;

public class CaseChanger {
	public static void main (String args[])  {
		InputStreamReader rd = new InputStreamReader(System.in);
		int a;
		while (true) {
			try {
				a = rd.read();
				if (a == -1)	// ctrl-z가 입력되면 read()는 -1을 리턴
					break;
				else if (a == '\n' || a == '\r') // enter키는 무시하고 다음으로 반복으로 진행
					continue;
				if (a >= 'a' && a <= 'z') // 소문자
					a = a - ('a' - 'A'); // 대문자로 변환
				else if (a >= 'A' && a <= 'Z') // 대문자
					a = a + ('a' - 'A'); // 소문자 변환
				else {
					System.out.println("영문자가 아닙니다.");
					continue;
				}
				System.out.println((char)a); // 입력된 문자 출력
			} catch (IOException e) {
				System.out.println("입력 에러 발생");
			}

		} 
	}
}
