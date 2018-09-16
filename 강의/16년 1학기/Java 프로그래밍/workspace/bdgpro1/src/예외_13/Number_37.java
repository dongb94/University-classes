package ¿¹¿Ü_13;

import java.io.FileNotFoundException;

public class Number_37 {
	public static void main(String [] arge) throws Exception{
		aMethod();
	}
	public static void aMethod() throws Exception {
		if(Math.random() < 0.5)
			throw new Exception();
		else
			throw new FileNotFoundException();
	}
}
