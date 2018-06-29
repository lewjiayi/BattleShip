import java.util.Random;

public class Trap {
	Rule rule = new Rule();
	private int trapTriggerCount = 0;
	private int [][] trapLocation = new int[rule.getTrapNum()][2];
	private int [][] trapHighLocation = new int[rule.getShipNum()][2];
	private int [][] trapLowLocation = new int[rule.getShipNum()][2];
	private int [][] trapTriggerredLocation = new int[rule.getShipNum()][2];
	Random random = new Random();
	
	
	public void setTrapLocation() {
		int row, col;
		int placed;
		for(int trap=0 ; trap<rule.getTrapNum()  ; trap++){
			row = random.nextInt(20);
			col = random.nextInt(60);
			placed = 0;
			
			while(placed <= trap){
				if(trapLocation[placed][0]==row && trapLocation[placed][1]==col) {
					row = random.nextInt(20);
					col = random.nextInt(60);
					placed = 0;}
				placed++;}
			trapLocation[trap][0]=row;
			trapLocation[trap][1]=col;
		}
	}
	
	public void setTrapMix() {
		int hightrap, row, col, test;
		Boolean highTrapBol;
		for(int i=0; i<trapHighNum(); i++) {
			hightrap = random.nextInt(rule.getTrapNum()) + 1;
			row = trapHighLocation[hightrap][0];
			col = trapHighLocation[hightrap][1];
			test = 0;
			
			while(test <= i){
				if(trapHighLocation[test][0]==row && trapHighLocation[test][1]==col) {
					row = trapHighLocation[hightrap][0];
					col = trapHighLocation[hightrap][1];
					test = 0;}
				test++;}
			trapHighLocation[i][0]=row;
			trapHighLocation[i][1]=col;
		}
		
		for (int j=0; j<trapLowNum(); j++) {
			for (int[] a : trapLocation) {
				highTrapBol = true;
				for (int[] b : trapHighLocation) {
					if(a != b) {
						highTrapBol = false;
					}
				}
				if(!highTrapBol) {
					trapLowLocation[j]=a;
				}
			}
		}
	}
	
	public void setTrapTriggered(int[]a) {
		trapTriggerredLocation[trapTriggerCount]=a;
		trapTriggerCount++;
	}
		
		
	
	
	
	public int trapHighNum() {
		return random.nextInt(rule.getTrapNum());
	}
	
	public int trapLowNum() {
		return rule.getTrapNum()-trapHighNum();
	}
}
