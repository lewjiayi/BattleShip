import java.util.Random;

public class Ship {
	Rule rule = new Rule();
	private int [][] shipLocation = new int[rule.getShipNum()][2];
	private int [][] shipDestroyLocation = new int[rule.getShipNum()][2];
	Random random = new Random();
	Location location = new Location();
	private int ship_destroy_count;
	private int shipCount;
	
	public Ship() {
		ship_destroy_count = 0;
		shipCount = rule.getShipNum();
	}
	
	public void initShipLocation() {
		int[] row = new int[rule.getShipLength()[0][1]];
		int[] col = new int[rule.getShipLength()[0][1]];
		int direction, length;
		Boolean objPlaced;
		
		for(int placed=0; placed<shipCount; placed++){
			direction = random.nextInt(1);
			length = randomLength();
			objPlaced = true;
			while(objPlaced) {
				for (int i=0; i<length; i ++) {
					switch (direction) {
					case 0:
						row[i] = random.nextInt(20)+i;
						col[i] = random.nextInt(60);
					case 1:
						row[i] = random.nextInt(20);
						col[i] = random.nextInt(60)+i;
					}
					if(location.checkLocation(row[i],col[i])!=0) {
						objPlaced = true;
						i = length;
						}
					else {objPlaced = false;}
					if (row[i]>20 && col[i]>60) {
						objPlaced= true;
						i = length;
					}
				}
			}
			for (int i=0; i<length; i ++) {
				shipLocation[placed][0]=row[i];
				shipLocation[placed][1]=col[i];
				location.setShipLocation(row[i], col[i]);
			}
		}
	} // end Ship Initialization
	
	
	public void setDestroyShip(int row, int col) {
		shipDestroyLocation[ship_destroy_count][0] = row;
		shipDestroyLocation[ship_destroy_count][1] = col;
		ship_destroy_count ++;
	}
	
	public int randomLength() {
		int length, min, max;
		min = rule.getShipLength()[0][0];
		max = rule.getShipLength()[0][1];
		length = random.nextInt((max-min)+1) + min;
		return length;
	}
}
