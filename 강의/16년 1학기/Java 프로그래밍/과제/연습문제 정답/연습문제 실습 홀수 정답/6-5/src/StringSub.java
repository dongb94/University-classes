
public class StringSub {
	public static void main (String[] args) {
		if(args.length == 0) {
			System.out.println("명령행 인자가 업습니다.");
			return;
		}
		String str = args[0];
		str = str.replaceAll("is", "are");
		System.out.println(str);
	}
}
