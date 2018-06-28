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
	
	public void setMapMissed(int a, int b) {
		map[a-1][b-1] = " ";
	}
	
	public void setMapDestroyShip(int a, int b) {
		map[a-1][b-1] = "X";
	}
	
	public void setMapRevealShip(int a, int b) {
		map[a-1][b-1] = "O";
	}
	
	public void setMapHDTrap(int a, int b) {
		map[a-1][b-1] = "-";
	}
	
	public void setMapLDTrap(int a, int b) {
		map[a-1][b-1] = "=";
	}
	
	public void setMapTrap(int a, int b) {
		map[a-1][b-1] = "*";
	}
	
	public void setMapPot(int a, int b) {
		map[a-1][b-1] = "@";
	}
	
	
	
	
		
	
	
}
