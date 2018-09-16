import java.util.Scanner;

public class ChangeMoney {
	public static void main (String args[])  {
		int [] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1}; // 환산할 돈의 종류
		int res;
		int money;
		Scanner sin = new Scanner(System.in);
		System.out.print("금액을 입력하시오>>");
		money = sin.nextInt();
		for(int i=0; i<unit.length; i++) {
			res = money/unit[i]; // unit[i]의 개수 계산
			String str1, str2;
			if (res > 0) {
				if (i <= 2) { // 50000, 10000, 1000원 경우
					str1 = "원권 ";
					str2 = "매";
				} else {
					str1 = "원짜리 동전 ";
					str2 = "개";				
				}
				System.out.println(unit[i] + str1 + res + str2);
				money = money%unit[i]; // money 갱신
			}
		}
	}
}