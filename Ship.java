import java.util.Random;

public class Ship {
	Rule rule = new Rule();
	private int [][] shipLocation = new int[rule.getShipNum()][2];
	private int [][] shipDestroyLocation = new int[rule.getShipNum()][2];
	Random random = new Random();

	
	
	public void setShipLocation() {
		int row, col;
		int test, direction, length;
		
		for(int ship=0 ; ship<rule.getShipNum()  ; ship++){
			row = random.nextInt(20);
			col = random.nextInt(60);
			direction = random.nextInt(1);
			test = 0;
			
			while(test <= ship){
				if(shipLocation[test][0]==row && shipLocation[test][1]==col) {
					row = random.nextInt(20);
					col = random.nextInt(60);
					test = 0;}
				test++;}
			shipLocation[ship][0]=row;
			shipLocation[ship][1]=col;
		}
	}
	
	public int randomLength() {
		int length, min, max;
		min = rule.getShipLength()[0][0];
		max = rule.getShipLength()[0][1];
		length = random.nextInt((max-min)+1) + min;
		return length;
	}
}
