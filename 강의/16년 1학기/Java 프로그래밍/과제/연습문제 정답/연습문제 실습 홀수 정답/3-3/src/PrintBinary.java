import java.util.Scanner;

public class PrintBinary {
	public static void main (String[] args) {
		Scanner sin = new Scanner(System.in);
		System.out.print("임의의 정수를 입력하시오>>");
		byte result[] = new byte[64];	// 0 또는 1을 저장하기 위한 byte 배열
		int num = sin.nextInt();
		int remainder, numberOfOne = 0, index=0;
		if (num <=0) {
			System.out.println("0보다 커야 합니다.");
			return;
		}
		while (num > 0) {
			remainder = num % 2; // 2로 나눈 나머지는 0 또는 1이 됨
			result[index++] = (byte) remainder; // 나머지를 배열에 저장
			if (index == result.length) {
				System.out.println(result.length + "비트 이상은 처리할 수 없습니다.");
				return;
			}
			if (remainder == 1)
				numberOfOne++;
			num = num /2;
		}
		for (--index; index >=0; index--) // 배열에 저장된 역순으로 출력
			System.out.print(result[index]);
		System.out.println("\n1의 갯수는 " + numberOfOne);
	}
}
