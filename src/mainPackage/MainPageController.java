package mainPackage;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.*;

public class MainPageController {
	@FXML
    public void hover(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/StartGameGlow.png"));

    }
}
