package GenericsCollections_20;
import java.util.*;
public class Number_25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Double> map = new HashMap<>();

		map.put("pi", 3.141592);
		map.put("sin(x)", new Double(1234));
		System.out.println(map.get("pis"));

		Map<Integer, Integer> map1 = new HashMap<>();
		for(int i = 0; i < 10; i++)
			map1.put(i, i * i);
			System.out.println( map1.get( 4 ) );
		

	}
}