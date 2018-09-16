package ¼÷Á¦8;
class Item{
	private int j;
	private int k;
	private double d;
	Item() { 
		j=0;
		k=0;
		d=0;
	}
	Item(int a) { 
		j=a;
		k=0;
		d=0;
	}
	Item(int a, int b) { 
		Item y =new Item(a,b,5.0);
		j=y.j;
		k=y.k;
		d=y.d;
	}
	Item(int a, int b, double w) {
		j=a;
		k=b;
		d=w;
	}
	public static void main(String[] args){
		Item i=new Item(2,3);
		System.out.println(i.j);
		Item q=new Item(3);
		System.out.println(q.j);
	}
}