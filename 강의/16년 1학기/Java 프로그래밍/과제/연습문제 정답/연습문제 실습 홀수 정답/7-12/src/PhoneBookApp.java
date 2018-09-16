import java.io.*;
import java.util.*;

public class PhoneBookApp {
	// �޴� ��ȣ�� ���� ����� �����Ѵ�.
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
	
	 // ��ȭ��ȣ ���� �޼ҵ�
	public void run() {
		readPhoneBook();
		System.out.println("-------------------------------------------------");
		System.out.println("��ȭ��ȣ ���� ���α׷��� �����մϴ�. ���Ϸ� �����մϴ�.");
		System.out.println("-------------------------------------------------");
		while(true) {
			System.out.print("����:0. ����:1, ã��:2, ��ü����:3, ���� ����:4, ����:5>>");
			int menu = readNumber();
			switch(menu) {
				case INSERT: insert(); break;
				case DELETE: delete(); break;
				case SEARCH: search(); break;
				case SHOWALL: showAll(); break;	
				case FILESAVE: saveFile(); break;
				case EXIT: 	System.out.println("���α׷��� �����մϴ�..."); return;					
				default: System.out.println("�Է��� Ʋ�Ƚ��ϴ�. �ٽ� �Է��ϼ���."); continue;
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
					break; // ���� ���� ������ ���
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

	// ���� �޴��� �����ϸ� �ϳ��� ��ȭ ��ȣ ���ڵ带 �����Ѵ�.
	private void insert() {
		System.out.print("�̸�>>");
		String name = scanner.next();
		if(table.get(name)!=null) {
			System.out.println("�̹� �����ϴ� ����Դϴ�.");
			return;
		}
		
		System.out.print("�ּ�>>");
		String address = scanner.next();
		System.out.print("��ȭ��ȣ>>");
		String telNum = scanner.next();		
		
		// �ؽ� ���̺� ����
		table.put(name, new Phone(name, address, telNum));
	}
	
	// ���� �޴��� �����ϸ� �ϳ��� ��ȭ ��ȣ ���ڵ带 �����Ѵ�.
	private void delete() {
		System.out.print("�̸�>>");
		String name = scanner.next();
		Phone p = table.remove(name); // �ؽ� ���̺��� ����
		if(p == null)
			System.out.println(name +"�� ��ϵ��� ���� ����Դϴ�.");
		else {
			System.out.println(name+"�� �����Ǿ����ϴ�.");
		}
	}
	
	// ã�� �޴��� �����ϸ� �ϳ��� ��ȭ ��ȣ ���ڵ带 �˻��Ѵ�.
	private void search() {
		System.out.print("�̸�>>");
		String name = scanner.next();
		Phone p = table.get(name); // �ؽ����̺��� �˻�
		if(p == null)
			System.out.println(name +"�� ��ϵ��� ���� ����Դϴ�.");
		else
			System.out.println(p.toString());
	}
	
	// ��ü���� �޴��� �����Ѵ�.
	private void showAll() {
		// ������ �� �ٷ� �����ε� �����ϴ�. �׷��� �ٽ� �ۼ���
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

// �ϳ��� ��ȭ ��ȣ ������ ������ Ŭ����
class Phone {
	private String name; // �̸�
	private String address; // �ּ�
	private String telNum; // ��ȭ ��ȣ
	
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