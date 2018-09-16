package stringµî_17;
import java.util.*;
public class Number_32 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();

		for(int i=0; i<str.length(); i++){
			System.out.print(str.charAt(str.length()-i-1));
		}
	}
}
