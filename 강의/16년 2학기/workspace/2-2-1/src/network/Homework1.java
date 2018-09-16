package network;

import java.io.*;

public class Homework1 {

	public static void main(String[] args) throws IOException {
			FileInputStream FI=new FileInputStream("numbers2.txt");
			int count=0;
			int i=FI.read();
			while(i!=-1){
				System.out.println(i);
				count++;
				i=FI.read();
			}
			System.out.println(count+"bytes");		
	}
}
