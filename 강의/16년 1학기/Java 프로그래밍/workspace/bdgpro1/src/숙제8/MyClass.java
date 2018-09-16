package ¼÷Á¦8;
class MyClass {
	   private int var1, var2;
	   private String var3, var4;
	   static private int count;
	   public MyClass()   {
	      count++;
	   }
	   private void myMethod(){
	       System.out.println("MyMethod");
	   }
	   public String tryMe(String x){
	       System.out.println(++ var1);
	       System.out.println (++ var2 + var1);
	       System.out.println (var3 + "link" + var4) ; return("tryMe" + x);
	   }
	   public static void tryMeToo(){
	       for (int j = 0; j < count; j++)
	        System.out.println("tryMeToo");
	       System.out.println();
	   }
	   public static void main(String[] args){
	        MyClass x = new MyClass();
	        System.out.println(x.tryMe(" first try"));
	        x.tryMeToo(); 
	        MyClass y = new MyClass();
	        x.tryMeToo(); 
	        y.tryMeToo();
	   }
	}