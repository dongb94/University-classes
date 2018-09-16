package GenericsCollections_20;
import java.util.*;
public class Number_28 {
	public static <U extends RuntimeException> void process1(U u){
		System.out.println( u.getMessage() );
	}

	public static <W> void process2(List<W> w){
		System.out.println(w);
	}

	public static void process3(ArrayList<? extends Exception> w){
		System.out.println(w.getMessage());
	}

	public static void process4(List<? super Exception> w){
		System.out.println(w);
	}

	public static void process5(List<?> w){
		System.out.println(w);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
