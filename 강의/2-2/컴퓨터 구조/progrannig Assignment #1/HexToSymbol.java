package progrmming_Assign_1;

public class HexToSymbol {
public static void main(String[] args) {
		
		int[] M = new int[100];

		randomArray(M); // 배열에 21개의 랜덤값을 채워 넣는 메소드
		
		System.out.printf("%8s%12s%19s\n","Location","Hex Input","Symbol Address");

		for(int i = 0; i < 21; i ++){
			System.out.printf("%8s", Integer.toString(i + 1000).substring(1));  
			// 인덱스 출력
			
			System.out.printf("%12s", Integer.toHexString(M[i] + 0x10000).substring(1)); 
			// 16진수 코드 출력
			
			System.out.printf("%19s\n", symbolCheck(M[i])); 
			// instruction 심볼 + 가리키는 주소값 String 을 리턴하는 메소드 출력
		}
		
	}

	private static void randomArray(int[] arr) { // 배열에 21개의 랜덤값을 채워 넣는 메소드

		for(int i = 0; i < 21; i ++)
			arr[i] =(int)(Math.random()*0x10000);
		// 0x0000 ~ 0xffff 범위의 랜덤한 값을 입력
		
	}

	private static String symbolCheck(int a) { 
		//instruction 값인지 체크해 심볼을 문자열로 반환하는 메소드
		
		int head = a / 0x1000 ; 
		//16진수의 맨 앞을 얻음 ex) 0x1234 이면 head = 1
		
		int indirect = head / 8; 
		//indirect bit 를 얻음 ex) 0~7로 시작하면 0, 8~f로 시작하면 1
		
		String symbol = "nop";
		//symbol을 nop 으로 설정한 후 조건에 따라 바꾼다.
		
		String address = Integer.toHexString(a + 0x10000).substring(2);	
		//주소값을 미리 넣는다.
		
		if(head == 7){ // 7xxx 
			address = "  -"; //주소를 없앤다
			
			switch( a & 0x0FFF){ //뒷자리를 비교한다.
			case 0x800:
				symbol = "CLA";
				break;
			case 0x400:
				symbol = "CLE";
				break;
			case 0x200:
				symbol = "CMA";
				break;
			case 0x100:
				symbol = "CME";
				break;
			case 0x80:
				symbol = "CIR";
				break;
			case 0x40:
				symbol = "CIL";
				break;
			case 0x20:
				symbol = "INC";
				break;
			case 0x10:
				symbol = "SPA";
				break;
			case 0x8:
				symbol = "SNA";
				break;
			case 0x4:
				symbol = "SZA";
				break;
			case 0x2:
				symbol = "SZE";
				break;
			case 0x1:
				symbol = "HLT";
				break;
			}
		}
		else if(head == 0xf){ // fxxx
			address = "  -"; //주소를 없앤다
			
			switch( a & 0x0FFF){ //뒷자리를 비교한다.
			case 0x800:
				symbol = "INP";
				break;
			case 0x400:
				symbol = "OUT";
				break;
			case 0x200:
				symbol = "SKI";
				break;
			case 0x100:
				symbol = "SKO";
				break;
			case 0x80:
				symbol = "ION";
				break;
			case 0x40:
				symbol = "IOF";
				break;
			}
		}
		else{

			switch( head % 8){ // 
			case 0: //  (a=0xxx, a=8xxx)
				symbol = "AND";
				break;
			case 1: // (1xxx, 9xxx)
				symbol = "ADD";
				break;
			case 2: // (2xxx, Axxx)
				symbol = "LDA";
				break;
			case 3: // (3xxx, Bxxx)
				symbol = "STA";
				break;
			case 4:
				symbol = "BUN";
				break;
			case 5:
				symbol = "BSA";
				break;
			case 6:
				symbol = "ISZ";
				break;
			}
			if (indirect == 1) // indirect bit 가 1 이면 간접 주소임을 표시한다.
				symbol = "I " + symbol;
		}

		return symbol + "     " + address; // symbol + 주소값 반환

	}
}