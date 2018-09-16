
public class MyColorPoint extends MyPoint {
	String color;
	
	public MyColorPoint(int i, int j, String color) {
		super(i, j);
		this.color = color;
	}

	@Override
	protected void move(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	protected void reverse() {
		int tmp = x;
		x = y;
		y = tmp;
	}
	
	public void show() {
		System.out.println(x + "," + y + "," + color);
	}
	
	static public void main(String[] args) {
		MyPoint p = new MyColorPoint(2,3,"blue");
		p.move(3,4);
		p.reverse();
		p.show(); // 이 메소드의 실행 결과 "2,3,blue"가 출력된다.
	}

}
