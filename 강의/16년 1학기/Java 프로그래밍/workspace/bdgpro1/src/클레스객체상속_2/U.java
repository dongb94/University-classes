package 클레스객체상속_2;

public class U extends Woo{
	String work(String x) { return "Hello";}
	public static void main(String[] args){
		
	}
}
class Foo1 {
	int doStuff(int a, float b) { return 7;}
}
class Foo2 extends Foo1{
	// insert code here
	int doStuff(float x, int y) { return 4;}
}