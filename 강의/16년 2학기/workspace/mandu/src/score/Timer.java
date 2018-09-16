package score;

public class Timer {
	/**객체가 생성될때의 시스템 시간*/
	private long firstTime=0;
	/**객체가 호출될때의 시스템 시간*/
	private long nowTime=0;
	/**firstTime을 초기화*/
	public Timer(){
		firstTime=System.currentTimeMillis();
	}
	/**현재 진행시간을 밀리세컨드 단위로 리턴*/
	public long getTime(){
		long currentTime=System.currentTimeMillis();
		nowTime=currentTime-firstTime;
		return nowTime;
	}
}
