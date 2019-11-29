package mainPackage;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import java.util.Random;

public class Sun extends Creature {


    Random r=new Random();
    
    Sun(Plant plant, Pane currentPane) {
        super(plant.plantCoordinates.getKey(), plant.plantCoordinates.getValue(), "Sun"); // Random Values as of now, we'll have to check what the top of the pain is      
        creatureImage=new ImageView(new Image("file:Images/Sun.png"));
        creatureImage.setFitHeight(70);
        creatureImage.setFitWidth(70);
        System.out.println(currentPane);
        if(currentPane!=null)
        {
        	currentPane.getChildren().add(creatureImage);
        }        ((GridPane) currentPane).setColumnIndex(creatureImage,plant.y);
        ((GridPane) currentPane).setRowIndex(creatureImage,plant.x);
        creatureImage.setVisible(false);
    }

    Sun(Pane currentPane) {
        super(100, 1000, "Sun"); // Random Values as of now, we'll have to check what the top of the pain is
        int xCoo=100+r.nextInt(1000);
       
        creatureImage=new ImageView(new Image("file:Images/Sun.png"));
        //System.out.println("X coordinate: "+creatureImage.getX());
        //System.out.println("Y coordinate: "+creatureImage.getY());

        creatureImage.setFitHeight(70);
        creatureImage.setFitWidth(70);
        System.out.println(currentPane);
        if(currentPane!=null)
        {
        	currentPane.getChildren().add(creatureImage);
        }
        creatureImage.setX(xCoo);

        //System.out.println(creatureImage.getParent());

        creatureImage.setVisible(false);
    }
    void moveDown(){
        creatureImage.setVisible(true);
        TranslateTransition animation = new TranslateTransition(
                Duration.seconds(1.5), creatureImage
        );
        //animation.setCycleCount(Animation.INDEFINITE);
        animation.setFromY(creatureImage.getTranslateY()-150);
       // System.out.println("init " + (creatureImage.getTranslateY()-150));
        animation.setToY(creatureImage.getTranslateY()+100+r.nextInt(500));
        //System.out.println("final "+ (creatureImage.getTranslateY()+350));
        animation.setAutoReverse(false);
        animation.play();
        //creatureImage.setOnMouseClicked(event1 -> creatureImage.setVisible(false));
    }
    
    void movecurvedPath() {
    	creatureImage.setVisible(true);
        TranslateTransition animation = new TranslateTransition(
                Duration.seconds(1.5), creatureImage
        );
       // animation.setCycleCount(Animation.INDEFINITE);
        animation.setFromX(creatureImage.getTranslateX()+50);
        animation.setToX(creatureImage.getTranslateX()+100);
        animation.setFromY(creatureImage.getTranslateX()+50);
        animation.setToY(creatureImage.getTranslateX()+75);
        animation.setAutoReverse(false);
        animation.play();
    }
}
