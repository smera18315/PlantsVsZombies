package mainPackage;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ChooseLevelController {
    @FXML
    public void mouseEnterLev1(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/Level1.png"));

    }

    @FXML
    public void mouseExitStartLev1(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/Level1High.png"));

    }

    @FXML
    public void mouseEnterLev2(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/Level2.png"));

    }

    @FXML
    public void mouseExitStartLev2(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/Level2High.png"));

    }

    @FXML
    public void mouseEnterLev3(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/Level3.png"));

    }

    @FXML
    public void mouseExitStartLev3(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/Level3High.png"));

    }

    @FXML
    public void mouseEnterLev4(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/Level4.png"));

    }

    @FXML
    public void mouseExitStartLev4(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/Level4High.png"));

    }

    @FXML
    public void mouseEnterLev5(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/Level5.png"));

    }

    @FXML
    public void mouseExitStartLev5(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/Level5High.png"));

    }

    @FXML
    public void mouseEnterLev6(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/Level6.png"));

    }

    @FXML
    public void mouseExitStartLev6(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/Level6High.png"));

    }

    @FXML
    public void mouseEnterLev7(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/Level7.png"));

    }

    @FXML
    public void mouseExitStartLev7(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/Level7High.png"));

    }

    @FXML
    public void mouseEnterLev8(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/Level8.png"));

    }

    @FXML
    public void mouseExitStartLev8(MouseEvent e){
        ImageView m = (ImageView) e.getSource();
        m.setImage(new Image("file:Images/Level8High.png"));

    }
}
