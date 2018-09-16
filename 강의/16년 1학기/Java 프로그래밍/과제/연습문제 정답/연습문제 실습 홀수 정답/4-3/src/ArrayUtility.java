public class ArrayUtility {
	static double[] intToDouble(int[] source) {
		double d[] = new double[source.length];	// 인자로 넘어온 정수형 배열과 동일한 크기의 배정도 실수형 배열 생성
		for (int i=0; i<source.length; i++)
			d[i] = source[i]; // 정수값을 실수로 변환하여 배열에 저장
		return d;
	}
	
	static int[] doubleToInt(double[] source) {
		int i[] = new int[source.length];	// 인자로 넘어온 배정도 실수형 배열과 동일한 크기의 정수형 배열 생성
		for (int j=0; j<source.length; j++)
			i[j] = (int) source[j]; // 배정도 실수값을 정수로 변환하여 배열에 저장
		return i;		
	}
	
	public static void main (String args[])  {
		double d[] = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 10.10};
		int i[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		double tmp_double[] = intToDouble(i);
		for (int j=0; j<tmp_double.length; j++) System.out.println(tmp_double[j]);
		int tmp_int[] = doubleToInt(d);
		for (int j=0; j<tmp_int.length; j++) System.out.println(tmp_int[j]);
	}
}
