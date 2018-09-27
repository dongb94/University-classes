package progrmming_Assign_1;

public class HexToSymbol {
public static void main(String[] args) {
		
		int[] M = new int[100];

		randomArray(M); // �迭�� 21���� �������� ä�� �ִ� �޼ҵ�
		
		System.out.printf("%8s%12s%19s\n","Location","Hex Input","Symbol Address");

		for(int i = 0; i < 21; i ++){
			System.out.printf("%8s", Integer.toString(i + 1000).substring(1));  
			// �ε��� ���
			
			System.out.printf("%12s", Integer.toHexString(M[i] + 0x10000).substring(1)); 
			// 16���� �ڵ� ���
			
			System.out.printf("%19s\n", symbolCheck(M[i])); 
			// instruction �ɺ� + ����Ű�� �ּҰ� String �� �����ϴ� �޼ҵ� ���
		}
		
	}

	private static void randomArray(int[] arr) { // �迭�� 21���� �������� ä�� �ִ� �޼ҵ�

		for(int i = 0; i < 21; i ++)
			arr[i] =(int)(Math.random()*0x10000);
		// 0x0000 ~ 0xffff ������ ������ ���� �Է�
		
	}

	private static String symbolCheck(int a) { 
		//instruction ������ üũ�� �ɺ��� ���ڿ��� ��ȯ�ϴ� �޼ҵ�
		
		int head = a / 0x1000 ; 
		//16������ �� ���� ���� ex) 0x1234 �̸� head = 1
		
		int indirect = head / 8; 
		//indirect bit �� ���� ex) 0~7�� �����ϸ� 0, 8~f�� �����ϸ� 1
		
		String symbol = "nop";
		//symbol�� nop ���� ������ �� ���ǿ� ���� �ٲ۴�.
		
		String address = Integer.toHexString(a + 0x10000).substring(2);	
		//�ּҰ��� �̸� �ִ´�.
		
		if(head == 7){ // 7xxx 
			address = "  -"; //�ּҸ� ���ش�
			
			switch( a & 0x0FFF){ //���ڸ��� ���Ѵ�.
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
			address = "  -"; //�ּҸ� ���ش�
			
			switch( a & 0x0FFF){ //���ڸ��� ���Ѵ�.
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
			if (indirect == 1) // indirect bit �� 1 �̸� ���� �ּ����� ǥ���Ѵ�.
				symbol = "I " + symbol;
		}

		return symbol + "     " + address; // symbol + �ּҰ� ��ȯ

	}
}