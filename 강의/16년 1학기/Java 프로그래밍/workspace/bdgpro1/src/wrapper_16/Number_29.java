package wrapper_16;

public class Number_29 {
	public static void main(String[] args){
		try {
			  Float f = new Float("12.0");
			  int x = f.intValue();
			  byte b = f.byteValue();
			  double d = f.doubleValue();
			  System.out.println(x + b + d);
			}
			catch(NumberFormatException e){
			  System.out.println("not good number");
			}
	}

}
