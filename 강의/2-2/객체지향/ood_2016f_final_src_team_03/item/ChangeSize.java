package item;
/**����ȭ�� �Ŵ�ȭ�� ������ Ŭ����
 * @author ������
 * */
public class ChangeSize extends ItemManager {
	/**ChangeSize������*/
	public ChangeSize(){};
	/**����ȭ �̹��� ��� �޼ҵ�*/
	public void appearSmall(){
		pm.setSmallImage();
		try{
			Thread.sleep(4000);
			pm.setImage();
		}catch(Exception e){
			
		}
	}
	
	/**����ȭ �̹��� ��� �޼ҵ�*/
	public void appearBig() {
		pm.setBigImage();
		try{
			Thread.sleep(4000);
			pm.setImage();
		}catch(Exception e){
			
		}
	}
}


		



