package 클레스객체상속_11;
class Name {
	String firstName;
	String lastName;
	public Name(String a, String b){
		firstName = a;
		lastName = b;
	}
	public Name(){}
	void setName(String a, String b){
		firstName = a;
		lastName = b;
	}
	public String toString(){
		return firstName + " " + lastName;
	}
}
public class Test{
	final Name n1 = new Name("John", "Smith");
	final Name n2 = new Name();
	public static void main(String[] args) {
		Test t = new Test();
		t.n2.setName("SR", "Kim");
		System.out.println(t.n1);
		System.out.println(t.n2);
		
		
		Barbell ba=new Barbell();
		ba.setWeight(23);
		System.out.println(ba.getWeight());
	}


}
class Book {
	Book(char c) {
		System.out.println("new Book " + c);
	}
}
class Library{
	Library() {
		t1 = new Book('Y');
	}
	static Book t1 = new Book('A');
	static Book t2 = new Book('B');
}
class Barbell{

	public double getWeight(){
		return weight;
	}
	public void setWeight(double w){
		weight = (int) w;
	}
	public int weight;
}