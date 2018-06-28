import java.util.Arrays;
import java.util.Random;

public class Location extends Rule {
	private String [][] location = new String[getMapRow()][getMapCol()];
	private Boolean itemPlaced;
	
	public Location() {
		for (String[]row : location) {
			Arrays.fill(row, "0");
		}
	}
	
	public void setShipLocation() {
		
	}
	
	
	
}
