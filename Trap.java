import java.util.Random;

public class Trap {
	Rule rule = new Rule();
	private int trapCount;
	private int trapHDCount;
	private int trapLDCount;
	private int trapTriggerCount;
	private int [][] trapLocation = new int[rule.getTrapNum()][2];
	private int [][] trapHighLocation = new int[rule.getTrapNum()][2];
	private int [][] trapLowLocation = new int[rule.getTrapNum()][2];
	private int [][] trapTriggerredLocation = new int[rule.getTrapNum()][2];
	Random random = new Random();
	Location location = new Location();

	public Trap() {
		trapTriggerCount = 0;
		trapCount = rule.getTrapNum();
		trapHDCount = random.nextInt(trapCount);
		trapLDCount = trapCount-trapHDCount;
		
	}
	
	public void setTrapLocation() {
		int row = 0, col = 0;
		Boolean objPlaced;
		for(int placed=0 ; placed<trapCount  ; placed++){
			objPlaced = true;
			while(objPlaced) {
				row = random.nextInt(20);
				col = random.nextInt(60);
				if(location.checkLocation(row,col)!=0) {objPlaced = true;}
				else {objPlaced = false;}
				if (row>20 && col>60) {objPlaced= true;}
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
