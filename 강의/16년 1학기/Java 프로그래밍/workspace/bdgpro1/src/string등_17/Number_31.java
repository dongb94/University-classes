package stringµî_17;
import java.util.*;

public class Number_31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = new String("Java");
		String str2 = "Java";
		System.out.println(str1 == str2);
		String str3 = "Java";
		System.out.println(str2 == str3);
		str3 = "Ja" + "va";
		System.out.println(str2 == str3);
		str3 = "Ja";
		str3 += "va";
		System.out.println(str2 == str3); 
		String str4="Ja";
		System.out.println(str4 == str3);
		StringBuffer sb1 = new StringBuffer("Christmas");
		StringBuffer sb2 = new StringBuffer("Christmas");
		System.out.println(sb1.equals(sb2));
		String a = "newspaper";
		a = a.substring(5,7);
		char b = a.charAt(1);
		a = a + b;
		System.out.println(a);
		StringBuilder u; u = new StringBuilder("I wonder if this will work?");
	}
	
}
