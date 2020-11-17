package froggerGameActions;

public class GameActionContext {

	private GameAction gameaction;
	
	public GameActionContext(GameAction gameaction){
		this.gameaction=gameaction;
	}
	
	public void executeAction() {
		gameaction.doAction();
	}
}
