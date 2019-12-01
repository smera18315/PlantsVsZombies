package mainPackage;


import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Creature{
    boolean isAlive=true;
    String type;
    public ImageView creatureImage;

    Creature(int x, int y, String type){
        super();
        isAlive=true;
        creatureImage=new ImageView();
        creatureImage.setTranslateX(x);
        creatureImage.setTranslateY(y);
        this.type=type;
    }
    
    Creature(){
        super();
        isAlive=true;
        creatureImage=new ImageView();
        this.type=null;
    }

}

