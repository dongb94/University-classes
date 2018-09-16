package wrapper_16;
class LinearSearch {
	public static int search(Object[] x, Object key) {
		// x에서 key의 위치를 찾는다
		for (int i = 0; i < x.length; i++)
			if (x[i].equals(key))
				return i; // i 는 키의 위치
			return -1; // 키를 못 찾으면 -1 리턴
	}
}
public class Number_16 {

	public static void main(String[] args) {
		Integer[ ] numbers = {22, 55, 33, 66};
		int place = LinearSearch.search (numbers, 55);
	}

}
