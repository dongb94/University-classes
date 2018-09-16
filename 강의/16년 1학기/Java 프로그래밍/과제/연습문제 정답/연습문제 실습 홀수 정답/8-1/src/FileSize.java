import java.io.File;

public class FileSize {
	public static void main (String[] args) {
		File f = new File("a.jpg");
		System.out.println(f.getAbsolutePath());
		System.out.println("파일 크기는 " + f.length());
	}
}
