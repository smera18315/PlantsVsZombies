package mainPackage;

import javafx.animation.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Shear;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class GamePageController {
	
	double  orgSceneX ,   orgSceneY, orgTranslateX, orgTranslateY;
	
	@FXML
    public void lawnMower(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        
        TranslateTransition translate = new TranslateTransition();  
          
        translate.setByX(1500);  
 
        translate.setDuration(Duration.millis(1000));  
        translate.setNode(m);  
  
        translate.play();  

    }
	
	public void press(MouseEvent t){
		
	
		            orgSceneX = t.getSceneX();
		            orgSceneY = t.getSceneY();
		            orgTranslateX = ((ImageView)(t.getSource())).getTranslateX();
		            orgTranslateY = ((ImageView)(t.getSource())).getTranslateY();
		        }
	
	 public void handle(MouseEvent t) {
         double offsetX = t.getSceneX() - orgSceneX -180;
         double offsetY = t.getSceneY() - orgSceneY;
         double newTranslateX = orgTranslateX + offsetX;
         double newTranslateY = orgTranslateY + offsetY;
          
         ((ImageView)(t.getSource())).setTranslateX(newTranslateX);
         ((ImageView)(t.getSource())).setTranslateY(newTranslateY);
     }
		  
		    
		   


	public void fade(MouseEvent e){
		
		  ImageView m = (ImageView) e.getSource();

		  FadeTransition ft = new FadeTransition(Duration.millis(3000), m);
		  
	      ft.setFromValue(0);
	      ft.setToValue(1);
	      //ft.setCycleCount(4);
	      //ft.setAutoReverse(true);
	  
	      ft.play();
	}
	
	public void zombieMove(MouseEvent e){
		
		  ImageView m = (ImageView) e.getSource();
	        TranslateTransition translateUp = new TranslateTransition(Duration.millis(700), m);  
	       //translateUp.setFromX(0);
	        //translateUp.setFromY(0);
	        translateUp.setByX(-30);
	       //translateUp.setByY(-10);

	        TranslateTransition translateDown = new TranslateTransition(Duration.millis(700), m);  
	       // ttDown.setFromX(0);
	        //ttDown.setFromY(0);
	        //translateDown.setByX(-30);
	        translateDown.setByY(10);
	
	       
	       ParallelTransition seqT = new ParallelTransition (m,translateUp, translateDown);  
           
	       seqT.play();  
        
		      
		
	}
	
	
	

}
