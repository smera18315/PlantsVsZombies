package mainPackage;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.*;

public class MainPageController {
	@FXML
    public void mouseEnterStartGame(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/StartGameGlow.png"));

    }
	
	@FXML
    public void mouseExitStartGame(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/StartGame.png"));

    }
	
	@FXML
    public void mouseEnterLoadGame(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/LoadGameGlow.png"));

    }
	
	@FXML
    public void mouseExitLoadGame(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/LoadGame.png"));

    }
	
	@FXML
    public void mouseEnterExitGame(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/ExitGameGlow.png"));

    }
	
	@FXML
    public void mouseExitExitGame(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/ExitGame.png"));

    }
	
	@FXML
    public void mouseEnterChooseLevel(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/ChooseLevelGlow.png"));

    }
	
	@FXML
    public void mouseExitChooseLevel(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/ChooseLevel.png"));

    }
	
	@FXML
    public void startGame(MouseEvent e) throws IOException {
		Parent root= FXMLLoader.load(getClass().getResource("PlayerSelect.fxml"));
		Stage stage = (Stage) ((Node)e.getTarget()).getScene().getWindow();
		stage.setScene(new Scene(root));

    }
}

