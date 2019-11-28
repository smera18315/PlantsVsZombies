package mainPackage;

import javafx.util.Pair;

import java.io.Serializable;

public abstract class Zombie implements Cloneable, Serializable, Runnable {

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

	@Override
	public Zombie clone() {
		try {
			Zombie copy = (Zombie) super.clone();
			return copy;
		} catch (CloneNotSupportedException e) {
			return null;
		}

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

	@Override
	public void run() {

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

	@Override
	public void run() {

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

	@Override
	public void run() {

	}
}

class EarthZombie extends Zombie {

	public EarthZombie(String zombieName, boolean[] type, int zombieID, int zombieHealth, int zombieWaitingTime,
					   boolean isZombieAlive, Pair<Integer, Integer> zombieCoordinates) {
		super(zombieName, type, zombieID, zombieHealth, zombieWaitingTime, isZombieAlive, zombieCoordinates);
		// TODO Auto-generated constructor stub
	}

	void earthquake() {

	}

	@Override
	public void run() {
		
	}
}