import java.util.*;

public class Game {
	public static void main(String[] args) {
		int level;
		Display screen = new Display();
		Message message = new Message();
		Player player = new Player();
		Rule rule = new Rule();
		Input input = new Input();
		Map map = new Map();
		
		/*screen.displayMessage(message.getMsgWelcome());
		screen.displayMessage(message.getMsgLevelSelection());
		screen.displayMessage(message.getMsgLevel1());
		screen.displayMessage(message.getMsgLevel2());
		screen.displayMessage(message.getMsgLevel3());
		level = input.inputLevel();*/
		
		map.setMapDestroyShip(1, 2);
		map.printMap();
		
		
	}

}
