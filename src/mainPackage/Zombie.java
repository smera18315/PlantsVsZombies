package mainPackage;

import javafx.util.Pair;

import javax.swing.text.html.ImageView;
import java.io.Serializable;

public abstract class Zombie implements Creature, Cloneable, Serializable, Runnable {

	private String zombieName;
	private int zombieID, zombieHealth, zombieWaitingTime;
	private boolean isZombieAlive;
	static int zombieCounter = 0;
	Pair<Integer, Integer> zombieCoordinates;
	ImageView zombieImage;

    public Zombie(String zombieName, int zombieID, int zombieHealth, int zombieWaitingTime, boolean isZombieAlive, Pair<Integer, Integer> zombieCoordinates, ImageView zombieImage) {
        this.zombieName = zombieName;
        this.zombieID = zombieID;
        this.zombieHealth = zombieHealth;
        this.zombieWaitingTime = zombieWaitingTime;
        this.isZombieAlive = isZombieAlive;
        this.zombieCoordinates = zombieCoordinates;
        this.zombieImage = zombieImage;
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


    public FireZombie(Pair<Integer, Integer> zombieCoordinates, ImageView zombieImage) {
        super("FireZombie", 1, 50, 1000, true, zombieCoordinates, zombieImage);
    }

    void shoot(){
		
	}

	@Override
	public void run() {

	}
}

class WaterZombie extends Zombie{

	public WaterZombie(Pair<Integer, Integer> zombieCoordinates, ImageView v) {
		super("WaterZombie", 2, 50, 1000, true, zombieCoordinates, v);
		// TODO Auto-generated constructor stub
	}
	void shoot() {
		
	}

	@Override
	public void run() {

	}
}

class ZombieBird extends Zombie{

	public ZombieBird(Pair<Integer, Integer> zombieCoordinates, ImageView v) {
		super("ZombieBird", 3, 30, 1000, true, zombieCoordinates, v);
		// TODO Auto-generated constructor stub
	}
	void airgust() {
		
	}

	@Override
	public void run() {

	}
}

class EarthZombie extends Zombie {


    public EarthZombie(Pair<Integer, Integer> zombieCoordinates, ImageView v) {
        super("EarthZombie", 4, 60, 1000, true, zombieCoordinates, v);
        // TODO Auto-generated constructor stub
    }

	void earthquake() {

	}

	@Override
	public void run() {

	}
}