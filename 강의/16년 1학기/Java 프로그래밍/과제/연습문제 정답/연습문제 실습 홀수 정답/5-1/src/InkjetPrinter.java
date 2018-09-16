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
			System.out.println("��ũ�� �����մϴ�.");
			return false;
		}
		if (numberOfPaper <= 0) {
			System.out.println("�μ� ������ �����մϴ�.");
			return false;
		}
		System.out.println("��ũ�� ������ ���");
		amountOfInk -= amountOfInkToPrint; // ��ũ �ܷ� ����
		numberOfPaper--; // ���� ���� �ż� ����
		numberOfPrinted++; // �μ��� ���� �ż� ����
		return true;
	}
}
