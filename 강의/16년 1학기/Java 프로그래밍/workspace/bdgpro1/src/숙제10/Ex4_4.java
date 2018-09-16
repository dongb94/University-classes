package ¼÷Á¦10;
class ArrayUtility2{
	static int[] concat(int[] s1, int[] s2){
		int[] n=new int[s1.length];
		for(int i=0; i<s1.length; i++)
			n[i]=10*s1[i]+s2[i];
		return n;
	}
	static int[] remove(int[] s1,int[] s2){
		int[] n=new int[s1.length];
		for(int i=0; i<s1.length; i++){
			n[i]=s1[i];
			for(int j:s2)
				if(n[i]==j)
					n[i]=0;
		}
		return n;
	}
}
public class Ex4_4 {
	static void print(int[] a){
		for(int i:a){
			System.out.print(i+"\t");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] s1={1,2,3,4,5};
		int[] s2={1,3,5,7,9};
		
		int[] cc=new int[s1.length];
		int[] rm=new int[s1.length];
		
		ArrayUtility2 ch=new ArrayUtility2();
		cc=ch.concat(s1,s2);
		rm=ch.remove(s1, s2);
		System.out.print("concat=");
		print(cc);
		System.out.print("remove=");
		print(rm);
	}
}
