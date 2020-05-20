import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import scala.Char;
import scala.util.parsing.combinator.testing.Str;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Registration implements Initializable {

    public AnchorPane top;
    public CheckBox minimum;
    public CheckBox contains;
    public CheckBox match;
    public PasswordField repassword;
    public TextField Firstname;
    public TextField workplace;
    public TextField position;
    public PasswordField password;
    public TextField email;
    public TextField Lastname;
    public ImageView hide;
    private Image [] rasmlar;

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
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
//        File rasm = new File("../image/icons8-hide-48.png");
//        rasmlar = new Image[]{new Image(getClass().getResourceAsStream("../image/icons8-hide-48.png"))};

    }

    public void sign(MouseEvent mouseEvent) {

        Mise.root.setPrefWidth(Mise.grid.get(0).getPrefWidth());
        Mise.root.setPrefHeight(Mise.grid.get(0).getPrefHeight());
        Mise.stage.setHeight(Mise.grid.get(0).getPrefHeight());
        Mise.stage.setWidth(Mise.grid.get(0).getPrefWidth());
        Mise.set_pane(0);
    }

    public void new_password(KeyEvent keyEvent) {
        if (password.getText().length()>=8) minimum.setSelected(true);
        else minimum.setSelected(false);
        if (check(password.getText())) contains.setSelected(true);
        else contains.setSelected(false);
        if (password.getText().equals(repassword.getText())) match.setSelected(true);
        else match.setSelected(false);
    }

    public void confirm_password(KeyEvent keyEvent) {
        if (password.getText().equals(repassword.getText())) match.setSelected(true);
        else match.setSelected(false);
    }
    boolean check(String s) {
        if (s == null) // checks if the String is null
            return false;
    int len = s.length();
    boolean letter = false, number = false;
      for (int i = 0; i < len; i++) {
        // checks whether the character is neither a letter nor a digit
        // if it is neither a letter nor a digit then it will return false
        if (Character.isLetter(s.charAt(i))) {
            letter = true;
        }
        if (Character.isDigit(s.charAt(i)))  number = true;
    }
      return letter && number;
}

    private int pressed = 0;
    public void hide(MouseEvent mouseEvent) {
        pressed++;
        String [] url = {"../image/icons8-hide-48.png","../image/icons8-eye-48.png"};
        hide.setImage(rasmlar[pressed%2]);
    }
}
