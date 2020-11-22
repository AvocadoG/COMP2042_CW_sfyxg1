package froggerGameActions;

/**
* This class will refer and execute a type of {@link froggerGameActions.GameAction}<br>
* <b>STRATEGY DESIGN PATTERN</b> is applied here.
* @author GohXinYee
*
*/

public class GameActionContext {

	/**target {@link froggerGameActions.GameAction}*/
	private GameAction gameaction;
	
	/**
	 * This constructor will create an {@code GameActionContext} object that sets up the type of {@link froggerGameActions.GameAction} to be executed.
	 * @param gameaction the target game action type to be executed
	 */
	public GameActionContext(GameAction gameaction){
		this.gameaction=gameaction;
	}
	
	/**
	 * execute the target {@link froggerGameActions.GameAction}
	 */
	public void executeAction() {
		gameaction.doAction();
	}
}
