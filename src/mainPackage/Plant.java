package mainPackage;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.util.Pair;
import mainPackage.GamePageController.peaGeneratorThread;
import mainPackage.GamePageController.sunFlowerGeneratorThread;

public abstract class Plant extends Creature implements Serializable, Runnable, Cloneable {
	/**
	 * 
	 */
	int x,y;
	private static final long serialVersionUID = 942001018781760401L;
	private String plantName, plantType;
	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	private int plantID, plantHealth, plantWaitingTime, plantSunCost, plantAttack;
	private boolean isPlantAlive, isPlantLocked;
	static int plantCounter = 0;
	Pair<Integer, Integer> plantCoordinates;
	
	public Plant(String plantName, String plantType, int plantID, int plantHealth, int plantWaitingTime,
			int plantSunCost, int plantAttack, boolean isPlantAlive, boolean isPlantLocked,
			Pair<Integer, Integer> plantCoordinates, int x, int y) {
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
		this.x=x;
		this.y=y;
	}

	public abstract void attack() throws InterruptedException;
	public abstract void attack(Zombie z) throws InterruptedException;
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

	public Walnut(Pair<Integer, Integer> plantCoordinates, int x, int y) {
		super("Walnut", "Defense Plant", 3, 1400, 25, 75, 0, true, false,plantCoordinates,x,y);
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

	@Override
	public void attack(Zombie z) throws InterruptedException {
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
	ImageView blastImg;
	public CherryBomb(Pair<Integer, Integer> plantCoordinates, int x, int y) {
		super("CherryBomb", "Exploding Plant", 4, 0, 30, 150, 100, true, false, plantCoordinates,x,y);
	}
	
    static int getTime(){
        LocalDateTime now= LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String n=dtf.format(now);
        String loopTime=String.valueOf(n.charAt(14))+String.valueOf(n.charAt(15))+String.valueOf(n.charAt(17))+String.valueOf(n.charAt(18));
        int yayy=Integer.parseInt(loopTime);
        return yayy;
    }

	@Override
	public void attack() {
		System.out.println("yassattack");

		creatureImage.setImage(new Image("file:Images/BlastCherry.png"));
		creatureImage.setVisible(true);
        int init=getTime();
        int fin;
		System.out.println("yass");
        while (true){
        	System.out.println("hi");
            fin=getTime();
            if (fin-init>1){
                break;
            }
        }
		super.creatureImage.setVisible(true);
		LocalDateTime then;
		System.out.println("yass");
		
		int x = plantCoordinates.getKey();
		int y = plantCoordinates.getValue();
		for(int i = x-blastRadius; i <= x+blastRadius; ++i)
		{
			for(int j = y-blastRadius; j <= y+blastRadius; ++j)
			{
//				
				//if(hasZombie(i,j))
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

	@Override
	public void attack(Zombie z) throws InterruptedException {
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
	Pane currentPane;
	ArrayList<Sun> sunList;
	public SunFlower(Pair<Integer, Integer> plantCoordinates,Pane currentPane, int x, int y) {
		super("Sunflower", "Sun Producing Plant", 1, 100, 20, 50, 0, true, false, plantCoordinates,x,y);
		this.currentPane = currentPane;
		sunList=new ArrayList<Sun>(5);
		for (int i=0;i<5;i++){
			sunList.add(new Sun(currentPane));
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack() {
		sunFlowerGeneratorThread p1 = new GamePageController().new sunFlowerGeneratorThread(this, currentPane);
        p1.start();
			}
	
	public void generateSun(){

	}

	@Override
	public void run() {			//Generate Sun
		
	}

	@Override
	public void attack(Zombie z) throws InterruptedException {
		// TODO Auto-generated method stub
		
	}
	
}

class PeaShooter extends Plant
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1760906844762856176L;
	
	ArrayList<Bullet> peaList;
	public PeaShooter(Pair<Integer, Integer> plantCoordinates, Pane currentPane, int x, int y) {
		super("Peashooter", "Pea Shooting Plant", 2, 100, 20, 100, 10, true, false,	plantCoordinates,x,y);
		peaList=new ArrayList<Bullet>(5);
		for (int i=0;i<5;i++){
			peaList.add(new Bullet(this, currentPane));
		}
	}
	@Override
	public void attack()
	{
		
	}

	public void attack(Zombie z) throws InterruptedException {
		//Zombie z = new FireZombie(new Pair<Integer, Integer>(700,300));
		
		Pane currentPane = ((Pane) peaList.get(1).creatureImage.getParent());
		//currentPane.getChildren().add(z.creatureImage);
        //System.out.println(currentPane);
        //z.creatureImage.setVisible(false);
        //z.creatureImage.setFitHeight(160);
        //z.creatureImage.setFitWidth(110);
		//GridPane.setColumnIndex(z.creatureImage,4);
        //GridPane.setRowIndex(z.creatureImage,1);
        
        //peaList.get(1).moveRight();
		
        //z.creatureImage.setVisible(true);
        peaGeneratorThread p1 = new GamePageController().new peaGeneratorThread(this, currentPane, z);
        p1.start();
        //t1.start();

//		for (int i=0;i<peaList.size();i++){
//			peaList.get(1).moveRight();
//			
//	        //z.creatureImage.setVisible(true);
//	        
//	        MyTimer t1 = new GamePageController().new MyTimer(peaList.get(i), z);
//	        t1.start();
//	     
//	        
//			//TimeUnit.MILLISECONDS.sleep(10);
//		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
}

