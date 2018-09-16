import java.util.*;

public class StudentManager {
	public static void main (String[] args) {
		HashMap<String, Student> dept = new HashMap<String,Student>();
		Scanner sin = new Scanner(System.in);
		System.out.println("�л� ������ �Է��ϼ���.");
		for (int i=0; i<5; i++) {
			System.out.print(i + "�̸�>>");
			String name = sin.next();
			System.out.print(i + "�а�>>");
			String department = sin.next();
			System.out.print(i + "�й�>>");
			String id = sin.next();
			System.out.print(i + "�������>>");
			double grade = sin.nextDouble();
			Student st = new Student(name, department, id, grade);
			dept.put(id, st);
		}
		System.out.println("�Ʒ��� �˻��� �л��� �й��� �Է��ϰų� �����Ϸ��� ctrl-z�� �Է��ϼ���.");
		String id;
		try {
			while (true) {
				id = sin.next();
				Student st = dept.get(id);
				if (st != null) {
					System.out.println("---------------------------");
					System.out.println("�̸�:" + st.getName());
					System.out.println("�а�:" + st.getDepartment());
					System.out.println("�й�:" + st.getId());
					System.out.println("�������:" + st.getGrade());
					System.out.println("---------------------------");
				}
			}
		}
		catch (NoSuchElementException e) {} // ctrl-Z�� �Է��ϸ� ����
	}
}
