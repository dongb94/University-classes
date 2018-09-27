package progrmming_Assign_1;

public class SymbolToHex {

	public static void main(String[] args) {
		String M[] = { "AND", "ADD", "LDA", "STA", "BUN", "BSA", "ISZ", // 0~6xxx,8~Exxx

				"CLA", "CLE", "CMA", "CME", "CIR", "CIL", "INC", "SPA", "SNA", "SZA", "SZE", "HLT",
				// 7xxx

				"INP", "OUT", "SKI", "SKO", "ION", "IOF", // Fxxx

				"nop"// 해당되지 않음
		};// INPUT으로 들어갈 Symbol들의 배열
		
		System.out.printf("%8s%12s%12s\n", "Location", "Symbol", "Hex Input");

		for (int i = 0; i < 26; i++) {
			String indirect=indirect();
			// indirect bit을 렌덤으로 설정하는 메소드 호출
			
			if(i>6) indirect=" ";
			
			System.out.printf("%8s", Integer.toString(i + 1000).substring(1));
			// 인덱스 출력

			System.out.printf("%12s", indirect+" "+M[i]);
			// instruction 심볼 출력

			System.out.printf("%12s\n", symbolCheck(M[i],indirect));
			// instruction 심볼이 가리키는 16진수 코드를 반환하는 메소드 출력
		}
	}
	
	private static String indirect(){// indirect bit을 렌덤으로 설정하는 메소드
		if(Math.random()<0.5)
			return "I";
		else
			return " ";
	}

	private static String symbolCheck(String symbol,String indirect) {

		String HexCode = "nop";
		// 16진수 코드를 nop으로 설정한 후 input에 따라 바꾼다
		
		String address = Integer.toHexString((int)(Math.random()*0x1000) + 0x1000).substring(1);
		// 주소에 0x000~0xFFF 사이의 값을 무작위로 넣는다. 
		
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
