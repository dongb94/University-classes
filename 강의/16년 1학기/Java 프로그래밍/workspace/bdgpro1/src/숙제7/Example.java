package ¼÷Á¦7;

public class Example {
	public static void main(String[] args) {
		final int[] i = new int[] {1,2,3,4};
		print(i);
		i[3] = 99;
		print(i);
	}
	static void print(int[] a){
		for(int i = 0; i < a.length; i++)
			System.out.print(" "+a[i]);
		System.out.print("\n");
	}
}
