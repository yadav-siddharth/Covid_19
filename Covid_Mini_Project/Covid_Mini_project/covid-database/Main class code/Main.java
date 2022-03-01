package covid_resource;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application
{
    private Stage stage;
    private Scene scene;
    private Parent root;


    private static Stage stg;

    @Override
    public void start(Stage primarystage) throws IOException
    {
        stg = primarystage;

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/login_page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1065, 536);
        primarystage.setTitle("Covid Resources");
        primarystage.setScene(scene);
        primarystage.setResizable(false);
        primarystage.centerOnScreen();
        primarystage.show();
    }

    public void changeScene1(String fxml) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(root);
    }

    public void changeScene2(String fxml) throws IOException
    {
        root=FXMLLoader.load(getClass().getResource(fxml));
        stage=(Stage) stg.getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}