package stringµî_17;

public class Number_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "testme"; 
		x += 33; 
		System.out.println(x);
		
		String y = "testme"; 
		y += (char) 33; 
		System.out.println(y);
		
		String s = "This is too hard!"; 
		System.out.println(s.substring(0,8) + "not");
		
		String r = "Check this out"; 
		System.out.println(r.replace(' ', (char) 0).length());
	}

}
