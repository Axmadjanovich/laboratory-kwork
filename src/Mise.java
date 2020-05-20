import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.List;

public class Mise extends Application {
    public static Stage stage;
    public static AnchorPane root;
    static List<AnchorPane> grid = new ArrayList<>();
    public static int idx_cur = 0;
    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.initStyle(StageStyle.UNDECORATED);
//        primaryStage.setScene(new Scene(root));
//        primaryStage.setFullScreen(true);
//        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
//        primaryStage.show();

        primaryStage.setResizable(true);
        root = FXMLLoader.load(getClass().getResource("fxml/samp1e.fxml"));
        grid.add(FXMLLoader.load(getClass().getResource("fxml/login.fxml")));
        grid.add(FXMLLoader.load(getClass().getResource("fxml/sample.fxml")));
        grid.add(FXMLLoader.load(getClass().getResource("fxml/registration.fxml")));

        root.getChildren().add(grid.get(0));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.centerOnScreen();
        stage=primaryStage;
        stage.show();
    }
    public static void set_pane(int idx){

        root.getChildren().remove(grid.get(idx_cur));
        root.getChildren().add(grid.get(idx));
        idx_cur=idx;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
