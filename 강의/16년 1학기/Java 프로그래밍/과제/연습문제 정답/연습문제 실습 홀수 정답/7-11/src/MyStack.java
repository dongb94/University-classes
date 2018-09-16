import java.util.LinkedList;

public class MyStack<T> implements Stack<T> {
	LinkedList<T> l = null;
	public MyStack() {
		l = new LinkedList<T>();
	}

	@Override
	public T pop() {
		if (l.size() == 0)
			return null; 
		else 
			return l.removeFirst();
	}

	@Override
	public boolean push(T ob) {
		l.addFirst(ob);
		return true;
	}
}
