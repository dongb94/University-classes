package stringµî_17;

public class Number_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String t = "XYZ"; 
		String u = "xyz"; 
		System.out.println(t == u); 
		System.out.print(t.equals(u));
		
		String m = new String ("XYZ"); 
		String n = "XYZ"; 
		System.out.println(m == n); 
		System.out.println(m.equals(n));
		
		StringBuilder p = new StringBuilder("Why Me?"); 
		System.out.println(p.reverse());
		
		String v = new String("Why Not Me?"); 
		v += (char) ('0' + v.length());
		System.out.println(v);
		
		StringBuilder w = new StringBuilder("One Pond"); 
		System.out.println(w.replace(2,3, " Golden"));
		
		String a = "test me"; 
		String b = "me"; 
		System.out.println(a.length() + a.indexOf(b));
	}

}
