package froggerGameActions;

import froggerElements.Life;
import froggerLevels.Level;

public class UpdateLife implements GameAction{

	private Level level;
	
	public UpdateLife(Level level){
		this.level=level;
	}
	
	@Override
	public void doAction() {
		int life=level.getlevelLife();
		// TODO Auto-generated method stub
		level.add(new Life(life,40,500,60));

	}

}
