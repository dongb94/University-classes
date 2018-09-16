package 클레스객체상속_2;
public class Daughter extends Mother {
	public Daughter(){ }
	public Daughter(int x) {
		super(x);
	}
	public static void main(String[] args){
		Daughter d = new Daughter();
		System.out.println(d.x);
		Mother m = new Daughter(2);
		System.out.println(m.x);
	}
}