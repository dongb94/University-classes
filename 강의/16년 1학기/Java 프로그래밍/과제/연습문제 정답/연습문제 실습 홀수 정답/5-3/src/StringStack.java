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
		if(index == 0) // 스택이 비었음
			return null;
		index--; // 스택 포인터 감소
		return element[index];
	}

	@Override
	public boolean push(Object ob) {
		if(index == element.length)
			return false; // 스택이 다 찼음
		element[index++] = (String)ob; // 요소 스택에 저장 후 스택 포인터 증가
		return true;
	}
}
