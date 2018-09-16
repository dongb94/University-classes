
public class StackManager {
	public static void main (String[] args) {
		Stack s = new StringStack(10);
		for (int i=0; i<s.length(); i++)
			s.push("¹®ÀÚ¿­"+i);
		for (int i=0;i<s.length(); i++)
			System.out.println(s.pop());
	}
}
