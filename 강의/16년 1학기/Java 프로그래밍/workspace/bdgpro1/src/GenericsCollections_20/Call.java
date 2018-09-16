package GenericsCollections_20;
public class Call<T> {
	   T t;
	   public Call(T t){ this.t = t; }
	   public String toString(){ return t.toString(); }
	   public static void main(String[] args){
	     System.out.print(new Call<String>("start"));
	     System.out.print(new Call("end"));
	   }
	}