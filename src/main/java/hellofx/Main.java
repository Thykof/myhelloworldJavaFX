package hellofx;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

import com.google.gson.Gson;

public class Main extends Application {

    public static final String fileOfPath = System.getProperty("user.home")+"/.myhellofx-path.json";

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = getClass().getResource("/hellofx/sample.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        GridPane root = (GridPane) fxmlLoader.load();
        Controller controller = (Controller) fxmlLoader.getController();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {


        try {
            Gson gson = new Gson();
            Writer osWriter = new OutputStreamWriter(new FileOutputStream(fileOfPath));
            List list = new ArrayList<String>();
            list.add("path");
            gson.toJson(list, osWriter);
            osWriter.close();
        }
        catch (IOException e) {

        }
        launch(args);
    }
}
