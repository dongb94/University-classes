import java.io.*;
import java.util.Scanner;

public class Compare {
	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		String src, dst;
		BufferedInputStream file1 = null;
		BufferedInputStream file2 = null;
		System.out.print("첫번째 파일 이름을 입력하세요>>");
		src = sin.nextLine();
		System.out.print("두번째 파일 이름을 입력하세요>>");
		dst = sin.nextLine();
		System.out.println(src + "와 " + dst + "를 비교합니다.");
		try {
			file1 = new BufferedInputStream(new FileInputStream(src)); // 버퍼 입력 스트림에 연결
			file2 = new BufferedInputStream(new FileInputStream(dst)); // 버퍼 출력 스트림에 연결
			if (compareFile(file1, file2))
				System.out.println("파일이 같습니다.");
			else
				System.out.println("파일이 다릅니다.");
            if (file1 != null)
                file1.close();
            if (file2 != null)
            	file2.close();
		} catch (IOException e) {
			System.out.println("입출력 오류가 발생했습니다.");
		}
	}

	private static boolean compareFile(BufferedInputStream file1,BufferedInputStream file2) throws IOException {
		byte[] b1 = new byte[100];
		byte[] b2 = new byte[100];
		int numRead1,numRead2;
		numRead1 = 1; // 첫번째 while반복을 위한 값
		while (numRead1 > 0) {
			numRead1 = file1.read(b1, 0, b1.length);
			numRead2 = file2.read(b2, 0, b2.length);
			if (numRead1 != numRead2) // 읽어들인 바이트 수가 다르면 파일이 다름 
				return false;
			
			for (int i=0; i<numRead1; i++) {
				if (b1[i] != b2[i]) // 버퍼 내용이 달라도 파일이 다름
					return false;
			}
		}
		return true;
	}
}
