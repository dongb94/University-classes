import java.util.*;

public class StudentManager {
	public static void main (String[] args) {
		ArrayList<Student> dept = new ArrayList<Student>();
		Scanner sin = new Scanner(System.in);
		System.out.println("학생 정보를 입력하세요.");
		for (int i=0; i<5; i++) {
			System.out.print(i + "이름>>");
			String name = sin.next();
			System.out.print(i + "학과>>");
			String department = sin.next();
			System.out.print(i + "학번>>");
			String id = sin.next();
			System.out.print(i + "학점평균>>");
			double grade = sin.nextDouble();
			Student st = new Student(name, department, id, grade);
			dept.add(st);
		}
		Iterator<Student> it = dept.iterator();
		while (it.hasNext()) {
			Student st = it.next();
			if (st != null) {
				System.out.println("---------------------------");
				System.out.println("이름:" + st.getName());
				System.out.println("학과:" + st.getDepartment());
				System.out.println("학번:" + st.getId());
				System.out.println("학점평균:" + st.getGrade());
				System.out.println("---------------------------");
			}
		}
	}
}
