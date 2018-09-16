package GenericsCollections_20;
import java.io.IOException;
import java.util.*;

public class Test {
	public void showSize(List<?> list) {
		System.out.println(list.size());
	}
	public static void main(String[] args) {
		Test t = new Test();
	 List<IOException> list = new LinkedList<java.io.IOException>();
		t.showSize(list);
	}
}