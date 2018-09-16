package chopsticks;

import display.Game_stage;

public class Patterns {
	private Game_stage game;
	public Patterns(Game_stage game){
		this.game=game;
	}
	public void pattern1(){
		new Pattern1(game);
	}
	public void pattern2(){
		new Pattern2(game);
	}
	public void pattern3(){
		new Pattern3(game);
	}
}
