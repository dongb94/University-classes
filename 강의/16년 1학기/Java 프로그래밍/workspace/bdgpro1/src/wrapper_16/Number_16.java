package wrapper_16;
class LinearSearch {
	public static int search(Object[] x, Object key) {
		// x���� key�� ��ġ�� ã�´�
		for (int i = 0; i < x.length; i++)
			if (x[i].equals(key))
				return i; // i �� Ű�� ��ġ
			return -1; // Ű�� �� ã���� -1 ����
	}
}
public class Number_16 {

	public static void main(String[] args) {
		Integer[ ] numbers = {22, 55, 33, 66};
		int place = LinearSearch.search (numbers, 55);
	}

}
