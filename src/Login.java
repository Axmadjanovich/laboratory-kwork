import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

    public TextField username;
    public AnchorPane top;

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void next(MouseEvent actionEvent) {

        Mise.stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        Mise.stage.setFullScreen(true);
        Mise.set_pane(1);
    }



    public void registration(MouseEvent mouseEvent) {
        Mise.root.setPrefWidth(Mise.grid.get(2).getPrefWidth());
        Mise.root.setPrefHeight(Mise.grid.get(2).getPrefHeight());
        Mise.stage.setHeight(Mise.grid.get(2).getPrefHeight());
        Mise.stage.setWidth(Mise.grid.get(2).getPrefWidth());
        Mise.set_pane(2);
    }

    public void register(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        double [] xOffset = {0}, yOffset = {0};
        top.setOnMousePressed(pressEvent -> {
            xOffset[0] = Mise.stage.getX() - pressEvent.getScreenX();
            yOffset[0] = Mise.stage.getY() - pressEvent.getScreenY();
        });
        top.setOnMouseDragged(dragEvent -> {
            Mise.stage.setX(dragEvent.getScreenX()+xOffset[0]);
            Mise.stage.setY(dragEvent.getScreenY()+yOffset[0]);
        });
    }
}
