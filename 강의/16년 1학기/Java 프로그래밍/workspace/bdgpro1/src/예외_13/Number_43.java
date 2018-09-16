package ¿¹¿Ü_13;

public class Number_43 {
	   public static void main(String[] args) {
		      try{
		          a();
		      } catch (Exception e) {
		          System.out.println("Exception caught");
		      } finally {
		          System.out.println("Finally");
		      }
		      System.out.println("End");
		   }
		   static void a() throws OurException{
		      throw new MyException();
		   }
		}
		class OurException extends Exception{}
		class MyException extends OurException{}