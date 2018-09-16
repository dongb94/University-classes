package wrapper_16;

public class Number_8 {
	public static void main(String[] args){
		Double dd = new Double(23.4);
		double d = 23.4;
		dd = d;
		d = dd;
		System.out.println(d);
		System.out.println(dd);
		String st=Double.toString(d);
		d=Double.valueOf(st);
	}
}
