package 클레스객체상속_2;

public class Example {
	public static void main(String[] args) {
		Record r = new Record(1234, "Kim");
		System.out.println(r);
		change(r);
		System.out.println(r);
	}
	static void change(Record rcd){
		rcd.name = "fool";
	}
}
class Record{
	int number;
	String name;
	Record(int no, String name){
		number = no;
		this.name = name;
	}
	public String toString(){
		return "[Number = " + number + "], [Name = " + name + "]";
	}
}