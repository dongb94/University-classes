package network;
import java.io.*;
public class Example{
	public static void main(String[] arguments) {
		try {
			FileInputStream file = new FileInputStream("numbers1.txt");
			DataInputStream dis = new DataInputStream(file);
			String line = dis.readLine();
			while (line != null) {
				System.out.println(line);
				line = dis.readLine();
			}
			dis.close();
		} catch (IOException e) {
			System.out.println("Error -- " + e.toString());
		}
	}
}

