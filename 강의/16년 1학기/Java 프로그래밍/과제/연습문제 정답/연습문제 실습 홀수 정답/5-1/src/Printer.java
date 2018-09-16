public abstract class Printer {
	public static int USB = 0;
	public static int PARALLEL = 1;
	private String modelName; // �� �̸�
	private String manufacturer; // ������
	private int type; // USB �Ǵ� ���� ������
	protected int numberOfPrinted; // �μ���  ���� �ż�
	protected int numberOfPaper; // ���� ���� �ż�
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
