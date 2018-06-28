import java.util.*;

public class Map {
	private String [][] map = new String [20][60];
	
	public Map() {
		for (String[]row : map) {
			Arrays.fill(row, "#");
		}
	}
	
	public void printMap() {
		for(String[] row : map) {
			for(String col : row) {
				System.out.print(col);
	            System.out.print(" ");
	        }
			System.out.println();

        }
	}
	
	
	
		
	
	
}
