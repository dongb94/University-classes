package 조합및다형성_12;
class A {
	public void X() {
		System.out.println("class A; method X");
	}
	public static void Y() {
		System.out.println("class A; method Y");
	}
}
class B extends A {
	public void X()
	{
		System.out.println("class B; method X");	}
		public static void Y()
	{
		System.out.println("class B; method Y");
	}
}public class MethodCalls {
	public static void main(String[] args) {
		A a = new B();
		a.X();
		a.Y();
		B b = new B();
		b.X();
		b.Y();
	}
}