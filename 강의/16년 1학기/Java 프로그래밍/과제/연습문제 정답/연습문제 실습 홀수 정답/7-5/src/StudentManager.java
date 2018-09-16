import java.util.*;

public class StudentManager {
	public static void main (String[] args) {
		ArrayList<Student> dept = new ArrayList<Student>();
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
			dept.add(st);
		}
		Iterator<Student> it = dept.iterator();
		while (it.hasNext()) {
			Student st = it.next();
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
}
