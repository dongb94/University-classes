package 클레스객체상속_2;
class Up{
	int Ex(){
		int a=1;
		return a;
	}
}
class Clock{
	private int hr=2, min=24, sec=03;
	public String toString() {
		String a;
		if(hr<10) a="0"+hr+":";
		else a=hr+":";
		if(min<10) a+="0"+min+":";
		else a+=min+":";
		if(sec<10) a+="0"+sec;
		else a+=sec;
		return a;
	}
}
public class Exp extends Up {
	int Ex(){
		int a=2;
		return a;
	}
	public static void main(String [] args){
		Exp e= new Exp();
		System.out.println(e.Ex());
		Clock cl=new Clock();
		System.out.println(cl);
	}

}
