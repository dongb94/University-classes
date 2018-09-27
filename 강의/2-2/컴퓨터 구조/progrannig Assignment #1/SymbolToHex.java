package progrmming_Assign_1;

public class SymbolToHex {

	public static void main(String[] args) {
		String M[] = { "AND", "ADD", "LDA", "STA", "BUN", "BSA", "ISZ", // 0~6xxx,8~Exxx

				"CLA", "CLE", "CMA", "CME", "CIR", "CIL", "INC", "SPA", "SNA", "SZA", "SZE", "HLT",
				// 7xxx

				"INP", "OUT", "SKI", "SKO", "ION", "IOF", // Fxxx

				"nop"// �ش���� ����
		};// INPUT���� �� Symbol���� �迭
		
		System.out.printf("%8s%12s%12s\n", "Location", "Symbol", "Hex Input");

		for (int i = 0; i < 26; i++) {
			String indirect=indirect();
			// indirect bit�� �������� �����ϴ� �޼ҵ� ȣ��
			
			if(i>6) indirect=" ";
			
			System.out.printf("%8s", Integer.toString(i + 1000).substring(1));
			// �ε��� ���

			System.out.printf("%12s", indirect+" "+M[i]);
			// instruction �ɺ� ���

			System.out.printf("%12s\n", symbolCheck(M[i],indirect));
			// instruction �ɺ��� ����Ű�� 16���� �ڵ带 ��ȯ�ϴ� �޼ҵ� ���
		}
	}
	
	private static String indirect(){// indirect bit�� �������� �����ϴ� �޼ҵ�
		if(Math.random()<0.5)
			return "I";
		else
			return " ";
	}

	private static String symbolCheck(String symbol,String indirect) {

		String HexCode = "nop";
		// 16���� �ڵ带 nop���� ������ �� input�� ���� �ٲ۴�
		
		String address = Integer.toHexString((int)(Math.random()*0x1000) + 0x1000).substring(1);
		// �ּҿ� 0x000~0xFFF ������ ���� �������� �ִ´�. 
		
		if (indirect.equals("I")) {
			switch (symbol) {
			case "AND":
				HexCode = "8"+address;
				break;
			case "ADD":
				HexCode = "9"+address;
				break;
			case "LDA":
				HexCode = "a"+address;
				break;
			case "STA":
				HexCode = "b"+address;
				break;
			case "BUN":
				HexCode = "c"+address;
				break;
			case "BSA":
				HexCode = "d"+address;
				break;
			case "ISZ":
				HexCode = "e"+address;
				break;
			case "CLA":
				HexCode = "7800";
				break;
			case "CLE":
				HexCode = "7400";
				break;
			case "CMA":
				HexCode = "7200";
				break;
			case "CME":
				HexCode = "7100";
				break;
			case "CIR":
				HexCode = "7080";
				break;
			case "CIL":
				HexCode = "7040";
				break;
			case "INC":
				HexCode = "7020";
				break;
			case "SPA":
				HexCode = "7010";
				break;
			case "SNA":
				HexCode = "7008";
				break;
			case "SZA":
				HexCode = "7004";
				break;
			case "SZE":
				HexCode = "7002";
				break;
			case "HLT":
				HexCode = "7001";
				break;
			case "INP":
				HexCode = "f800";
				break;
			case "OUT":
				HexCode = "f400";
				break;
			case "SKI":
				HexCode = "f200";
				break;
			case "SKO":
				HexCode = "f100";
				break;
			case "ION":
				HexCode = "f080";
				break;
			case "IOF":
				HexCode = "f040";
				break;
			}
		}
		else{
			switch (symbol) {
			case "AND":
				HexCode = "0"+address;
				break;
			case "ADD":
				HexCode = "1"+address;
				break;
			case "LDA":
				HexCode = "2"+address;
				break;
			case "STA":
				HexCode = "3"+address;
				break;
			case "BUN":
				HexCode = "4"+address;
				break;
			case "BSA":
				HexCode = "5"+address;
				break;
			case "ISZ":
				HexCode = "6"+address;
				break;
			case "CLA":
				HexCode = "7800";
				break;
			case "CLE":
				HexCode = "7400";
				break;
			case "CMA":
				HexCode = "7200";
				break;
			case "CME":
				HexCode = "7100";
				break;
			case "CIR":
				HexCode = "7080";
				break;
			case "CIL":
				HexCode = "7040";
				break;
			case "INC":
				HexCode = "7020";
				break;
			case "SPA":
				HexCode = "7010";
				break;
			case "SNA":
				HexCode = "7008";
				break;
			case "SZA":
				HexCode = "7004";
				break;
			case "SZE":
				HexCode = "7002";
				break;
			case "HLT":
				HexCode = "7001";
				break;
			case "INP":
				HexCode = "f800";
				break;
			case "OUT":
				HexCode = "f400";
				break;
			case "SKI":
				HexCode = "f200";
				break;
			case "SKO":
				HexCode = "f100";
				break;
			case "ION":
				HexCode = "f080";
				break;
			case "IOF":
				HexCode = "f040";
				break;
			}
		}
		return HexCode;
	}

}
