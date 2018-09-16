package 클레스객체상속_2;
public class B extends A {
	private int size;
	public int getSize(){
		return size;
	}
	public void setSize(int w){
		size = w;
	}
	public static void main(String[] args){
		B b=new B();
		b.setSize(3);
		System.out.println(b.getSize());
	}
}
class A {
	public int no;
}