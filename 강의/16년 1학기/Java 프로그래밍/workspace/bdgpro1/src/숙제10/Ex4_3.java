package 숙제10;
class ArrayUtility{
	static double[] intToDouble(int[] source){
		double[] a=new double[source.length];
		for(int i=0;i<source.length;i++)
			a[i]=source[i];
		return a;
	}
	static int[] doubleToInt(double[] source){
		int[] a=new int[source.length];
		for(int i=0;i<source.length;i++)
			a[i]=(int)source[i];
		return a;
	}
}
public class Ex4_3 {
	static void print(int[] a){
		for(int i:a){
			System.out.print(i+"\t");
		}
		System.out.println();
	}
	static void print(double[] a){
		for(double i:a){
			System.out.print(i+"\t");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int intArray[]={1,2,3,4,5,6};
		double doubleArray[]={1.1,2.2,3.3,4.4};
		
		int changeInt[]=new int[doubleArray.length];
		double changeDouble[]=new double[intArray.length];
		
		ArrayUtility ch=new ArrayUtility();
		changeInt=ch.doubleToInt(doubleArray);
		changeDouble=ch.intToDouble(intArray);
		
		System.out.print("int배열 =\t\t");
		print(intArray);
		System.out.print("int>double배열 =\t");
		print(changeDouble);
		System.out.print("double배열 =\t");
		print(doubleArray);
		System.out.print("double>int배열 =\t");
		print(changeInt);
	}
}
