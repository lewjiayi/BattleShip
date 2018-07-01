import java.util.Random;

public class Ship{
	Rule rule = new Rule();
	private int [][] shipLocation;
	private int [][] shipDestroyLocation;
	Random random = new Random();
	Location location = new Location();
	private int ship_destroy_count;
	private int shipCount;
	private int mapRow;
	private int mapCol;
	private int counter;
	
	public Ship(int shipNum) {
		shipLocation = new int[shipNum*rule.getShipLength()[1][0]][2];
		shipDestroyLocation = new int[shipNum*rule.getShipLength()[1][0]][2];
		ship_destroy_count = 0;
		counter = 0;
		shipCount = shipNum;
		mapRow = rule.getMapRow();
		mapCol = rule.getMapCol();
		int[] row = new int[rule.getShipLength()[1][0]];
		int[] col = new int[rule.getShipLength()[1][0]];
		int direction, length;
		Boolean objPlaced;
		
		for(int placed=0; placed<shipCount; placed++){
			direction = random.nextInt(1);
			length = randomLength();
			objPlaced = true;
			while(objPlaced) {
				for (int i=0; i<length;) {
					switch (direction) {
					case 0:
						row[i] = random.nextInt(mapRow-1)+i;
						col[i] = random.nextInt(mapCol-1);
					case 1:
						row[i] = random.nextInt(mapRow-1);
						col[i] = random.nextInt(mapCol-1)+i;
					}
					if (row[i]>mapRow || col[i]>mapCol) {
						objPlaced= true;
						i = length;
					}
					else{
						if(location.checkLocation(row[i],col[i])!=0) {
							objPlaced = true;
							i = length;
							}
						else {objPlaced = false;}
					}
					i++;
				}
			}
			for (int i=0; i<length; i ++) {
				shipLocation[counter][0]=row[i];
				shipLocation[counter][1]=col[i];
				location.setShipLocation(row[i], col[i]);
				counter++;
			}
		}
	}
	
	
	public void setDestroyShip(int row, int col) {
		shipDestroyLocation[ship_destroy_count][0] = row;
		shipDestroyLocation[ship_destroy_count][1] = col;
		ship_destroy_count ++;
	}
	
	public int randomLength() {
		int length, min, max;
		min = rule.getShipLength()[0][0];
		max = rule.getShipLength()[1][0];
		length = random.nextInt((max-min)+1) + min;
		return length;
	}
	
	public int getShipNum() {
		return shipCount;
	}
}
