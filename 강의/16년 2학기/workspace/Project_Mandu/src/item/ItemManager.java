package item;
import character.PlayerManager;
import display.Game_stage;
/**������ �����ϴ� ItemManager Ŭ����
 * 
 * @author Jiyoung Sim
 *
 */
public class ItemManager{
	/**���ӽ��������� ��ü gameFrame*/
	protected static Game_stage gameFrame;
	/**�÷��̾� �Ŵ����� ��ü pm*/
	protected PlayerManager pm= new PlayerManager();
	/**������ �Ŵ��� �⺻ ������*/
	ItemManager(){};
	/**������ �Ŵ��� ���� ������ �ʱ�ȭ�ϴ� ������*/
	public ItemManager(Game_stage game){
		gameFrame = game;
	}
}