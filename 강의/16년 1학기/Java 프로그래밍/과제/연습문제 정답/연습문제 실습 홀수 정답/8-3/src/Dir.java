import java.io.File;
public class Dir {
	public static void getDir(File fd) {
		String[] filenames = fd.list(); // 디렉토리에 포함된 파일과 디렉토리 이름의 리스트 얻기
		for (String s : filenames) {
			File f = new File(fd, s);
			if(!f.isFile()) // 디렉토리 타입이면
				System.out.println(s);
		}		
	}
	
	public static void main(String[] args){
		getDir(new File("C:\\"));
	}
}
