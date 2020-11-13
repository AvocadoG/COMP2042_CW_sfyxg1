package p4_group_8_repo;

public class UpdateScore implements GameAction{
	
	private Level level;
	
	UpdateScore(Level level){
		this.level=level;
	}
	
	@Override
	public void doAction() {
		
		int points=level.getlevelPoints();
		
		// TODO Auto-generated method stub
		int shift = 0;
    	
    	if(points<100) {//if points has 2 digits
        	while (points > 0) {
        		  int d = points / 10;
        		  int k = points - d * 10;
        		  points = d;
        		  level.add(new Digit(k, 30, 550 - shift, 25));
        		  shift+=30;
        	}
        	level.add(new Digit(0,30,550 - shift, 25));
        }
        	
        else if(points>=100) {//if points has 3digits
        	while (points > 0) {
          		  int d = points / 10;
          		  int k = points - d * 10;
          		  points = d;
          		  level.add(new Digit(k, 30, 550 - shift, 25));
          		  shift+=30;
          	}
        }
	}
	

	
	

}
