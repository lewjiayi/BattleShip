
public class Player {
	private String name;
	private int life_count;
	private int step_count;
	private int ship_destroy_count;
	private Boolean statusWin;
	private Boolean statusLose;
	Rule rule = new Rule();
	
	
	public Player() {
		life_count = rule.getLifeNum();
		step_count = 0;
		ship_destroy_count = 0;
		statusWin = false;
		statusLose = false;
	}
	
	public void addOneStep() {
		step_count++;
	}
	
	public void lossTwoLife() {
		life_count = life_count - 2;
	}
	
	public void lossOneLife() {
		life_count--;
	}
	
	public void addOneLife() {
		life_count++;
	}
	
	public void destroyOneShip() {
		ship_destroy_count++;
	}
	
	public int getLifeCount() {
		return life_count;
	}
	
	public int getStepCount() {
		return step_count;
	}
	
	public int getShipDestroyCount() {
		return ship_destroy_count;
	}
	
	public void setName(String a) {
		name = a;
	}
	
	public String getName() {
		return name;
	}
	
	public Boolean getStatusWin() {
		return statusWin;
	}
	
	public Boolean getStatusLose() {
		return statusLose;
	}
	
	public void setStatusWin() {
		statusWin = true;
	}
	
	public void setStatusLose() {
		statusLose = true;
	}
	
	
	

}
