package 숙제3;
import java.util.Scanner;
public class 스켄문 {
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		int age;
		double weight; 
		String name;
		age = console.nextInt();
		name = console.next();
		weight = console.nextDouble();
		System.out.println("나이, 이름, 체중");
		System.out.println(age + "," + name + " " + weight);
	}
}