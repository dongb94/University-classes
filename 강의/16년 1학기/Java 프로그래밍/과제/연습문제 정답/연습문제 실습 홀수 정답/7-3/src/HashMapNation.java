import java.util.*;

public class HashMapNation {
	public static void main(String[] args) {
		HashMap<String, Integer> nations = new HashMap<String, Integer>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("나라 이름과 인구를 10개 입력하세요.(예: Korea 5000)");
		for(int i=0; i<10; i++) {
			System.out.print("나라 이름, 인구 >> ");		
			String nation = scanner.next();
			int population = scanner.nextInt();
			nations.put(nation, population);
		}
		
		System.out.println("나라 이름을 입력하면 인구를 검색할 수 있습니다. 끝을 입력하면 종료합니다.");

		while(true) {
			System.out.print("나라 이름 >> ");
			String nation = scanner.next();
			if(nation.equals("끝"))
				break;
			Integer n = nations.get(nation);
			if(n == null)
				System.out.println(nation + " 나라는 없습니다.");
			else 
				System.out.println(nation + "의 인구는 " + n); 
		}
	}

}
