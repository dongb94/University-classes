package ¼÷Á¦7;

public class DoWhile {
	static int[] temp;
	static int[] copyrray(int[] a){
		temp = new int[a.length];
		temp = a;
		return temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 1;
		do while(k < 1)
				System.out.println("k is " + k);
		while(k > 1);
		System.out.println("while is over");
		int[] intArray = new int[] {};
		for(int i : intArray)
			System.out.println(i);
		int [] a = {33, 32, 31, 30, 29};
		int[] arr = {1,2,3,4,5,6,7,8,9}; 
		int sum=0;
		for(int i : arr)
			sum+=i;
		System.out.println(sum/arr.length);
		copyrray(a);
		for(int i:temp)
		System.out.println(i);
		for(int i:a)
			System.out.println(i);
		temp=a;
		for(int i:temp)
			System.out.println(i);
	}

}
