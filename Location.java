import java.util.Arrays;
import java.util.Random;

public class Location{
	Rule rule = new Rule();
	private int [][] location = new int[rule.getMapRow()][rule.getMapCol()];
	private Boolean itemPlaced;
	private int [][] shipLocation = new int[rule.getShipNum()][2];
	
	public Location() {
		for (int[] row : location) {
			Arrays.fill(row, 0);
		}
	}
	
	public void setShipLocation() {
		int row, col, test;
		Random random = new Random();
		
		for(int ship=0 ; ship<rule.getShipNum()  ; ship++){
			row = random.nextInt(20);
			col = random.nextInt(60);
			test = 0;
			while(test <= ship){
				if(shipLocation[test][0]==row && shipLocation[test][1]==col) {
					row = random.nextInt(20);
					col = random.nextInt(60);
					test = 0;
				}
				test++;
			}
			shipLocation[ship][0]=row;
			shipLocation[ship][1]=col;
		}
	}
	
	
}
