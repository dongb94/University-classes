public class MyPoint {
	private int x;
	private int y;
	public MyPoint(int i, int j) {
		x = i; y = j;
	}
	public String toString() {
		return "MyPoint("+x+","+y+")";
	}
	public static void main(String [] args) {
		MyPoint a = new MyPoint(3,20);
		System.out.println(a); // "MyPoint(3,20)"이 출력된다.
	}
}
