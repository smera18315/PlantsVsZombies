package mainPackage;
import javafx.util.Pair;

public abstract class Plant {
	private String plantName, plantType;
	private int plantID, plantHealth, plantWaitingTime, plantSunCost, plantAttack;
	private boolean isPlantAlive, isPlantLocked;
	static int plantCounter = 0;
	Pair<Integer, Integer> plantCoordinates;
	
	public Plant(String plantName, String plantType, int plantID, int plantHealth, int plantWaitingTime,
			int plantSunCost, int plantAttack, boolean isPlantAlive, boolean isPlantLocked,
			Pair<Integer, Integer> plantCoordinates) {
		super();
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

	public abstract void attack();
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

	public Walnut(String plantName, String plantType, int plantID, int plantHealth, int plantWaitingTime,
			int plantSunCost, int plantAttack, boolean isPlantAlive, boolean isPlantLocked, Pair<Integer, Integer> plantCoordinates) {
		super(plantName, plantType, plantID, plantHealth, plantWaitingTime, plantSunCost, plantAttack, isPlantAlive, isPlantLocked,
				plantCoordinates);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
	
}

class CherryBomb extends Plant
{
	private int blastRadius = 1;
	public CherryBomb(String plantName, String plantType, int plantID, int plantHealth, int plantWaitingTime,
			int plantSunCost, int plantAttack, boolean isPlantAlive, boolean isPlantLocked, Pair<Integer, Integer> plantCoordinates) {
		super(plantName, plantType, plantID, plantHealth, plantWaitingTime, plantSunCost, plantAttack, isPlantAlive, isPlantLocked,
				plantCoordinates);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
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
	
}

class SunFlower extends Plant
{
	private int generationSpeed = 10;
	public SunFlower(String plantName, String plantType, int plantID, int plantHealth, int plantWaitingTime,
			int plantSunCost, int plantAttack, boolean isPlantAlive, boolean isPlantLocked, Pair<Integer, Integer> plantCoordinates) {
		super(plantName, plantType, plantID, plantHealth, plantWaitingTime, plantSunCost, plantAttack, isPlantAlive, isPlantLocked,
				plantCoordinates);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack() {
			}
	
	public void generateSun()
	{
		
		
	}
	
}

class PeaShooter extends Plant
{
	private Bullet pea = new Bullet();
	public PeaShooter(String plantName, String plantType, int plantID, int plantHealth, int plantWaitingTime,
			int plantSunCost, int plantAttack, boolean isPlantAlive, boolean isPlantLocked, Pair<Integer, Integer> plantCoordinates) {
		super(plantName, plantType, plantID, plantHealth, plantWaitingTime, plantSunCost, plantAttack, isPlantAlive, isPlantLocked,
				plantCoordinates);
	}

	@Override
	public void attack() {
	}
	
	
}

