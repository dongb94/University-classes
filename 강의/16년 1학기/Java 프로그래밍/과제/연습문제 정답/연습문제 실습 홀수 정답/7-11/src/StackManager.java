
public class StackManager {
	public static void main (String[] args) {
		Stack<Integer> s = new MyStack<Integer>();
		for (int i=0; i<10; i++)
			s.push(i);
		Integer i = null;
		while ((i=s.pop()) != null)
			System.out.println(i);
	}
}
