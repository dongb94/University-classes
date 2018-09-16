package score;
/**시간을 점수로 환산하는 클래스
 * @author 변동건
 * */
public class Score {
	/**시간을 점수로 환산한값*/
	private int score;
	/**시간을 얻어올 Timer객체*/
	private Timer timer;
	/**생성자가 Timer 객체를 초기화하며 시간을 기록하기시작 */
	public Score(){
		timer=new Timer();
	}
	/**score 업데이트*/
	protected void setScore(){
		score=(int)timer.getTime()/10;
	}
	/**score값을 리턴
	 * 
	 * @return 시간을 점수로 환산해 인트값으로 리턴
	 */
	public int getScore(){
		return score;
	}
}
