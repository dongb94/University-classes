package 클레스객체상속_2;
class OurSimpleMath { 
    public double min(double x, double y){ 
          if(x <= y)
                 return x;
          else return y;
    }
    public double max(double x, double y){ 
          if(x >= y)
                 return x;
          else return y;
    }
}
public class OurMath extends OurSimpleMath {
	public double min(double x, double y, double z){
		return min(min(x,y), z);
	}
	public double max(double x, double y, double z){
		return max(max(x,y), z);
	}
	public static void main(String[] args){
		OurMath m=new OurMath();
		System.out.println(m.min(2.3,1.4,23.4));
		System.out.println(m.max(2.3,1.4,23.4));
	}
}