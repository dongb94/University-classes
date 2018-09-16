package ¿¹¿Ü_13;

import java.io.EOFException;
import java.io.FileNotFoundException;

public class Number_41 {
	public static void main(String[] args){
		System.out.print("Start ");
		try {
		   System.out.print("Hello world");
		   throw new FileNotFoundException();
		}
		catch(EOFException e) {
		   System.out.print("End of file exception");
		}
		catch(FileNotFoundException e) {
		   System.out.print("File not found");
		}
	}
}
