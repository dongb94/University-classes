
package 추상클레스와인터페이스_14;
interface Base {
	boolean m1 ();
	byte m2(short s);
}
interface Base2 extends Base {}

abstract class Class2 implements Base {
	public boolean m1() { return true; } 
}

abstract class Class5 implements Base { }

abstract class Class3 implements Base {
	public boolean m1() { return (7 > 4); } 
}

class Class4 implements Base {
	public boolean m1() { return false; }
	public byte m2(short s) { return 42; } 
	int sdf(){
		return 1;
	}
}

public class Number_22 {

}
