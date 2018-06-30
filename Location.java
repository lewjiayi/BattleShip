import java.util.Arrays;
import java.util.Random;

/* Directory
 * Ship 	- 1
 * HD Trap 	- 2
 * LD Trap 	- 3
 * LS Potion- 4
 * TR Potion- 5
 * SR Potion- 6
 */

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
	
	public int checkLocation(int row, int col) {
		return location[row][col];
	}
	
	public void setShipLocation(int row, int col) {
		location[row][col]=1;
	}
	
	public void setTrapHDLocation(int row, int col) {
		location[row][col]=2;
	}
	
	public void setTrapLDLocation(int row, int col) {
		location[row][col]=3;
	}
	
	public void setLSPotLocation(int row, int col) {
		location[row][col]=4;
	}
	
	public void setTRPotLocation(int row, int col) {
		location[row][col]=5;
	}
	
	public void setSRPotLocation(int row, int col) {
		location[row][col]=6;
	}
}
