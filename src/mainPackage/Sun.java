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
        super(100, 100, "Sun"); // Random Values as of now, we'll have to check what the top of the pain is
        Random r=new Random();
        int xCoo=r.nextInt(1200);
        creatureImage.setTranslateX(xCoo);
        creatureImage=new ImageView(new Image("file:Images/PeaUse.png"));
        creatureImage.setFitHeight(30);
        creatureImage.setFitWidth(30);
        currentPane.getChildren().add(creatureImage);

//        ((GridPane) currentPane).setColumnIndex(creatureImage,plant.y);
//        ((GridPane) currentPane).setRowIndex(creatureImage,plant.x);
//
//        //System.out.println(creatureImage.getParent());

        creatureImage.setVisible(false);
    }
    void moveDown(){
        creatureImage.setVisible(true);
        TranslateTransition animation = new TranslateTransition(
                Duration.seconds(2.5), creatureImage
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.setFromY(creatureImage.getTranslateY()+50);
        animation.setToY(creatureImage.getTranslateY()+750);
        animation.setAutoReverse(false);
        animation.play();
    }
}
