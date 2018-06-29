import java.util.Arrays;
import java.util.Random;

public class Location extends Rule {
	private int [][] location = new int[getMapRow()][getMapCol()];
	private Boolean itemPlaced;
	private int [][] shipLocation = new int[getShipNum()][2];
	
	public Location() {
		for (int[] row : location) {
			Arrays.fill(row, 0);
		}
	}
	
	public void setShipLocation() {
		itemPlaced = false;
		Random random = new Random();
		for(int ship=0 ; ship<getShipNum()  ; ship++){
			if(!itemPlaced) {
				shipLocation[ship][0]=random.nextInt(5);
				shipLocation[ship][1]=random.nextInt(5);
			}
		}
	}
	
	
	
}
