import java.io.File;
public class Dir {
	public static void getDir(File fd) {
		String[] filenames = fd.list(); // ���丮�� ���Ե� ���ϰ� ���丮 �̸��� ����Ʈ ���
		for (String s : filenames) {
			File f = new File(fd, s);
			if(!f.isFile()) // ���丮 Ÿ���̸�
				System.out.println(s);
		}		
	}
	
	public static void main(String[] args){
		getDir(new File("C:\\"));
	}
}
