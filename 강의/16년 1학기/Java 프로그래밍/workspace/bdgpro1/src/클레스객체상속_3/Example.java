package Ŭ������ü���_3;
class Animal{}
class Bird extends Animal{}
class Cock extends Bird{} // Cock�� ��
class Fish extends Animal{}
class Trout extends Fish{} // Trout�� �۾�
public class Example{
	public static void main(String[] args){
		Fish[] fish = new Fish[10]; //��
		Animal[] animals = fish; // ��
		animals[8] = new Animal(); //��
		animals[9] = new Cock(); // ��
		Object o = animals; //��
		System.out.print (o.getClass().getName()); // �� ��ü o�� ���� Ŭ���� �μ�
	}
}