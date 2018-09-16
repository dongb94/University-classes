package item;
import character.PlayerManager;
import display.Game_stage;
/**아이템 관리하는 ItemManager 클래스
 * 
 * @author Jiyoung Sim
 *
 */
public class ItemManager{
	/**게임스테이지의 객체 gameFrame*/
	protected static Game_stage gameFrame;
	/**플레이어 매니저의 객체 pm*/
	protected PlayerManager pm= new PlayerManager();
	/**아이템 매니저 기본 생성자*/
	ItemManager(){};
	/**아이템 매니저 게임 프레임 초기화하는 생성자*/
	public ItemManager(Game_stage game){
		gameFrame = game;
	}
}