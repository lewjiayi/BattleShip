import java.util.Random;

public class Potion {
	Random random = new Random();
	Location location = new Location();
	Rule rule = new Rule();
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

	
	public Potion(int potionNum) {
		potionCount = potionNum;
		potionTriggerCount = 0;
		mapRow = rule.getMapRow();
		mapCol = rule.getMapCol();
		potionTRCount = random.nextInt(potionCount)+1;
		potionLSCount = random.nextInt(potionCount-potionTRCount)+1;
		potionSRCount = potionCount - potionLSCount - potionTRCount;
		potionLocation = new int[potionNum][2];
		potionLSLocation = new int[potionNum][2];
		potionTRLocation = new int[potionNum][2];
		potionSRLocation = new int[potionNum][2];
		potionTriggerLocation = new int[potionNum][2];
		int row = 0, col = 0;
		Boolean objPlaced;
		for(int placed=0 ; placed<potionCount  ; placed++){
			objPlaced = true;
			while(objPlaced) {
				row = random.nextInt(mapRow-1);
				col = random.nextInt(mapCol-1);
				if (row>mapRow || col>mapCol) {objPlaced = true;}
				else {
					if(location.checkLocation(row,col)!=0) {objPlaced= true;}
					else {objPlaced = false;}
				}
			}
			potionLocation[placed][0]=row;
			potionLocation[placed][1]=col;
		}
	}
	
	
	public void setPotionMix() {
		int LSPot, TRPot, SRPot = 0, row=0, col=0;
		Boolean LSPotBol, TRPotBol;
		
		for(int i=0; i<potionTRCount; i++) {
			TRPotBol = true;
			while(TRPotBol) {
				TRPot = random.nextInt(potionCount);
				row = potionLocation[TRPot][0];
				col = potionLocation[TRPot][1];
				for (int[] a : potionTRLocation) {
					if(a[0]!=row && a[1]!=col) {TRPotBol = false;}
				}
			}
			potionTRLocation[i][0]=row;
			potionTRLocation[i][1]=col;
		}
		
		for(int i=0; i<potionLSCount; i++) {
			LSPotBol = true;
			TRPotBol = true;
			while(LSPotBol) {
				LSPot = random.nextInt(potionCount);
				row = potionLocation[LSPot][0];
				col = potionLocation[LSPot][1];
				for (int[] a : potionTRLocation) {
					if(a[0]!=row && a[1]!=col) {TRPotBol = false;}
				}
				if(!TRPotBol) {
					for (int[] a : potionLSLocation) {
						if(a[0]!=row && a[1]!=col) {LSPotBol = false;}
					}
				}
			}
			potionLSLocation[i][0]=row;
			potionLSLocation[i][1]=col;
		}
		
		for (int[] a : potionLocation) {
			TRPotBol = true;
			LSPotBol = true;
			for (int[] b : potionTRLocation) {
				if(a != b) {TRPotBol = false;}
			}
			if(!TRPotBol) {
				for (int[] b : potionLSLocation) {
					if(a != b) {LSPotBol = false;}
				}
			}
			if(!LSPotBol) {
				potionSRLocation[SRPot]=a;
				SRPot ++;
			}
		}
		
	}// end set potion mixture
	
	
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
