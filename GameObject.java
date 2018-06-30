import java.util.*;

public class GameObject {
	
	Location location = new Location();
	
	ArrayList<Ship> ship = new ArrayList<Ship>();
	ArrayList<Trap> trap = new ArrayList<Trap>();
	ArrayList<Potion> potion = new ArrayList<Potion>();
	
	Ship revealShip, destroyedShip, hiddenShip;
	Trap revealHDTrap, revealLDTrap, triggerTrap, hiddenTrap;
	Potion revealPotion, triggerPotion, hiddenPotion;
	
	revealShip = new Ship();
	destroyedShip = new Ship();
	hiddenShip = new Ship();
	
	revealHDTrap = new Trap();
	revealLDTrap = new Trap();
	triggerTrap = new Trap();
	hiddenTrap = new Trap();
	
	revealPotion = new Potion();
	triggerPotion = new Potion();
	hiddenPotion = new Potion();
	
	ship.add(revealShip);
	
}
