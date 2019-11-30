package mainPackage;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MiniGameController extends Application {
	Pane mainPane=new Pane();
	double time=0;
	MainPlant hero=new MainPlant(300,300);
	
	void makeZombies() {
        for (int i = 0; i < 5; i++) {
            ZombiePlant z = new ZombiePlant(1000,i*100);
            mainPane.getChildren().add(z.creatureImage);
        }
	}
	
    private void attack(Creature cr) {
    	if (cr.type.equals("zombiePlant")) {
    		ZombiePlant zp=(ZombiePlant)cr;
    		ZombiePlantBullet zpm=new ZombiePlantBullet(zp);
    		mainPane.getChildren().add(zpm);
    	}
    	else if (cr.type.equals("mainPlant")) {
    		MainPlant zp=(MainPlant)cr;
    		MainPlantBullet zpm=new MainPlantBullet(zp);
    		mainPane.getChildren().add(zpm);
    	}
    }
	
    void update() {
    	Random r=new Random();
        time += 0.020;
        ArrayList<Creature> crList=new ArrayList<Creature>(mainPane.getChildren().size());
        for (Node currentNode : mainPane.getChildren()){
            if (currentNode instanceof Creature){
                crList.add((Creature)currentNode);
            }
        }        
        crList.forEach(s -> {
            switch (s.type) {
                    
                case "zombiePlant":
                    if (time > 2) {
                        if (r.nextInt(10)>4) {
                            attack((ZombiePlant)s);
                        }
                    }

                    break;

                case "mainPlantBullet":
                	MainPlantBullet mpb=(MainPlantBullet)s;
                    mpb.moveRight();
                    for (int i=0;i<crList.size();i++) {
                    	if (crList.get(i).type.equals("zombiePlant")) {
                    		ZombiePlant zp=(ZombiePlant)crList.get(i);
                    		if (mpb.creatureImage.getBoundsInParent().intersects(zp.creatureImage.getBoundsInParent())) {
                    			zp.isAlive=false;
                    			s.isAlive=false;
                    		}
                    	}
                    }
                    break;
                    
                case "zombiePlantBullet":
                	ZombiePlantBullet zpb=(ZombiePlantBullet)s;
                    zpb.moveLeft();
                    if (zpb.creatureImage.getBoundsInParent().intersects(hero.creatureImage.getBoundsInParent())) {
                        hero.isAlive = false;
                        s.isAlive = false;
                    }
                    break;
            }
        });
    }
    
	Parent makeGame(){
		mainPane.getChildren().add(hero);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        timer.start();
        makeZombies();
        return mainPane;
	}

	@Override
	public void start(Stage stage) throws Exception {
        Scene scene = new Scene(makeGame());

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case W:
                    hero.moveUp();
                    break;
                case S:
                    hero.moveDown();
                    break;
                case SPACE:
                    attack(hero);
                    break;
            }
        });
        stage.setScene(scene);
        stage.show();
    }
	
	public static void main(String[] args) {
		launch(args);
	}
				
}
	
class MainPlant extends Creature{

	MainPlant(int x, int y) {
		super(x, y, "mainPlant");
		super.creatureImage=new ImageView(new Image("file:Images/HeroPlant.png"));
		// TODO Auto-generated constructor stub
	}
	
    void moveUp() {
        creatureImage.setTranslateY(creatureImage.getTranslateY() - 5);
    }

    void moveDown() {
        creatureImage.setTranslateY(creatureImage.getTranslateY() + 5);
    }
	
	
}

class MainPlantBullet extends Creature{

	MainPlantBullet(MainPlant p) {
		super((int)p.creatureImage.getTranslateX(), (int)p.creatureImage.getTranslateY(), "mainPlantBullet");
		super.creatureImage=new ImageView(new Image("file:Images/HeroPlant.png"));
		// TODO Auto-generated constructor stub
	}

    void moveRight() {
        creatureImage.setTranslateY(creatureImage.getTranslateX() + 5);
    }
}

class ZombiePlantBullet extends Creature{

	ZombiePlantBullet(ZombiePlant p) {
		super((int)p.creatureImage.getTranslateX(), (int)p.creatureImage.getTranslateY(), "zombiePlantBullet");
		super.creatureImage=new ImageView(new Image("file:Images/HeroPlant.png"));
		// TODO Auto-generated constructor stub
	}

    void moveLeft() {
        creatureImage.setTranslateY(creatureImage.getTranslateX() - 5);
    }
}

class ZombiePlant extends Creature{

	ZombiePlant(int x, int y) {
		super(x, y, "zombiePlant");
		super.creatureImage=new ImageView(new Image("file:Images/zPlant.png"));
		// TODO Auto-generated constructor stub
	}	
}
// Credits to Almas Baimagambetov