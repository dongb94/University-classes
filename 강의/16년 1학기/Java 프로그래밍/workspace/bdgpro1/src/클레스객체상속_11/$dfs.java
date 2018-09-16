package 클레스객체상속_11;
class $1{
	static int i;
	int j;
	void ad(int s){
		i=+1;
	}
}
public class $dfs {
	public static void main(String[] args){
		$1 one=new $1();
		one.i=1;
		$1.i=2;
		one.ad(3);
		System.out.println(one.i);
		
		System.out.println(Math.round(2.6));
		System.out.println(Math.floor(2.4));
		System.out.println(Math.floor(2.6));
		System.out.println(Math.ceil(2.4));
		System.out.println(Math.ceil(2.6));
		System.out.println((int)Math.random()*10+5);
		int a=23;
		long b=45L;
	}

}