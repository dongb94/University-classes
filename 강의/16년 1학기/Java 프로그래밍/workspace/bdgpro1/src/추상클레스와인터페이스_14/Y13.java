package 추상클레스와인터페이스_14;
abstract class AbstClass {
	protected int value1;
	int value2;
	AbstClass() {
	}
	AbstClass(int value) {
		value1 = value;
		value2 = value;
	}
	public void implemented() {
		System.out.println("OK");
	}
	public abstract void notImplemented(int x);
}

public class Y13 extends AbstClass {
	int myOwn;
	Y13() {
	}
	Y13(int x) {
		super(x);
		myOwn = x;
	}

	public void notImplemented(int x) {
		value2 = value2 + x;
		value1 = value1 + x;
		System.out.println("This was called with the value " + x);
		System.out.println("My variable is " + myOwn);
	}

	public static void main(String[] args) {
		Y13 h = new Y13();
		Y13 j = new Y13(3);
		h.implemented();
		h.notImplemented(2);
		h.implemented();
		System.out.println(h.value1);
		System.out.println(h.value2);
		j.implemented();
		j.notImplemented(3);
		j.implemented();
		System.out.println(j.value1);
		System.out.println(j.value2);
	}
}