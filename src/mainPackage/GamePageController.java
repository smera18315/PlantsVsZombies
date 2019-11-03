package mainPackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import javafx.scene.transform.Shear;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
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
	        
	        TranslateTransition translate = new TranslateTransition();  
	        //System.out.println("hi");
	        translate.setByX(-675);  
	 
	        translate.setDuration(Duration.millis(50000));  
	        translate.setNode(m);  
	  
	        translate.play(); 		      
		
	}
	
	 public void dragDetected(MouseEvent e) throws InterruptedException {
		 ImageView m = (ImageView) e.getSource();

	        Dragboard db = m.startDragAndDrop(TransferMode.ANY);
	        ClipboardContent content = new ClipboardContent();
	        content.putString(m.getImage().getUrl());
	        db.setContent(content);

	        e.consume();
	        

			FadeTransition ft = new FadeTransition(Duration.millis(10000), m);
			ft.setOnFinished(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					m.setMouseTransparent(false);
				}
			});		     
			ft.setFromValue(-10);
		    ft.setToValue(10);
		    ft.play();
		    m.setMouseTransparent(true);
	    }
	 
	 public void dragOver(DragEvent e) {
	        if (e.getDragboard().hasString()) {
	            e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
	        }
	        
	        e.consume();
	    }
	 
	 public void dragDropped(DragEvent e) {
		ImageView cell = (ImageView) e.getTarget();
	    Dragboard db = e.getDragboard();
	    boolean success = false;
	    if (db.hasString()) {
	    	if(cell.getImage()==null)
	    	{
	    		cell.setImage(new Image(db.getString()));
		        success = true;
	    	}
	    
	    }

	    e.setDropCompleted(success);
	    e.consume();
	}
	 
	 public void dragDetectedShovel(MouseEvent e) throws InterruptedException {
		 ImageView m = (ImageView) e.getSource();

	     Dragboard db = m.startDragAndDrop(TransferMode.ANY);
	     ClipboardContent content = new ClipboardContent();
	     content.putImage(null);
	     db.setContent(content);
	     e.consume();
	     
	    }
	 
	 @FXML
	 public void Menu(MouseEvent e) throws IOException {
		Parent root= FXMLLoader.load(getClass().getResource("InGameMenu.fxml"));
		Stage stage = (Stage) ((Node)e.getTarget()).getScene().getWindow();
		stage.setScene(new Scene(root));

	 }
	 
	 @FXML
	 public void Clock(MouseEvent e){
		 ImageView m = (ImageView) e.getSource();

		 RotateTransition rotate = new RotateTransition();  
		 rotate.setByAngle(360);   
	     rotate.setAxis(Rotate.Z_AXIS);  
	     rotate.setDuration(Duration.millis(60000));  
	     rotate.setNode(m);  
	     rotate.play();  
	          

	 }
	

}
