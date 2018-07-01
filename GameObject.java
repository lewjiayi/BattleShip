import java.util.Random;

public abstract class GameObject {
	
	Location location = new Location();
	Rule rule = new Rule();
	Random random = new Random();	
	
	abstract public void setLocation();
	
}
