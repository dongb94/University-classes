package wrapper_16;

public class Number_30 {
	public static void main(String[] args) {
		Long i1 = new Long("82");
		Long i2 = new Long(82);
		Short j1 = new Short("82");
		short s = 82;
		Short j2 = new Short(s);
		Integer k1 = new Integer("82");
		Integer k2 = new Integer(82);
		System.out.println(i1 == i2); // ��
		System.out.println(i1.equals(i2)); // ��
		System.out.println(i1.equals(j1)); // ��
		System.out.println(i1.equals(j2)); // ��
		System.out.println(i1.equals(k1)); // ��
		System.out.println(i1.equals(k2)); // ��
	}

}
