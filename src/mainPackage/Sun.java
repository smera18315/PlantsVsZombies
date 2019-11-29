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



    Sun(Pane currentPane) {
        super(100, 1000, "Sun"); // Random Values as of now, we'll have to check what the top of the pain is
        Random r=new Random();
        int xCoo=100+r.nextInt(120);
       
        creatureImage=new ImageView(new Image("file:Images/Sun.png"));
        System.out.println("X coordinate: "+creatureImage.getX());
        System.out.println("Y coordinate: "+creatureImage.getY());

        creatureImage.setFitHeight(50);
        creatureImage.setFitWidth(50);
        currentPane.getChildren().add(creatureImage);
        creatureImage.setX(xCoo);
//        ((GridPane) currentPane).setColumnIndex(creatureImage,plant.y);
//        ((GridPane) currentPane).setRowIndex(creatureImage,plant.x);
//
        System.out.println(creatureImage.getParent());

        creatureImage.setVisible(false);
    }
    void moveDown(){
        creatureImage.setVisible(true);
        TranslateTransition animation = new TranslateTransition(
                Duration.seconds(1.5), creatureImage
        );
        //animation.setCycleCount(Animation.INDEFINITE);
        animation.setFromY(creatureImage.getTranslateY()-150);
        System.out.println("init " + (creatureImage.getTranslateY()-150));
        animation.setToY(creatureImage.getTranslateY()+350);
        System.out.println("final "+ (creatureImage.getTranslateY()+350));
        animation.setAutoReverse(false);
        animation.play();
    }
}
