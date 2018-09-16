import java.io.*;
import java.util.*;

public class PhoneBookApp {
	// 메뉴 번호를 위한 상수를 정의한다.
	final int INSERT = 0;
	final int DELETE = 1;
	final int SEARCH = 2;
	final int SHOWALL = 3;
	final int FILESAVE = 4;
	final int EXIT = 5;		
	
	private Scanner scanner;
	private BufferedReader br = null; 
	private BufferedWriter bw = null;
	private Hashtable<String, Phone> table = new Hashtable<String, Phone>();
		
	public PhoneBookApp() {
		scanner = new Scanner(System.in);		
	}
	
	 // 전화번호 관리 메소드
	public void run() {
		readPhoneBook();
		System.out.println("-------------------------------------------------");
		System.out.println("전화번호 관리 프로그램을 시작합니다. 파일로 저장합니다.");
		System.out.println("-------------------------------------------------");
		while(true) {
			System.out.print("삽입:0. 삭제:1, 찾기:2, 전체보기:3, 파일 저장:4, 종료:5>>");
			int menu = readNumber();
			switch(menu) {
				case INSERT: insert(); break;
				case DELETE: delete(); break;
				case SEARCH: search(); break;
				case SHOWALL: showAll(); break;	
				case FILESAVE: saveFile(); break;
				case EXIT: 	System.out.println("프로그램을 종료합니다..."); return;					
				default: System.out.println("입력이 틀렸습니다. 다시 입력하세요."); continue;
			}
		}	
	}
	
	private void readPhoneBook() {
		try {
			br = new BufferedReader(new FileReader("phonebook.dat"));
		} catch (FileNotFoundException e) {
			return;
		}
		while (true) {
			String name = null;
			String address = null;
			String telNum = null;

			try {
				name = (String)br.readLine();
				address = (String)br.readLine();
				telNum = (String)br.readLine();
				if (name != null && address != null && telNum != null)
					table.put(name, new Phone(name, address, telNum));
				else {
					br.close();
					break; // 파일 끝에 도달한 경우
				}
			} 
			catch (IOException e) {
				System.exit(1);
			}
		}
	}

	private void saveFile() {
		try {
			bw = new BufferedWriter(new FileWriter("phonebook.dat", false));
		} catch (FileNotFoundException e) {
			return;
		} catch (IOException e) {
			return;
		}

		Enumeration<String> e = table.keys();
		while(e.hasMoreElements()) {
			String name = e.nextElement();
			Phone p = table.get(name);
			try {
				bw.write(name+"\n");
				bw.write(p.getAddress()+"\n");
				bw.write(p.getTelNum()+"\n");
			} catch (IOException e1) {
				System.exit(1);
			}	
		}
		try {
			bw.close();
		} catch (IOException e1) {
		}
	}

	// 삽입 메뉴를 구현하며 하나의 전화 번호 레코드를 저장한다.
	private void insert() {
		System.out.print("이름>>");
		String name = scanner.next();
		if(table.get(name)!=null) {
			System.out.println("이미 존재하는 사람입니다.");
			return;
		}
		
		System.out.print("주소>>");
		String address = scanner.next();
		System.out.print("전화번호>>");
		String telNum = scanner.next();		
		
		// 해쉬 테이블에 삽입
		table.put(name, new Phone(name, address, telNum));
	}
	
	// 삭제 메뉴를 구현하며 하나의 전화 번호 레코드를 삭제한다.
	private void delete() {
		System.out.print("이름>>");
		String name = scanner.next();
		Phone p = table.remove(name); // 해쉬 테이블에서 삭제
		if(p == null)
			System.out.println(name +"는 등록되지 않은 사람입니다.");
		else {
			System.out.println(name+"은 삭제되었습니다.");
		}
	}
	
	// 찾기 메뉴를 구현하며 하나의 전화 번호 레코드를 검색한다.
	private void search() {
		System.out.print("이름>>");
		String name = scanner.next();
		Phone p = table.get(name); // 해쉬테이블에서 검색
		if(p == null)
			System.out.println(name +"는 등록되지 않은 사람입니다.");
		else
			System.out.println(p.toString());
	}
	
	// 전체보기 메뉴를 구현한다.
	private void showAll() {
		// 다음의 한 줄로 만으로도 가능하다. 그러나 다시 작성함
		//System.out.println(table.toString());
	
		Enumeration<String> e = table.keys();
		while(e.hasMoreElements()) {
			String name = e.nextElement();
			Phone p = table.get(name);
			System.out.println(p.toString());
		}
	}
	
	private int readNumber() {
		int n=-1;
		try {
			n = scanner.nextInt();
		}
		catch(InputMismatchException e) {
			return -1;
		}
		return n;
	}

	public static void main(String args[]) {
		PhoneBookApp pb = new PhoneBookApp();
		pb.run();
	}
}

// 하나의 전화 번호 정보를 가지는 클래스
class Phone {
	private String name; // 이름
	private String address; // 주소
	private String telNum; // 전화 번호
	
	public Phone(String name, String address, String telNum) {
		this.name = name;
		this.address = address;
		this.telNum = telNum;
	}
	
	public String getName() {return name;}
	public String getAddress() {return address;}
	public String getTelNum() {return telNum;}	
	
	public String toString() {
		return name + " " + address + " " + telNum;
	}
}