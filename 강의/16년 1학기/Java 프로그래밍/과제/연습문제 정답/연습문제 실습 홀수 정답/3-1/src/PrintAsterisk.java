import java.util.Scanner;


public class PrintAsterisk {
	public static void main(String[] args){
		Scanner sin = new Scanner(System.in);
		System.out.print("임의의 정수를 입력하시오>>");
		int repeat = sin.nextInt();
		if (repeat <=0) {
			System.out.println("0보다 커야 합니다.");
			return;
		}
		for (int i=repeat; i>0; i--) {
			for (int j=0; j<i; j++)
				System.out.print('*');
			System.out.println();
		}
	}
}
