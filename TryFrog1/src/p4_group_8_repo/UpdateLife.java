package p4_group_8_repo;

public class UpdateLife implements GameAction{

	private Level level;
	
	UpdateLife(Level level){
		this.level=level;
	}
	
	@Override
	public void doAction() {
		int life=level.getlevelLife();
		// TODO Auto-generated method stub
		level.add(new Life(life,40,500,60));

	}

}
