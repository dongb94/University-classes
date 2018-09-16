import java.util.*;

public class StudentManager {
	public static void main (String[] args) {
		HashMap<String, Student> dept = new HashMap<String,Student>();
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
			dept.put(id, st);
		}
		System.out.println("아래에 검색할 학생의 학번을 입력하거나 종료하려면 ctrl-z를 입력하세요.");
		String id;
		try {
			while (true) {
				id = sin.next();
				Student st = dept.get(id);
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
		catch (NoSuchElementException e) {} // ctrl-Z를 입력하면 끝냄
	}
}
