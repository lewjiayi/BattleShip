import java.util.Random;

public class Trap {
	Rule rule = new Rule();
	Random random = new Random();
	Location location = new Location();
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
	

	public Trap(int trapNum) {
		trapTriggerCount = 0;
		trapCount = trapNum;
		trapHDCount = random.nextInt(trapCount);
		trapLDCount = trapCount-trapHDCount;
		mapRow = rule.getMapRow();
		mapCol = rule.getMapCol();
		trapLocation = new int[trapNum][2];
		trapHighLocation = new int[trapNum][2];
		trapLowLocation = new int[trapNum][2];
		trapTriggerredLocation = new int[trapNum][2];
		int row = 0, col = 0;
		Boolean objPlaced;
		for(int placed=0 ; placed<trapCount  ; placed++){
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
			trapLocation[placed][0]=row;
			trapLocation[placed][1]=col;
		}
	}

	public void setTrapMix() {
		int hightrap, lowtrap = 0, row=0, col=0;
		Boolean highTrapBol;
	
		for(int i=0; i<trapHDCount; i++) {
			highTrapBol = true;
			while(highTrapBol) {
				hightrap = random.nextInt(trapCount);
				row = trapLocation[hightrap][0];
				col = trapLocation[hightrap][1];
				for (int[] a : trapHighLocation) {
					if(a[0]!=row && a[1]!=col) {highTrapBol = false;}
				}
			}
			trapHighLocation[i][0]=row;
			trapHighLocation[i][1]=col;
		}
		
	
		for (int[] a : trapLocation) {
			highTrapBol = true;
			for (int[] b : trapHighLocation) {
				if(a != b) {highTrapBol = false;}
			}
			if(!highTrapBol) {
				trapLowLocation[lowtrap]=a;
				lowtrap ++;
			}
		}
	}//end set trap mixture
	
	
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
