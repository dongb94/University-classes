import java.util.*;
public class WordCount {
	public static void main (String[] args) {
		Scanner sin = new Scanner(System.in);
		String str;
		System.out.print("문자열을 입력하세요>>");
		int n = 0;
		try {
			while(true) {
				str = sin.nextLine();
				StringTokenizer st = new StringTokenizer(str);
				n += st.countTokens(); // 단어 개수 누적
			}
		}
		catch (NoSuchElementException e) { // ctrl-z 입력 시 발생하는 예외
			System.out.println("단어의 개수는 " + n); // 누적 단어 갯수 출력
		} 
	}
}
