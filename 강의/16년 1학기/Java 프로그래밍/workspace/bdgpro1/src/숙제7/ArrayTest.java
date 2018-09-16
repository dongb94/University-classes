package ¼÷Á¦7;

public class ArrayTest {
	static void print(int[][] a){
		for (int i[]:a){
			for (int j : i)
				System.out.print(" "+j);
			System.out.println();
		}
	}
	static void pr(int[] a){
		for (int i:a){
				System.out.println(i);
		}
	}
	public static void main(String[] args) {
		int[][] a1 = new int[3][3];
		int[][] a2 = new int[2][2];
		int b = 9;
		int a3 [][][][] = new int[2][3][2][2];
		a3[1][1]= a2;
		print(a3[1][1]);
		print(a2);
		System.out.println();
		a1[1][0]= b;
		System.out.println(a1[1][0]);
		System.out.println();
		a3[1][1] = a1;
		print(a3[1][1]);
		a3[1][1][0][1] = a1[1][0];
		a3[1][1] = a1;
		int[ ][ ] a;
		a = new int[255][ ];
		int[] c = new int[9];
		a[0] = c;
		System.out.println();
		
		int[][] alpha=new int[10][20];
		for(int i=0; i<alpha.length; i++)
			for(int j=0; j<alpha[i].length; j++)
				alpha[i][j]= i==0?5:2*alpha[i-1][j];
		print(alpha);
		
		for(int j=0; j<alpha[0].length; j++){
			for (int i[]:alpha)
				System.out.print(" "+i[j]);
			System.out.println();
		}
	}
}
