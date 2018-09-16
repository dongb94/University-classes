package 클레스객체상속_3;
class Animal{}
class Bird extends Animal{}
class Cock extends Bird{} // Cock은 닭
class Fish extends Animal{}
class Trout extends Fish{} // Trout는 송어
public class Example{
	public static void main(String[] args){
		Fish[] fish = new Fish[10]; //①
		Animal[] animals = fish; // ②
		animals[8] = new Animal(); //③
		animals[9] = new Cock(); // ④
		Object o = animals; //⑤
		System.out.print (o.getClass().getName()); // ⑥ 객체 o를 만들어낸 클래스 인쇄
	}
}