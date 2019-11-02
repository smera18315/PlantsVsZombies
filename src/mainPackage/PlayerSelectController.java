package mainPackage;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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

}
