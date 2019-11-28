package mainPackage;
import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javafx.scene.layout.Pane;
import javafx.util.Pair;

public abstract class Plant extends Creature implements Serializable, Runnable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 942001018781760401L;
	private String plantName, plantType;
	private int plantID, plantHealth, plantWaitingTime, plantSunCost, plantAttack;
	private boolean isPlantAlive, isPlantLocked;
	static int plantCounter = 0;
	Pair<Integer, Integer> plantCoordinates;
	
	public Plant(String plantName, String plantType, int plantID, int plantHealth, int plantWaitingTime,
			int plantSunCost, int plantAttack, boolean isPlantAlive, boolean isPlantLocked,
			Pair<Integer, Integer> plantCoordinates) {
		super(plantCoordinates.getKey(),plantCoordinates.getValue(),"Plant");
		this.plantName = plantName;
		this.plantType = plantType;
		this.plantID = plantID;
		this.plantHealth = plantHealth;
		this.plantWaitingTime = plantWaitingTime;
		this.plantSunCost = plantSunCost;
		this.plantAttack = plantAttack;
		this.isPlantAlive = isPlantAlive;
		this.isPlantLocked = isPlantLocked;
		this.plantCoordinates = plantCoordinates;
	}

	public abstract void attack() throws InterruptedException;
	public void heal(int healPoints)
	{
		plantHealth = plantHealth + healPoints;
	}
	
	public void shovel()
	{
		
	}
	
}

class Walnut extends Plant
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8853268217182944234L;

	public Walnut(Pair<Integer, Integer> plantCoordinates) {
		super("Walnut", "Defense Plant", 3, 150, 25, 75, 0, true, false,plantCoordinates);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}

class CherryBomb extends Plant
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7175064322338571913L;
	private int blastRadius = 1;
	public CherryBomb(Pair<Integer, Integer> plantCoordinates) {
		super("CherryBomb", "Exploding Plant", 4, 0, 30, 150, 100, true, false, plantCoordinates);
	}

	@Override
	public void attack() {
		int x = plantCoordinates.getKey();
		int y = plantCoordinates.getValue();
		for(int i = x-blastRadius; i <= x+blastRadius; ++i)
		{
			for(int j = y-blastRadius; j <= y+blastRadius; ++j)
			{
//				if(hasZombie(i,j))
//				{
//					zombie.setHealth = zombie.getHealth() - plantAttack;
//				}
			}
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}

class SunFlower extends Plant
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -801862830491365216L;
	private int generationSpeed = 10;
	public SunFlower(Pair<Integer, Integer> plantCoordinates) {
		super("Sunflower", "Sun Producing Plant", 1, 100, 20, 50, 0, true, false, plantCoordinates);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack() {
			}
	
	public void generateSun()
	{
		
		
	}

	@Override
	public void run() {			//Generate Sun
		
	}
	
}

class PeaShooter extends Plant
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1760906844762856176L;
	
	ArrayList<Bullet> peaList;
	public PeaShooter(Pair<Integer, Integer> plantCoordinates, Pane currentPane) {
		super("Peashooter", "Pea Shooting Plant", 2, 100, 20, 100, 10, true, false,	plantCoordinates);
		peaList=new ArrayList<Bullet>(5);
		for (int i=0;i<5;i++){
			peaList.add(new Bullet(this, currentPane));
		}
	}

	@Override
	public void attack() throws InterruptedException {
		for (int i=0;i<peaList.size();i++){
			peaList.get(i).moveRight();
			//TimeUnit.MILLISECONDS.sleep(10);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
}

