package ¼÷Á¦10;

class MyClass{
	int i;
}

class Person{
	private String name;
	private int age;
	
	void set_name(String a){
		name=a;
	}
	void set_age(int a){
		age=a;
	}
}
public class Example {
	public static void main(String args[]) {
		MyClass a[]=new MyClass[10];
		for (int j=0; j<a.length; j++) {
			a[j]=new MyClass();
			a[j].i=j;
		}
	}
}
