package 숙제10;

import java.util.Scanner;

class Add{
	int a,b;
	void setValue(int a, int b){
		this.a=a;
		this.b=b;
	}
	int calculate(){
		return a+b;
	}
}
class Sub{
	int a,b;
	void setValue(int a, int b){
		this.a=a;
		this.b=b;
	}
	int calculate(){
		return a-b;
	}
}
class Mul{
	int a,b;
	void setValue(int a, int b){
		this.a=a;
		this.b=b;
	}
	int calculate(){
		return a*b;
	}
}
class Div{
	int a,b;
	void setValue(int a, int b){
		this.a=a;
		this.b=b;
	}
	int calculate(){
		return a/b;
	}
}
public class Ex4_5 {

	public static void main(String[] args) {
		int a,b;
		String c;
		
		Scanner sc=new Scanner(System.in);
		System.out.print("두 정수와 연산자를 입력하시오>>");
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.next();
		
		if(c.equals("+")){
			Add add=new Add();
			add.setValue(a,b);
			System.out.println(add.calculate());
		}
		if(c.equals("-")){
			Sub sub=new Sub();
			sub.setValue(a,b);
			System.out.println(sub.calculate());
		}
		if(c.equals("*")){
			Mul mul=new Mul();
			mul.setValue(a,b);
			System.out.println(mul.calculate());
		}
		if(c.equals("/")){
			Div div=new Div();
			div.setValue(a,b);
			System.out.println(div.calculate());
		}
	}
}
