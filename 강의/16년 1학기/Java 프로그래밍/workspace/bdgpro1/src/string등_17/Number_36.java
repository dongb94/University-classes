package stringµî_17;

public class Number_36 {

	static int randomInt(int x, int y){
		int ran;
		if(x<y) ran=(int)(Math.random()*(y-x+1))+x;
		else ran=(int)(Math.random()*(x-y+1))+y;
		return ran;
	}
	public static void main(String[] args) {
	for(int i=0; i<10;i++)
		System.out.println(randomInt(3,7));
	}

}
