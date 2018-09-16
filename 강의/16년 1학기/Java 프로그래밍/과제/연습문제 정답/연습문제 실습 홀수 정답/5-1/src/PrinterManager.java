public class PrinterManager {
	public static void main (String[] args) { 
		LaserPrinter lp = new LaserPrinter("SCX-6x45", "�Ｚ����", Printer.PARALLEL, 3, 20);
		InkjetPrinter ip = new InkjetPrinter("Officejet V40", "HP", Printer.USB, 5, 10);
		for (int i=0; i<5; i++) {
			lp.print();
			System.out.print("������������>>");
			System.out.print("�μ����:" + lp.getNumberOfPaper());
			System.out.print(" ��¸ż�:" + lp.numberOfPrinted);
			System.out.println(" ����ܷ�:" + lp.getAmountOfToner());
			ip.print();
			System.out.print("��ũ��������>>");
			System.out.print("�μ����:" + ip.getNumberOfPaper());
			System.out.print(" ��¸ż�:" + ip.numberOfPrinted);
			System.out.println(" ��ũ�ܷ�:" + ip.getAmountOfInk());
		}
	}
}
