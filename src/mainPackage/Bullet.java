package mainPackage;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Bullet extends Creature {


    Bullet(Plant plant, Pane currentPane) {
        super(plant.plantCoordinates.getKey(), plant.plantCoordinates.getValue(), "Bullet");
        creatureImage=new ImageView(new Image("file:Images/PeaUse.png"));
        creatureImage.setFitHeight(30);
        creatureImage.setFitWidth(30);
        creatureImage.setLayoutX(plant.plantCoordinates.getKey()+500);
        creatureImage.setY(plant.plantCoordinates.getValue());
        //System.out.println("hi");
        currentPane.getChildren().add(creatureImage);
        //System.out.println(plant.x);

        ((GridPane) currentPane).setColumnIndex(creatureImage,plant.y);
        ((GridPane) currentPane).setRowIndex(creatureImage,plant.x);

        //System.out.println(creatureImage.getParent());

        creatureImage.setVisible(false);
    }
    void moveRight(){
    	creatureImage.setVisible(true);
        TranslateTransition animation = new TranslateTransition(
                Duration.seconds(1.5), creatureImage
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.setFromX(creatureImage.getTranslateX()+50);
        animation.setToX(creatureImage.getTranslateX()+750);
        animation.setAutoReverse(false);
        animation.play();
    }
}
