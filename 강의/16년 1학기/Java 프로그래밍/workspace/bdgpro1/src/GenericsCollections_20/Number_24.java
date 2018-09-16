package GenericsCollections_20;
import java.util.*;
public class Number_24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<String> tree = new TreeSet<String>();
		tree.add( "two" );
		tree.add( "Two" );
		tree.add( "TWO" );
		tree.add( "two" );
		System.out.print( tree.ceiling("Tw") );
	}

}
