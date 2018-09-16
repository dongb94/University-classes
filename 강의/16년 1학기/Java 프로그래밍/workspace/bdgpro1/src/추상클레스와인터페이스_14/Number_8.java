package 추상클레스와인터페이스_14;
abstract class Number_8{
	abstract short method1();
	short method2(){
      return (short)420;
   }
}
abstract class B extends Number_8{
	short method1(){
      return (short) 42;
   }
}
