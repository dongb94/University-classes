package GenericsCollections_20;

import java.util.*;

public class Number_32 {

	public static void main(String[] args) {
		List<Integer> q = new LinkedList<>();
		q.add(10);
		q.add(20);
		q.add(1);
		q.remove(1);
		System.out.println(q);
	}

}
class A{}
class B extends A {}
class C extends B {}
class D<C> {
	 A a1 = new A();
	 A a2 = new B();
	 A a3 = (A) new C();
	C c1 = new A();
	 C c2 = new B();
	 C c3 = new C();          
}