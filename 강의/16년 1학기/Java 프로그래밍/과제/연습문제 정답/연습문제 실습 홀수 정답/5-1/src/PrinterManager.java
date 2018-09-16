public class PrinterManager {
	public static void main (String[] args) { 
		LaserPrinter lp = new LaserPrinter("SCX-6x45", "삼성전자", Printer.PARALLEL, 3, 20);
		InkjetPrinter ip = new InkjetPrinter("Officejet V40", "HP", Printer.USB, 5, 10);
		for (int i=0; i<5; i++) {
			lp.print();
			System.out.print("레이저프린터>>");
			System.out.print("인쇄용지:" + lp.getNumberOfPaper());
			System.out.print(" 출력매수:" + lp.numberOfPrinted);
			System.out.println(" 토너잔량:" + lp.getAmountOfToner());
			ip.print();
			System.out.print("잉크젯프린터>>");
			System.out.print("인쇄용지:" + ip.getNumberOfPaper());
			System.out.print(" 출력매수:" + ip.numberOfPrinted);
			System.out.println(" 잉크잔량:" + ip.getAmountOfInk());
		}
	}
}
