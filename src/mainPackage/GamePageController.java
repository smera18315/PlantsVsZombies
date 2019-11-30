package mainPackage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;


public class GamePageController {
	
public class addRandZombie extends AnimationTimer {
	Random r = new Random();
	int counter = 0;

        @Override
        public void handle(long now) {
        	counter = counter+1;
        
        	Zombie zombie = new FireZombie(new Pair<Integer, Integer>(300,300));
        	if(gridPane!=null)
        	{
        		int row = 1 + r.nextInt(5);
        		if(counter%300==0)
        		{
            		counter = 0;
        			gridPane.getChildren().add(zombie.creatureImage);
        			if(yardGrid.get(9).get(row)==null)
        			{
            			yardGrid.get(9).set(row, zombie);

        			}
        			zombie.creatureImage.setFitHeight(160);
                    zombie.creatureImage.setFitWidth(110);
            		
            		gridPane.setColumnIndex(zombie.creatureImage, 9);
            		gridPane.setRowIndex(zombie.creatureImage, row);
            		zombie.moveLeft();
        		}
        		
        		
        	}
    		

        }

}

	void zombieGenerator()
	{
		Zombie zombie = new FireZombie(new Pair<Integer, Integer>(300,300));
		//zombie=randomZombieGenerator();
		zombie.moveLeft();
		//System.out.println("zombie");
//		if (sun.creatureImage.isVisible()) {
//			sun.creatureImage.setOnMouseClicked(e->{
//				sun.creatureImage.setVisible(false);
//				sunCounter++;
//				String s=Integer.toString(sunCounter);
//				sunCount.setText(s);
//
//			});
//		}
		
	}
	@FXML
	void setPane(MouseEvent e)
	{
		if(mainPane==null)
		{
			mainPane=(Pane)((Node) e.getSource()).getParent();
			((Node) e.getSource()).setMouseTransparent(true);
		}
	}
	
	@FXML
	void setGrid(MouseEvent e)
	{
		if(mainPane==null && ((Node) e.getSource()).getParent().getClass().getName()=="Grid")
		{
			mainPane=(GridPane)((Node) e.getSource()).getParent();
			((Node) e.getSource()).setMouseTransparent(true);
		}
	}

	{
		addRandZombie ard1 = new addRandZombie();
		ard1.start();
		sunGeneratorThread s1 = new sunGeneratorThread();
		s1.start();
	}
	void setText(String s)
	{
		sunCount.setText(s);
	}
	@FXML Pane mainPane;
	@FXML Label sunCount;
	@FXML GridPane gridPane;
	static int sunCounter=0;
	
	public void sunGenerator() {
		//System.out.println("sg"+mainPane);
		Sun sun=new Sun(mainPane);
		sun.moveDown();
		if (sun.creatureImage.isVisible()) {
			sun.creatureImage.setOnMouseClicked(e->{
				sun.creatureImage.setVisible(false);
				sunCounter++;
				String s=Integer.toString(sunCounter);
				sunCount.setText(s);

			});
		}
	}
	
public class collisionCheck extends AnimationTimer {
    	
    	Bullet bullet;
    	Zombie zombie;
    	
    	collisionCheck(Bullet pea, Zombie z)
    	{
    		this.bullet = pea;
    		this.zombie = z;
    	}
    	

        @Override
        public void handle(long now) {
        
        		if (bullet.creatureImage.getBoundsInParent().intersects(zombie.creatureImage.getBoundsInParent())) {
		    	
		    	bullet.creatureImage.setVisible(false);
		    	System.out.println("init"+zombie.getZombieHealth());

		    	zombie.setZombieHealth(zombie.getZombieHealth()-30);
		    	System.out.println(zombie.getZombieHealth());
		    	if(zombie.getZombieHealth()<=0)
		    	{
			    	System.out.println("wtf"+zombie.getZombieHealth());

		    		zombie.setZombieAlive(false);
		    		zombie.creatureImage.setVisible(false);	
		    		
		    		if(((Pane) zombie.creatureImage.getParent())!=null)
		    		{
			    		((Pane) zombie.creatureImage.getParent()).getChildren().remove(zombie.creatureImage);

		    		}
			    	System.out.println("udhvarg");
//			  		gridPane.getChildren().remove(zombie.creatureImage);
			  		stop();
			  		return;
		    	}
        	}
        }
        
    }
    
public class sunGeneratorThread extends AnimationTimer {
    	
    	int counter = 0;

        @Override
        public void handle(long now) {
        
        	counter = counter + 1;
        	if(counter%600 == 0)
        	{
        		counter = 0;
        		sunGenerator();
        		zombieGenerator();
        	}
        }

        
    }

    
 public class peaGeneratorThread extends AnimationTimer {
    	
    	Plant plant;
    	Pane pane;
    	Zombie z;
    	int counter = 0;
    	peaGeneratorThread(Plant plant, Pane pane,Zombie z)
    	{
    		this.plant = plant;
    		this.pane = pane;
    		this.z = z;
    	}
    	

        @Override
        public void handle(long now) {
        	
        	counter = counter + 1;
        	if(counter%60 == 0)
        	{
        		counter = 0;
        		Bullet pea = new Bullet(plant,pane);
            	pea.moveRight();
            	collisionCheck t1 = new collisionCheck(pea, z);
                t1.start();
                if(z.isZombieAlive()==false)
                {
                	stop();
                }
        	}
        

        }

        
    }
	
 public class sunFlowerGeneratorThread extends AnimationTimer {
 	
 	Plant plant;
 	Pane pane;
 	int counter = 0;
 	sunFlowerGeneratorThread(Plant plant, Pane pane)
 	{
 		this.plant = plant;
 		this.pane = pane;
 	}
 	

     @Override
     public void handle(long now) {
     	
     	counter = counter + 1;
     	if(counter%300 == 0)
     	{
     		counter = 0;
     		Sun sun = new Sun(plant,pane);
         	sun.movecurvedPath();
         	if (sun.creatureImage.isVisible()) {
    			sun.creatureImage.setOnMouseClicked(e->{
    				sun.creatureImage.setVisible(false);
    				sunCounter++;
    				String s=Integer.toString(sunCounter);
    				//sunCount.setText(s);

    			});
    		}
            //t1.start();
     	}
     

     }

     
 }

	  public void checkCollisions(Bullet bullet, Zombie zombie) {
		  
		    //Rectangle2D bulletRectangle = new Rectangle2D(bullet.creatureImage.getX(), bullet.creatureImage.getY(), bullet.creatureImage.getFitWidth(), bullet.creatureImage.getFitHeight());
		  	//System.out.println("parent:"+zombie.creatureImage.getParent());
;		    //Rectangle2D zombieRectangle = new Rectangle2D(zombie.creatureImage.getX(), zombie.creatureImage.getY(), zombie.creatureImage.getFitWidth(), zombie.creatureImage.getFitHeight());
		    if (bullet.creatureImage.getBoundsInParent().intersects(zombie.creatureImage.getBoundsInParent())) {
		    	
		    	bullet.creatureImage.setVisible(false);
		    	System.out.println("init"+zombie.getZombieHealth());

		    	zombie.setZombieHealth(zombie.getZombieHealth()-100);
		    	System.out.println(zombie.getZombieHealth());
		    	if(zombie.getZombieHealth()<=0)
		    	{
			    	System.out.println("wtf"+zombie.getZombieHealth());

		    		zombie.setZombieAlive(false);
		    		zombie.creatureImage.setVisible(false);	
		    		Pane pane = (GridPane) zombie.creatureImage.getParent();
			    	System.out.println(pane);
			  		pane.getChildren().remove(zombie.creatureImage);
		    	}
		    	
//		    	
//		    	if(zombie.isZombieAlive()==false)
//		    	{
//		    		zombie.creatureImage.setVisible(false);	
//		    	}
		    	
		    	
//		    	if(zombie.creatureImage.getParent()!=null)
//		    	{
//				  	final Pane pane = 
//				  	System.out.println(pane);
//				  	
//		    	}

//		    	if(pane!=null)
//			  	{
//			  		gridPane.getChildren().remove(zombie.creatureImage);
//			  	}
                
               //System.out.println("Collision");
                //zombie.creatureImage.setVisible(false);
            }
		    
            //zombie.creatureImage.setVisible(true);

		    
	  }
		   // for (Zombie zombie : zombieList) {
//	            
//			    
//
//	            
//	        }
	

//	        List<Missile> ms = spaceship.getMissiles();
//
//	        for (Missile m : ms) {
//
//	            Rectangle r1 = m.getBounds();
//
//	            for (Alien alien : aliens) {
//
//	                Rectangle r2 = alien.getBounds();
//
//	                if (r1.intersects(r2)) {
//	                    
//	                    m.setVisible(false);
//	                    alien.setVisible(false);
//	                }
//	            }
//	        }
//	    }
	LevelGame thisLevel = new LevelGame();
	ArrayList<ArrayList<Creature>> yardGrid = new ArrayList<ArrayList<Creature>>();
	ArrayList<Plant> constructorList = new ArrayList<Plant>(5);
	ArrayList<Zombie> zombieList = new ArrayList<Zombie>();

	{
		for(int i=0; i<=5;++i)
		{
			constructorList.add(null);
		}
		
		for(int i=0; i<=10;++i)
		{
			ArrayList<Creature> list = new ArrayList<Creature>(constructorList);
			yardGrid.add(list);
		}
		

	}
	//double  orgSceneX ,   orgSceneY, orgTranslateX, orgTranslateY;
	void zombieSetup()
	{
		ArrayList<Zombie> zombieList = new ArrayList<Zombie>();
		//Zombie z1 = new Z
		
	}
	@FXML
    public void lawnMower(MouseEvent e){
        ImageView lawnMower = (ImageView) e.getSource();

		ArrayList<Sun> sunArr=new ArrayList<Sun>(5);
		for (int i=0;i<5;i++) {
			sunArr.add(new Sun((Pane) lawnMower.getParent()));
		}
		for (int i=0;i<5;i++) {
		       //((Pane) lawnMower.getParent()).getChildren().add(sunArr.get(i).creatureImage);
			System.out.println("sun");
			sunArr.get(i).moveDown();			
			System.out.println("sun2");

		}
		int ctr=0;
		for (int i=0;i<5;i++) {
			if (sunArr.get(i).creatureImage.isVisible()) {
				ctr++;
				sunArr.set(i, null);
			}
		}
		System.out.println(ctr);
		ImageView newImage = new ImageView(new Image("file:Images/Zombies/waterZombie.png"));
        System.out.println(lawnMower.getParent());
		Zombie z = new FireZombie(new Pair<Integer, Integer>((int)(lawnMower.getX()),(int)(lawnMower.getY())));

       //((Pane) lawnMower.getParent()).getChildren().add(z.creatureImage);
       //z.setVisible(true);
        //Pane pain = new Pane(lawnMower.getParent());
        //System.out.println(pain);
        //pain.getChildren().add(newImage);
       // newImage.setX(lawnMower.getX());
		//newImage.setY(lawnMower.getY());
		//newImage.setVisible(true);
		//Zombie z = new FireZombie(new Pair<Integer, Integer>((int)(lawnMower.getX()),(int)(lawnMower.getY())));
		//z.getZombieImage().();
		
        TranslateTransition translate = new TranslateTransition();  
        translate.setNode(lawnMower);  
        translate.setByX(1500);  
        translate.setDuration(Duration.millis(2000));  
        translate.play();  

    }

	@FXML
	public void fade(MouseEvent e){		//Fade Animation
		
		ImageView card = (ImageView) e.getSource();
		FadeTransition fade = new FadeTransition(Duration.millis(3000), card);
		  
		fade.setFromValue(0);
		fade.setToValue(1);
		fade.play();
	}
	
	public void zombieMove(MouseEvent e){	//Moving zombie function
		
		 ImageView zombie = (ImageView) e.getSource();
	        
	     TranslateTransition zombieMove = new TranslateTransition();  
	     //System.out.println("hi");
	     zombieMove.setNode(zombie);  
	     zombieMove.setByX(-675);  
	     zombieMove.setDuration(Duration.millis(30000));  
	     zombieMove.play(); 
	        
	     zombieMove.setOnFinished(new EventHandler<ActionEvent>() {
	    	@Override
			public void handle(ActionEvent event) {
	    		zombie.setMouseTransparent(true);
			}
		});	
		
	}
	
	 public void dragDetected(MouseEvent e) throws InterruptedException {	//Dragging plant cards
		 ImageView cardDrag = (ImageView) e.getSource();

	     Dragboard db = cardDrag.startDragAndDrop(TransferMode.ANY);
	     ClipboardContent content = new ClipboardContent();
	     content.putString(cardDrag.getImage().getUrl());
	     db.setContent(content);
		 //System.out.println(db.getString());

	     e.consume();
	     
	     FadeTransition cardFade = new FadeTransition(Duration.millis(10000), cardDrag);
	     cardFade.setOnFinished(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					cardDrag.setMouseTransparent(false);
				}
			});		     
	     cardFade.setFromValue(-10);
	     cardFade.setToValue(10);
	     cardFade.play();
		 cardDrag.setMouseTransparent(true);
	    }
	 
	 public void dragOver(DragEvent e) {
	        if (e.getDragboard().hasString()) {
	            e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
	        } 
	        e.consume();
	    }
	 public static Plant parseURL(String s, Pair<Integer,Integer> a, Pane currentPane,int x, int y){	//fix this so that it runs on other systems
	        if (s.equals("file:/C:/Users/Smera/eclipse-workspace/PlantsVsZombies/Images/PeashooterGif.gif")){
	            return new PeaShooter(a, currentPane,x,y);
	        }
	        else if (s.equals("file:/C:/Users/Smera/eclipse-workspace/PlantsVsZombies/Images/SunflowerGif.gif")){
	            return new SunFlower(a,currentPane,x,y);
	        }
	        else if (s.equals("file:/C:/Users/Smera/eclipse-workspace/PlantsVsZombies/Images/WalnutGif.gif")){
	            return new Walnut(a,x,y);
	        }
	        else if (s.equals("file:/C:/Users/Smera/eclipse-workspace/PlantsVsZombies/Images/MineGif.gif")){
	            return new CherryBomb(a,x,y);
	        }
	        else{
	            return null;
	        }
	    }
	 public void dragDropped(DragEvent e) throws InterruptedException {
		ImageView cell = (ImageView) e.getTarget();
	    Dragboard db = e.getDragboard();
	    boolean flag = false;
	    if (db.hasString()) {
	    	if(cell.getImage()==null)
	    	{
    			System.out.println(db.getString());
    			GridPane gp = (GridPane)cell.getParent();
    			int  x = gp.getRowIndex(cell);
		        System.out.println(x);
		    	int y = gp.getColumnIndex(cell);
		        System.out.println(y);
		        
    			cell.setImage(new Image(db.getString()));
		        flag = true;
		        System.out.println(cell.getLayoutX());
		        System.out.println("hi");

		        Pair<Integer, Integer> plantCoordinate = new Pair<Integer, Integer>((int)cell.getLayoutX(), (int)cell.getLayoutY());
		        System.out.println("hi22");
		        System.out.println(cell.getParent());
		        Plant newPlant = parseURL(db.getString(), plantCoordinate, (Pane)(cell.getParent()),x,y);	//parseURL is a function that takes in the url, strips and gets the name from it and returns a plant type variable
		        newPlant.x = x;
		        newPlant.y = y;
		        //System.out.println(yardGrid);
		        
		        yardGrid.get(x).set(y, newPlant);
		        System.out.println(yardGrid);

		        System.out.println("hi");

		        thisLevel.addPlants(newPlant);

		        cell.setUserData(newPlant);
		        if(newPlant.getPlantName()=="Peashooter")
		        {
			        
		        	System.out.println("hi6"+yardGrid.get(9));
		        	if((Zombie)(yardGrid.get(9).get(x))!=null)
		        		
		        	{
			        	newPlant.attack((Zombie)(yardGrid.get(9).get(x)));

		        	}

		        	Zombie z = (Zombie)(yardGrid.get(9).get(x));
		        	if(z.isZombieAlive()==false)
		        	{
		        		yardGrid.get(9).set(x,null);
		        	}
			        System.out.println("hi5");

		        }
		        else if(newPlant.getPlantName().equals("CherryBomb")) {
		        	CherryBomb plant=(CherryBomb) newPlant;
		        	plant.blast(mainPane);
		        }
		        else
		        {
			        newPlant.attack();

		        }

		        System.out.println("hi");

		      //  System.out.println(cell.getUserData());
		       // System.out.println("h2");

//		        for(ArrayList<Plant> i: yardGrid)
//		        {
//		        	System.out.println(i);
//		        }
	    	}
	    	
	    	else if(db.getString().contains("Shovel"))
    		{
    			//System.out.println("shovel");
    			cell.setImage(null);
    		}
	    
	    }
	    e.setDropCompleted(flag);
	    e.consume();
	}
	 
	 @FXML
	 public void Menu(MouseEvent e) throws IOException {	//Menu Button
		Parent root= FXMLLoader.load(getClass().getResource("InGameMenu.fxml"));
		Stage stage = (Stage) ((Node)e.getTarget()).getScene().getWindow();
		stage.setScene(new Scene(root));

	 }
	 
	 @FXML
	 public void Clock(MouseEvent e){		//Timer Animation
		 ImageView m = (ImageView) e.getSource();

		 RotateTransition rotateClock = new RotateTransition(); 
		 rotateClock.setNode(m);  
		 rotateClock.setByAngle(360);   
		 rotateClock.setAxis(Rotate.Z_AXIS);  
		 rotateClock.setDuration(Duration.millis(60000));  
		 rotateClock.play();  

	 }
	 
	    @FXML
	    public void mouseZombieHead(MouseEvent e){
	        ImageView m = (ImageView) e.getSource();
	        TranslateTransition animation = new TranslateTransition(
	                Duration.seconds(60), m
	        );
	        //animation.setCycleCount(Animation.INDEFINITE);
	        animation.setFromX(m.getTranslateX());
	        animation.setToX(m.getTranslateX()-400);
	        animation.setAutoReverse(false);
	        animation.play();
	    }
	 
	 
	

}
