package GenericsCollections_20;

import java.util.*;

public class Number_23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Set<Number> ns = new HashSet<>();
		 ns.add( new Integer(7) );
		 ns.add(null);
		 ns.add(5);
		 ns.add( new Integer(2) );
		 ns.add(null);
		 ns.add(5);
		 ns.add(9L);
		 Iterator it = ns.iterator();
		 while (it.hasNext())
		 System.out.print( it.next() );
	}

}
