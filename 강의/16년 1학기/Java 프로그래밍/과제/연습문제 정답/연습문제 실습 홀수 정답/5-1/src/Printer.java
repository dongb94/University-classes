public abstract class Printer {
	public static int USB = 0;
	public static int PARALLEL = 1;
	private String modelName; // 모델 이름
	private String manufacturer; // 제조사
	private int type; // USB 또는 병렬 프린터
	protected int numberOfPrinted; // 인쇄한  종이 매수
	protected int numberOfPaper; // 남은 종이 매수
	abstract public boolean print();
	public String getModelName()
	{
		return modelName;
	}
	public String getManufacturer()
	{
		return manufacturer;
	}
	public int getType() {
		return type;
	}
	public int getNumberOfPrinted()
	{
		return numberOfPrinted;
	}
	public void setNumberOfPaper(int numberOfPaper)
	{
		this.numberOfPaper = numberOfPaper;
	}
	public int getNumberOfPaper()
	{
		return numberOfPaper;
	}
	public Printer(String modelName, String manufacturer, int type, int numberOfPaper)
	{
		this.modelName = modelName;
		this.manufacturer = manufacturer;
		this.type = type;
		this.numberOfPaper = numberOfPaper;
		this.numberOfPrinted = 0;
	}
}
