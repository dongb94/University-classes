package score;
/**�ð��� ������ ȯ���ϴ� Ŭ����
 * @author ������
 * */
public class Score {
	/**�ð��� ������ ȯ���Ѱ�*/
	private int score;
	/**�ð��� ���� Timer��ü*/
	private Timer timer;
	/**�����ڰ� Timer ��ü�� �ʱ�ȭ�ϸ� �ð��� ����ϱ���� */
	public Score(){
		timer=new Timer();
	}
	/**score ������Ʈ*/
	protected void setScore(){
		score=(int)timer.getTime()/10;
	}
	/**score���� ����
	 * 
	 * @return �ð��� ������ ȯ���� ��Ʈ������ ����
	 */
	public int getScore(){
		return score;
	}
}
