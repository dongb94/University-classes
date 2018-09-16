package ¼÷Á¦7;

public class SumArr {
	public static void main(String[] args) {
	      int k = sum(new int[]{3,4,5,6});
	      System.out.println(k);
	   }
	   static int sum(int[] a){
	      int tot=0;
	      for(int i=0;i<a.length;i++)
	          tot+=a[i];
	      return tot;
	   }
}
