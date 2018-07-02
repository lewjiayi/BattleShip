import java.util.Random;

public class Trap {
	Rule rule;
	Random random = new Random();
	Location location;
	private int trapCount;
	private int trapHDCount;
	private int trapLDCount;
	private int trapTriggerCount;
	private int mapRow;
	private int mapCol;
	private int [][] trapLocation;
	private int [][] trapHighLocation;
	private int [][] trapLowLocation;
	private int [][] trapTriggerredLocation;
	

	public Trap(int level) {
		rule = new Rule(level);
		location = new Location(level);
		trapTriggerCount = 0;
		trapCount = rule.getTrapNum();
		trapHDCount = random.nextInt(trapCount);
		trapLDCount = trapCount-trapHDCount;
		mapRow = rule.getMapRow();
		mapCol = rule.getMapCol();
		trapLocation = new int[trapCount][2];
		trapHighLocation = new int[trapCount][2];
		trapLowLocation = new int[trapCount][2];
		trapTriggerredLocation = new int[trapCount][2];
		
		
		int row = 0, col = 0;
		Boolean objPlaced;
		for(int placed=0 ; placed<trapCount  ; placed++){
			objPlaced = true;
			while(objPlaced) {
				row = random.nextInt(mapRow-1);
				col = random.nextInt(mapCol-1);
				if(location.checkLocation(row,col)!=0) {objPlaced= true;}
				else {objPlaced = false;}
			}
			trapLocation[placed][0]=row;
			trapLocation[placed][1]=col;
		}
	}

	public void setTrapMix() {
		for (int i=0; i<trapHDCount;) {
			trapHighLocation[i] = trapLocation[i];
			i++;
		}
		
		for (int i=0; i<trapLDCount;) {
			trapLowLocation[i] = trapLocation[i+trapHDCount];
			i++;
		}
	}
	
	
	public void setTrapTriggered(int[]a) {
		trapTriggerredLocation[trapTriggerCount]=a;
		trapTriggerCount++;
	}
	
	public int[][] getTrapHDLocation() {
		return trapHighLocation;
	}
	
	public int[][] getTrapLDLocation() {
		return trapLowLocation;
	}
	
	
}
