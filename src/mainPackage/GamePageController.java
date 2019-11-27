package mainPackage;

import java.io.IOException;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;


public class GamePageController {
	
	LevelGame thisLevel = new LevelGame();
	
	double  orgSceneX ,   orgSceneY, orgTranslateX, orgTranslateY;
	
	@FXML
    public void lawnMower(MouseEvent e){
        ImageView lawnMower = (ImageView) e.getSource();
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
	 public static Plant parseURL(String s, Pair<Integer,Integer> a){	//fix this so that it runs on other systems
	        if (s.equals("file:/C:/Users/Smera/eclipse-workspace/PlantsVsZombies/Images/PeashooterGif.gif")){
	            return new PeaShooter(a);
	        }
	        else if (s.equals("file:/C:/Users/Smera/eclipse-workspace/PlantsVsZombies/Images/SunflowerGif.gif")){
	            return new SunFlower(a);
	        }
	        else if (s.equals("file:/C:/Users/Smera/eclipse-workspace/PlantsVsZombies/Images/WalnutGif.gif")){
	            return new Walnut(a);
	        }
	        else if (s.equals("file:/C:/Users/Smera/eclipse-workspace/PlantsVsZombies/Images/MineGif.gif")){
	            return new CherryBomb(a);
	        }
	        else{
	            return null;
	        }
	    }
	 public void dragDropped(DragEvent e) {
		ImageView cell = (ImageView) e.getTarget();
	    Dragboard db = e.getDragboard();
	    boolean flag = false;
	    if (db.hasString()) {
	    	if(cell.getImage()==null)
	    	{
    			System.out.println(db.getString());
    			cell.setImage(new Image(db.getString()));
		        flag = true;
		        System.out.println(cell.getLayoutX());
		        Pair<Integer, Integer> plantCoordinate = new Pair<Integer, Integer>((int)cell.getLayoutX(), (int)cell.getLayoutY());
		        Plant newPlant = parseURL(db.getString(), plantCoordinate);	//parseURL is a function that takes in the url, strips and gets the name from it and returns a plant type variable
//		        arrYard.get(plantCoordinate.getKey()).get(plantCoordinate.getValue()).set(newPlant);
//		        thisLevel.addPlants(newPlant);
//		        cell.setUserData(newPlant);
		        
		        System.out.println(cell.getUserData());
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
	 
	 
	

}
