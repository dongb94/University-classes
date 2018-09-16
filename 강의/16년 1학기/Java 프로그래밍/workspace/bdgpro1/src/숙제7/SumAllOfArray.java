package ¼÷Á¦7;

public class SumAllOfArray {
	public static void main(String[] args){
		int[][] arr = { {1,2,3,4}, {5,6,7,8}, {9,10,11,12} };
		int sum=0, num=0;
		for(int i[] : arr){
			num+=i.length;
			for(int j : i)
				sum+=j;
		}
		System.out.println(sum/num);
		for(int i[] : arr){
			int su=0;
			for(int j : i)
				su+=j;
			System.out.println((double)su/i.length);
			}


	}

}
