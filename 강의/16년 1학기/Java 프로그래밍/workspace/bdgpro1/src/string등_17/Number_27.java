package stringµî_17;

public class Number_27 {

	static int count(String s, char c){
		return s.indexOf(c,s.indexOf(c)+1)-s.indexOf(c)-1;
	}
	static String squeeze(String from, char ch){
		while(from.indexOf(ch)!=-1){
			from=from.substring(0, from.indexOf(ch))+from.substring(from.indexOf(ch)+1);
		}
		return from;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count("emffemfforey", 'e'));
		System.out.println(squeeze("emffemfforewfweifjwo", 'e'));
		System.out.println(Math.sin(Math.toRadians(90)));	}

}
