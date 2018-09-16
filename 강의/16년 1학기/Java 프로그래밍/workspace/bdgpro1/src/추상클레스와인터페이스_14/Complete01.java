package 추상클레스와인터페이스_14;
public class Complete01 extends Abst {
	int myvariable;
	Complete01() {
		super();
		myvariable = 3;
	}
	Complete01(int x) {
		super(x);
		myvariable = x + 3;
	}
	public void notImplemented(int y) {
		value2 = value2 + y;
		value1 = value1 * y;
		System.out.println("parameter = " + y);
		System.out.println("myvariable = " + myvariable);
	}
	public static void main(String[] args) {
		Complete01 h = new Complete01();
		Complete01 j = new Complete01(4);
		h.implemented();
		h.notImplemented(5);
		System.out.println(h.value1);
		System.out.println(h.value2);
		j.implemented();
		j.notImplemented(5);
		System.out.println(j.value1);
		System.out.println(j.value2);
	}
}
abstract class Abst {
	protected int value1;
	int value2;
	Abst() {
	}
	Abst(int v) {
		value1 = value2 = v;
	}
	public void implemented() {
		System.out.println("implemented");
	}
	public abstract void notImplemented(int x);
}