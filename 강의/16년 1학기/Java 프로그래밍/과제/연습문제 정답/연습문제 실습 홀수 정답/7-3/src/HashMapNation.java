import java.util.*;

public class HashMapNation {
	public static void main(String[] args) {
		HashMap<String, Integer> nations = new HashMap<String, Integer>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("���� �̸��� �α��� 10�� �Է��ϼ���.(��: Korea 5000)");
		for(int i=0; i<10; i++) {
			System.out.print("���� �̸�, �α� >> ");		
			String nation = scanner.next();
			int population = scanner.nextInt();
			nations.put(nation, population);
		}
		
		System.out.println("���� �̸��� �Է��ϸ� �α��� �˻��� �� �ֽ��ϴ�. ���� �Է��ϸ� �����մϴ�.");

		while(true) {
			System.out.print("���� �̸� >> ");
			String nation = scanner.next();
			if(nation.equals("��"))
				break;
			Integer n = nations.get(nation);
			if(n == null)
				System.out.println(nation + " ����� �����ϴ�.");
			else 
				System.out.println(nation + "�� �α��� " + n); 
		}
	}

}
