package p4_group_8_repo;

public class GameActionContext {

	private GameAction gameaction;
	
	GameActionContext(GameAction gameaction){
		this.gameaction=gameaction;
	}
	
	public void executeAction() {
		gameaction.doAction();
	}
}
