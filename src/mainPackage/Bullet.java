package mainPackage;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Bullet extends Creature {


    Bullet(Plant plant) {
        super(plant.plantCoordinates.getKey(), plant.plantCoordinates.getValue(), "Bullet");
        creatureImage=new ImageView(new Image("file:Images/PeaUse.png"));
        creatureImage.setVisible(true);
    }
    void moveRight(){
        TranslateTransition animation = new TranslateTransition(
                Duration.seconds(0.7), creatureImage
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.setFromX(creatureImage.getTranslateX());
        animation.setToX(creatureImage.getTranslateX()+1000);
        animation.setAutoReverse(false);
        animation.play();
    }
}
