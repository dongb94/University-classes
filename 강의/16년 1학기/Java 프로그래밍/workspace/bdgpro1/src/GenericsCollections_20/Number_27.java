package GenericsCollections_20;

public class Number_27 {
	public class printException<T> {

	}
	public static <U extends Exception> void printException(Throwable throwable){
		System.out.println(throwable.getMessage());
	}
	public static void main(String[] args) {
		Number_27.printException(new MyException("File"));
		Number_27.<Exception>printException(new Exception("Exception"));
		Number_27.<NullPointerException>printException(new NullPointerException("p"));
		Number_27.printException(new Throwable("D"));
	}

}
class MyException extends Exception {
	MyException(String m) {
		super(m);
	}
}