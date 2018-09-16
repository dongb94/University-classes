package wrapper_16;

public class Number_34 {
	void process(Object o) {
		System.out.println("Object");
	}
	void process(Number o) {
		System.out.println("Number");
	}
	void process(Integer o) {
		System.out.println("Integer");
	}
	void process(Long o) {
		System.out.println("Long");
	}
	public static void main(String[] args) {
		double d = 10;
		Number_34 ol = new Number_34();
		ol.process(d);
		ol.process(23);
		new Byte((byte) 2).equals(new Double(2));
	}
}