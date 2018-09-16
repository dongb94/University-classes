package ¼÷Á¦10;
class Rectangle{
	int x1,x2,y1,y2;
	Rectangle(){
	}
	Rectangle(int x1, int y1, int x2, int y2){
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
	}
	void set(int x1, int y1, int x2, int y2){
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
	}
	int square(){
		int area;
		area=(x1-x2)*(y1-y2);
		if(area<0)
			area=-area;
		return (area);
	}
	void show(){
		System.out.println("ÁÂÇ¥1=("+x1+","+y1+")");
		System.out.println("ÁÂÇ¥2=("+x2+","+y2+")");
		System.out.println("³ÐÀÌ="+square());
	}
	boolean equals(Rectangle r){
		if(r.square()==square())
			return true;
		return false;
	}
}
public class Ex4_2 {
	public static void main(String[] args) {
		Rectangle r=new Rectangle();
		Rectangle s=new Rectangle(1,1,2,3);
		
		r.show();
		s.show();
		System.out.println(s.square());
		r.set(-2, 2, -1, 4);
		r.show();
		System.out.println(r.square());
		if(r.equals(s))
			System.out.println("µÎ »ç°¢ÇüÀº °°½À´Ï´Ù.");
	}
}
