import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public TextField id;
    public DatePicker date;
    public TextField name;
    public ComboBox sex;

    public void exit(ActionEvent actionEvent) {

        System.exit(0);
    }

    public void clear(ActionEvent actionEvent) {



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sex.getItems().addAll("Male", "Female");
    }
}
