import java.util.*;

public class Game {
	
	private int level;
	private Display screen;
	private Message message;
	private Player player;
	private Rule rule;
	private Input input;
	private Map map;
	private Location location;
	private Ship ship;
	private Trap trap;
	private Potion potion;

	
	public Game() {
		screen = new Display();
		message = new Message();		
		input = new Input();
		
		
	}
	
	
	public void Run() {
		
		screen.displayMessage(message.getMsgWelcome());
		selectLevel();
		construct();
		screen.displayMessage(message.getMsgWelcome());
	}
	
	
	public void selectLevel() {
		screen.displayMessage(message.getMsgLevelSelection());
		screen.displayMessage(message.getMsgLevel1());
		screen.displayMessage(message.getMsgLevel2());
		screen.displayMessage(message.getMsgLevel3());
		level = input.inputInt();
		rule = new Rule(level);
	}
	
	public void construct() {
		ship = new Ship(level);
		trap = new Trap (level);
		potion = new Potion(level);
		map = new Map(level);
		player = new Player(level);
	
	}
	
	
	public int[] inputShoot() {
		System.out.print("Where do you wish to shoot?\n");
		System.out.print("Row:");
		int a = input.inputInt();
		System.out.print("Column:");
		int b = input.inputInt();
		int[] coordinate = {a,b};
		return coordinate;
	}
		
		
}

