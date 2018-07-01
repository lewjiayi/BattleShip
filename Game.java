import java.util.*;

public class Game {
	
	private int level, shipNum, trapNum, potionNum;
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
		map = new Map();
		rule = new Rule();
		player = new Player();
		
	}
	
	
	public void Run() {
		
		screen.displayMessage(message.getMsgWelcome());
		selectLevel();
		construct();
	}
	
	
	public void selectLevel() {
		screen.displayMessage(message.getMsgLevelSelection());
		screen.displayMessage(message.getMsgLevel1());
		screen.displayMessage(message.getMsgLevel2());
		screen.displayMessage(message.getMsgLevel3());
		level = input.inputInt();
		rule.setLevel(level);
		shipNum = rule.getShipNum();
		trapNum = rule.getTrapNum();
		potionNum = rule.getPotNum();
	}
	
	public void construct() {
		ship = new Ship(shipNum);
		trap = new Trap (trapNum);
		potion = new Potion(potionNum);
	
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

