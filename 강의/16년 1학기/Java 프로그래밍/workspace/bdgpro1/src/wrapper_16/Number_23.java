package wrapper_16;

public class Number_23 {
	public static void main(String[] args) {
		String s = "34";
		try {
			s = s.concat(".5");
			double d = Double.parseDouble(s);
			s = Double.toString(d);
			int a = (int) (Double.valueOf(s).doubleValue());
			System.out.println(a);
		} catch (NumberFormatException e) {
			System.out.println("Not good number");
		}
		String str = "1.34";
		float f1 = Float.valueOf(str);
		float f2 = new Float(3.14f).floatValue();
		float f4 = Float.valueOf(str).floatValue();
		float f5 = (float) Double.parseDouble("3.14");
	}
}
