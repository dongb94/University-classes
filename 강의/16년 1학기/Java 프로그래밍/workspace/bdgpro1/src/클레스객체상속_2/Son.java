package 클레스객체상속_2;

public class Son extends Papa {
	public Son() { }
	public Son(int x) {
		super(x);
	}
	public static void main(String[] args) { 
		Son s = new Son();
		System.out.println(s.x);
		Papa p = new Son(2);
		System.out.println(p.x);
	}
}