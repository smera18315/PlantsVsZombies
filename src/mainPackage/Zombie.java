package mainPackage;

import javafx.util.Pair;

public abstract class Zombie {

	private String zombieName;
	private boolean[] Type;
	private int zombieID, zombieHealth, zombieWaitingTime;
	private boolean isZombieAlive;
	static int zombieCounter = 0;
	Pair<Integer, Integer> zombieCoordinates;
	
	public Zombie(String zombieName, boolean[] type, int zombieID, int zombieHealth, int zombieWaitingTime,
			boolean isZombieAlive, Pair<Integer, Integer> zombieCoordinates) {
		super();
		this.zombieName = zombieName;
		Type = type;
		this.zombieID = zombieID;
		this.zombieHealth = zombieHealth;
		this.zombieWaitingTime = zombieWaitingTime;
		this.isZombieAlive = isZombieAlive;
		this.zombieCoordinates = zombieCoordinates;
	}
	
	void eat() {
		
	}
	
	
}

class FireZombie extends Zombie{

	public FireZombie(String zombieName, boolean[] type, int zombieID, int zombieHealth, int zombieWaitingTime,
			boolean isZombieAlive, Pair<Integer, Integer> zombieCoordinates) {
		super(zombieName, type, zombieID, zombieHealth, zombieWaitingTime, isZombieAlive, zombieCoordinates);
		// TODO Auto-generated constructor stub
	}
	
	void shoot(){
		
	}
	
}

class WaterZombie extends Zombie{

	public WaterZombie(String zombieName, boolean[] type, int zombieID, int zombieHealth, int zombieWaitingTime,
			boolean isZombieAlive, Pair<Integer, Integer> zombieCoordinates) {
		super(zombieName, type, zombieID, zombieHealth, zombieWaitingTime, isZombieAlive, zombieCoordinates);
		// TODO Auto-generated constructor stub
	}
	void shoot() {
		
	}
	
}

class ZombieBird extends Zombie{

	public ZombieBird(String zombieName, boolean[] type, int zombieID, int zombieHealth, int zombieWaitingTime,
			boolean isZombieAlive, Pair<Integer, Integer> zombieCoordinates) {
		super(zombieName, type, zombieID, zombieHealth, zombieWaitingTime, isZombieAlive, zombieCoordinates);
		// TODO Auto-generated constructor stub
	}
	void airgust() {
		
	}
	
}

class EarthZombie extends Zombie{

	public EarthZombie(String zombieName, boolean[] type, int zombieID, int zombieHealth, int zombieWaitingTime,
			boolean isZombieAlive, Pair<Integer, Integer> zombieCoordinates) {
		super(zombieName, type, zombieID, zombieHealth, zombieWaitingTime, isZombieAlive, zombieCoordinates);
		// TODO Auto-generated constructor stub
	}
	
	void earthquake() {
		
	}
	
}