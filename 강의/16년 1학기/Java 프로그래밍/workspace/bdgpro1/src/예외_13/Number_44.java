package ¿¹¿Ü_13;

public class Number_44 {
	   public static void main(String[] a){
		      try {
		          callee1();
		      } catch (Exception e) {
		          System.out.println("Exception"); 
		      }
		   }
		   static void callee1() throws OurException {
		      try {
		          callee2 ();
		      } catch (YourException e) {
		          System.out.println("YourException"); 
		      }
		   }
		   static void callee2() throws OurException {
		      throw new MyException();
		   }
		}
		class OurException extends Exception{}
		class MyException extends OurException{}
		class YourException extends OurException{}