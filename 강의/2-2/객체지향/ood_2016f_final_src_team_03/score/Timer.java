package score;
/**�������� ���۵� �� ������ �ð��� ��û�ؼ� ��ȯ�ϴ� Ŭ����
 * @author ������
 * */
public class Timer {
	/**��ü�� �����ɶ��� �ý��� �ð�*/
	private long firstTime=0;
	/**��ü�� ȣ��ɶ��� �ý��� �ð�*/
	private long nowTime=0;
	/**firstTime�� �ʱ�ȭ*/
	public Timer(){
		firstTime=System.currentTimeMillis();
	}
	/**���� ����ð��� �и������� ������ ����
	 * 
	 * @return ������ ���۵��� ����� �ý��� �ð��� ����
	 */
	protected long getTime(){
		long currentTime=System.currentTimeMillis();
		nowTime=currentTime-firstTime;
		return nowTime;
	}
}
