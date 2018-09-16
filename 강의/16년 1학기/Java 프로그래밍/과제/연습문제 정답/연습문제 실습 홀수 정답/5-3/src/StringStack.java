public class StringStack implements Stack {
	private String[] element;
	private int index;
	public StringStack(int capacity)
	{
		element = new String[capacity];
		index = 0;
	}
	@Override
	public int length() {
		// TODO Auto-generated method stub
		return element.length;
	}

	@Override
	public Object pop() {
		if(index == 0) // ������ �����
			return null;
		index--; // ���� ������ ����
		return element[index];
	}

	@Override
	public boolean push(Object ob) {
		if(index == element.length)
			return false; // ������ �� á��
		element[index++] = (String)ob; // ��� ���ÿ� ���� �� ���� ������ ����
		return true;
	}
}
