package ����3;
import java.util.Scanner;
public class ���˹� {
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		int age;
		double weight; 
		String name;
		age = console.nextInt();
		name = console.next();
		weight = console.nextDouble();
		System.out.println("����, �̸�, ü��");
		System.out.println(age + "," + name + " " + weight);
	}
}