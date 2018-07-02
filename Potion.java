import java.util.Random;

public class Potion {
	Random random = new Random();
	Location location;
	Rule rule;
	private int potionCount;
	private int potionLSCount;
	private int potionTRCount;
	private int potionSRCount;
	private int potionTriggerCount;
	private int mapRow;
	private int mapCol;
	private int[][] potionLocation;
	private int[][] potionLSLocation;
	private int[][] potionTRLocation;
	private int[][] potionSRLocation;
	private int[][] potionTriggerLocation;

	
	public Potion(int level) {
		rule = new Rule(level);
		location = new Location(level);
		potionCount = rule.getPotNum();
		potionTriggerCount = 0;
		mapRow = rule.getMapRow();
		mapCol = rule.getMapCol();
		potionLocation = new int[potionCount][2];
		potionLSLocation = new int[potionCount][2];
		potionTRLocation = new int[potionCount][2];
		potionSRLocation = new int[potionCount][2];
		potionTriggerLocation = new int[potionCount][2];
		potionTRCount = random.nextInt(potionCount)+1;
		potionLSCount = random.nextInt(potionCount-potionTRCount)+1;
		potionSRCount = potionCount - potionLSCount - potionTRCount;
		
		
		int row = 0, col = 0;
		Boolean objPlaced;
		for(int placed=0 ; placed<potionCount  ; placed++){
			objPlaced = true;
			while(objPlaced) {
				row = random.nextInt(mapRow-1);
				col = random.nextInt(mapCol-1);
				if(location.checkLocation(row,col)!=0) {objPlaced= true;}
				else {objPlaced = false;}
			}
			potionLocation[placed][0]=row;
			potionLocation[placed][1]=col;
		}
	}
	
	
	public void setPotionMix() {
		for (int i=0; i<potionLSCount;) {
			potionLSLocation[i] = potionLocation[i];
			i++;
		}
		
		for (int i=0; i<potionTRCount;) {
			potionTRLocation[i] = potionLocation[i+potionLSCount];
			i++;
		}
		
		for (int i=0; i<potionSRCount;) {
			potionSRLocation[i] = potionLocation[i+potionTRCount+potionLSCount];
			i++;
		}
		
	}
	
	
	public void setPotionTriggered(int[]a) {
		potionTriggerLocation[potionTriggerCount]=a;
		potionTriggerCount++;
	}
	
	public int[][] getTRPotLocation() {
		return potionTRLocation;
	}
	
	public int[][] getLSPotLocation() {
		return potionLSLocation;
	}
	
	public int[][] getSRPotLocation() {
		return potionSRLocation;
	}
}
