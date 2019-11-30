package mainPackage;

import java.util.ArrayList;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

class Character extends ImageView {
    boolean isAlive=true;
    String type;
    
    Character(int x, int y, String type){
        super();
        isAlive=true;
        setTranslateX(x);
        setTranslateY(y);
        this.type=type;
    }
}

public class MiniGameController extends Application {
	Pane mainPane=new Pane();
	double time=0;
	MainPlant hero=new MainPlant(800,100);
	
	void makeZombies() {
        for (int i = 0; i < 5; i++) {
            ZombiePlant z = new ZombiePlant(400,i*100);
            mainPane.getChildren().add(z);
            mainPane.getChildren().get(i).setVisible(true);
        }
	}
	
    private void attack(Character cr) {
    	if (cr.type.equals("zombiePlant")) {
    		ZombiePlant zp=(ZombiePlant)cr;
    		ZombiePlantBullet zpm=new ZombiePlantBullet(zp);
    		zpm.setVisible(true);
    		mainPane.getChildren().add(zpm);
    		}
    	else if (cr.type.equals("mainPlant")) {
    		MainPlant zp=(MainPlant)cr;
    		MainPlantBullet zpm=new MainPlantBullet(zp);
    		zpm.setVisible(true);
    		mainPane.getChildren().add(zpm);
    	}
    }
	
    void update() {
    	Random r=new Random();
        time += 0.020;
        ArrayList<Character> crList=new ArrayList<Character>(mainPane.getChildren().size());
        for (int i=0;i<crList.size();i++) {
        	if (crList.get(i)!=null) {
        		if (crList.get(i).isAlive) {
        			crList.get(i).setVisible(true);
        		}
        	}
        }
        for (Node currentNode : mainPane.getChildren()){
            if (currentNode instanceof Character){
                crList.add((Character)currentNode);
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
                    		if (mpb.getBoundsInParent().intersects(zp.getBoundsInParent())) {
                    			zp.isAlive=false;
                    			zp.setVisible(false);
                    			s.isAlive=false;
                    			s.setVisible(false);
                    		}
                    	}
                    }
                    break;
                    
                case "zombiePlantBullet":
                	ZombiePlantBullet zpb=(ZombiePlantBullet)s;
                    zpb.moveLeft();
                    if (zpb.getBoundsInParent().intersects(hero.getBoundsInParent())) {
                        hero.isAlive = false;
                        hero.setVisible(false);
                        s.isAlive = false;
                        s.setVisible(false);
                    }
                    break;
            }
        });
    }
    
	Parent makeGame(){
		mainPane.getChildren().add(hero);
		mainPane.getChildren().get(0).setVisible(true);
        mainPane.setPrefSize(1000, 1000);
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
	
class MainPlant extends Character{

	MainPlant(int x, int y) {
		super(x, y, "mainPlant");
		setImage(new Image("file:Images/HeroPlant.png"));
        setFitHeight(150);
        setFitWidth(190);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}
	
    void moveUp() {
        setTranslateY(getTranslateY() - 5);
    }

    void moveDown() {
        setTranslateY(getTranslateY() + 5);
    }
	
	
}

class MainPlantBullet extends Character{

	MainPlantBullet(MainPlant p) {
		super((int)p.getTranslateX(), (int)p.getTranslateY(), "mainPlantBullet");
		setImage(new Image("file:Images/PeaUse.png"));
		setFitHeight(10);
		setFitWidth(10);
		setVisible(true);
		moveRight();
		
		// TODO Auto-generated constructor stub
	}

    void moveRight() {
        setTranslateX(getTranslateX() + 5);
    }
}

class ZombiePlantBullet extends Character{

	ZombiePlantBullet(ZombiePlant p) {
		super((int)p.getTranslateX(), (int)p.getTranslateY(), "zombiePlantBullet");
		setImage(new Image("file:Images/PeaUse.png"));
		setFitHeight(10);
		setFitWidth(10);
		setVisible(true);
		moveLeft();
		// TODO Auto-generated constructor stub
	}

    void moveLeft() {
        setTranslateX(getTranslateX() - 5);
    }
}

class ZombiePlant extends Character{

	ZombiePlant(int x, int y) {
		super(x, y, "zombiePlant");
		setImage(new Image("file:Images/zPlant.png"));
        setFitHeight(150);
        setFitWidth(190);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}	
}
// Credits to Almas Baimagambetov