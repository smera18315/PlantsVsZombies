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

public class PlayerSelectController {
	
	@FXML
    public void mouseEnterExistingPlayer(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/ExistingPlayer.png"));

    }
	
	@FXML
    public void mouseExitExistingPlayer(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/ExistingPlayerDark.png"));

    }
	
	@FXML
    public void mouseEnterNewPlayer(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/NewPlayer.png"));

    }
	
	@FXML
    public void mouseExitNewPlayer(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/NewPlayerDark.png"));

    }
	
	@FXML
    public void existingPlayer(MouseEvent e) throws IOException {
		Parent root= FXMLLoader.load(getClass().getResource("ChooseLevel.fxml"));
		Stage stage = (Stage) ((Node)e.getTarget()).getScene().getWindow();
		stage.setScene(new Scene(root));

    }

}
