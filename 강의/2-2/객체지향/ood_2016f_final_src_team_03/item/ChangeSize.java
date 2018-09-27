package item;
/**소형화와 거대화를 구현한 클래스
 * @author 심지영
 * */
public class ChangeSize extends ItemManager {
	/**ChangeSize생성자*/
	public ChangeSize(){};
	/**소형화 이미지 출력 메소드*/
	public void appearSmall(){
		pm.setSmallImage();
		try{
			Thread.sleep(4000);
			pm.setImage();
		}catch(Exception e){
			
		}
	}
	
	/**대형화 이미지 출력 메소드*/
	public void appearBig() {
		pm.setBigImage();
		try{
			Thread.sleep(4000);
			pm.setImage();
		}catch(Exception e){
			
		}
	}
}


		



