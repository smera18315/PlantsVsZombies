package mainPackage;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class InGameMenuController {
	
	@FXML
    public void mouseEnterSaveGame(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/SaveGame.png"));

    }
	
	@FXML
    public void mouseExitSaveGame(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/SaveGameDark.png"));

    }
	
	@FXML
    public void mouseEnterExitGame(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/ExitGame2.png"));

    }
	
	@FXML
    public void mouseExitExitGame(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/ExitGameDark.png"));

    }
	
	@FXML
	public void ExitMenu(MouseEvent e) throws IOException {
		Parent root= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
		Stage stage = (Stage) ((Node)e.getTarget()).getScene().getWindow();
		stage.setScene(new Scene(root));

	    }
	
	@FXML
    public void mouseResumeEnterGame(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/ResumeButtonBright.png"));

    }
	
	@FXML
    public void mouseResumeExitGame(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/ResumeButton.png"));

    }

}
