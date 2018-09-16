package 숙제10;
import java.util.Scanner;
public class Ex4_6 {
	static Ex4_6 book=new Ex4_6();
	static int end_switch=0;
	static String[] S=new String[10];
	static String[] A=new String[10];
	static String[] B=new String[10];
	public void print(String[] some){
		for(String i:some)
			System.out.print(i+"\t");
		System.out.println();
	}
	public void choice(){
		Scanner s=new Scanner(System.in);
		int insert;
		System.out.print("<1>예약 <2>조회 <3>취소 <4>종료 >>");
		insert=s.nextInt();
		switch(insert){
		case 1 : book.booking();
		break;
		case 2 : book.check();
		break;
		case 3 : book.cancle();
		break;
		case 4 : end_switch=1;
		break;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}
	public void booking(){
		Scanner s=new Scanner(System.in);
		int insert,number;
		String name;
		System.out.print("<1>S <2>A <3>B >>");
		insert=s.nextInt();
		switch(insert){
		case 1 : print(S);
		System.out.print("이름>>");
		name = s.next();
		System.out.print("번호>>");
		number = s.nextInt();
		if(number<=10){
			S[number-1]=name;
		}
		else System.out.println("잘못된 번호입니다.");
		break;
		case 2 : print(A);
		System.out.print("이름>>");
		name = s.next();
		System.out.print("번호>>");
		number = s.nextInt();
		if(number<=10){
			A[number-1]=name;
		}
		else System.out.println("잘못된 번호입니다.");
		break;
		case 3 : print(B);
		System.out.print("이름>>");
		name = s.next();
		System.out.print("번호>>");
		number = s.nextInt();
		if(number<=10){
			B[number-1]=name;
		}
		else System.out.println("잘못된 번호입니다.");
		break;
		default : System.out.println("잘못 입력하셨습니다.");
		} 
	}
	public void check(){
		System.out.print("S>>\t");
		print(S);
		System.out.print("A>>\t");
		print(A);
		System.out.print("B>>\t");
		print(B);
	}

	public void cancle(){
		Scanner s=new Scanner(System.in);
		int insert;
		String name;
		System.out.print("<1>S <2>A <3>B >>");
		insert=s.nextInt();

		switch(insert){
		case 1 : print(S);
		System.out.print("이름>>");
		name = s.next();

		int del_countS=0;
		for(int i=0; i<10; i++){
			if(S[i].equals(name)){
				S[i]="___";
				del_countS++;
			}
		}
		if(del_countS==0) System.out.println("잘못되거나 없는 이름입니다.");
		break;
		case 2 : print(A);
		System.out.print("이름>>");
		name = s.next();
		int del_countA=0;
		for(int i=0; i<10; i++){
			if(A[i].equals(name)){
				A[i]="___";
				del_countA++;
			}
		}
		if(del_countA==0) System.out.println("잘못되거나 없는 이름입니다.");
		break;
		case 3 : print(B);
		System.out.print("이름>>");
		name = s.next();
		int del_count=0;
		for(int i=0; i<10; i++){
			if(B[i].equals(name)){
				B[i]="___";
				del_count++;
			}
		}
		if(del_count==0) System.out.println("잘못되거나 없는 이름입니다.");
		break;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}

	public static void main(String[] arge){
		for(int i=0; i<10; i++){
			S[i]="___";
			A[i]="___";
			B[i]="___";
		}
		while(end_switch==0){
			book.choice();
		}
	}
} 