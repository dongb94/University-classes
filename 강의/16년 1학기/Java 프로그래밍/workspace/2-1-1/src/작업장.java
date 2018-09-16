
public class ÀÛ¾÷Àå {

	public static void main(String[] args) {
		int[] k = {3,4,5,6};
		System.out.println(sum(k, k.length));
		
		System.out.println('a'+'b');
	}
	
	
	static int sum(int[] a, int leng){
		int tot=0;
		for(int i=0;i<leng;i++)
			tot+=a[i];
		return tot;



	}

}
