package mainPackage;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Bullet extends Creature {


    Bullet(Plant plant, Pane currentPane) {
        super(plant.plantCoordinates.getKey(), plant.plantCoordinates.getValue(), "Bullet");
        creatureImage=new ImageView(new Image("file:Images/PeaUse.png"));
        creatureImage.setFitHeight(30);
        creatureImage.setFitWidth(30);
        creatureImage.setX(100);
        creatureImage.setY(100);

        currentPane.getChildren().add(creatureImage);
        creatureImage.setVisible(false);
    }
    void moveRight(){
    	creatureImage.setVisible(true);
        TranslateTransition animation = new TranslateTransition(
                Duration.seconds(1.5), creatureImage
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.setFromX(creatureImage.getTranslateX());
        animation.setToX(creatureImage.getTranslateX()+750);
        animation.setAutoReverse(false);
        animation.play();
    }
}
