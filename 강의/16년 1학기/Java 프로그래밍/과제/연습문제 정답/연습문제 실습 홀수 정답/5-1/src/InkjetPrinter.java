public class InkjetPrinter extends Printer {
	static final int amountOfInkToPrint = 5;
	private int amountOfInk;
	public InkjetPrinter(String modelName, String manufacturer, int type, int numberOfPaper, int amountOfInk) {
		super(modelName, manufacturer, type, numberOfPaper);
		this.amountOfInk = amountOfInk;
	}

	public int getAmountOfInk() {
		return amountOfInk;
	}
	@Override
	public boolean print() {
		if (amountOfInk <= 0) {
			System.out.println("잉크가 부족합니다.");
			return false;
		}
		if (numberOfPaper <= 0) {
			System.out.println("인쇄 용지가 부족합니다.");
			return false;
		}
		System.out.println("잉크젯 프린터 출력");
		amountOfInk -= amountOfInkToPrint; // 잉크 잔량 감소
		numberOfPaper--; // 남은 종이 매수 감소
		numberOfPrinted++; // 인쇄한 종이 매수 증가
		return true;
	}
}
