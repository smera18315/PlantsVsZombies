package mainPackage;

import java.util.concurrent.TimeUnit;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
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
	 
	 public void dragOver(DragEvent event) {
	        /* data is dragged over the target */
	        /* accept it only if it is not dragged from the same node 
	         * and if it has a string data */
	        if (event.getDragboard().hasString()) {
	            /* allow for both copying and moving, whatever user chooses */
	            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
	        }
	        
	        event.consume();
	    }
	 
	 public void dragDropped(DragEvent event) {
		ImageView target = (ImageView) event.getTarget();
	        /* data dropped */
	        /* if there is a string data on dragboard, read it and use it */
	        Dragboard db = event.getDragboard();
	        boolean success = false;
	        if (db.hasString()) {
	        //String name = db.getImage().getUrl();
	        //System.out.println(db.getString());
	           target.setImage(new Image(db.getString()));
	           success = true;
	        }
	        /* let the source know whether the string was successfully 
	         * transferred and used */
	        event.setDropCompleted(success);
	        
	        event.consume();
	     }
	

}
