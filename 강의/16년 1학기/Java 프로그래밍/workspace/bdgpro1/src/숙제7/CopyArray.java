package ¼÷Á¦7;

public class CopyArray {
	static int[] copyArray(int[] a){
		int[] temp = new int[a.length];
		temp = a;
		return temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={1,2,34,5};
		copyArray(a);
		System.out.println(copyArray(a) [1]);

	}

}
