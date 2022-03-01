package covid_resource;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Login_Controller
{
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label login_status;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void loginOnAction(ActionEvent e) throws IOException
    {
        if (!username.getText().isBlank() && !password.getText().isBlank())
        {
            try
            {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid_resources", "root", "Faze1$");
                Statement stmt1 = connection.createStatement();
                String q1 = "SELECT * from members";
                ResultSet set = stmt1.executeQuery(q1);

                while(set.next())
                {
                    if (username.getText().equals(set.getString("username")))
                    {
                        if(password.getText().equals(set.getString("password")))
                        {
                            /*Main m = new Main();
                            m.changeScene2("fxml/dashboard.fxml");*/
                            //root=FXMLLoader.load(getClass().getResource("fxml/dashboard.fxml"));
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/dashboard.fxml"));
                            root = loader.load();
                            Dashboard_Controller d = loader.getController();
                            d.get_username1(set.getString("username"));
                            d.set_name(set.getString("username"));
                            stage=(Stage)((Node)e.getSource()).getScene().getWindow();
                            scene=new Scene(root);
                            stage.setScene(scene);
                            stage.centerOnScreen();
                            stage.show();
                        }
                        else
                        {
                            login_status.setTextFill(Color.RED);
                            login_status.setText("Incorrect password.");
                        }
                    }
                    else
                    {
                        login_status.setTextFill(Color.RED);
                        login_status.setText("Incorrect username.");
                    }
                }

                connection.close();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else if(username.getText().isBlank() && !password.getText().isBlank())
        {
            login_status.setTextFill(Color.RED);
            login_status.setText("Please enter username.");
        }
        else if(password.getText().isBlank() && !username.getText().isBlank())
        {
            login_status.setTextFill(Color.RED);
            login_status.setText("Please enter password.");
        }
        else
        {
            login_status.setTextFill(Color.RED);
            login_status.setText("Please enter username & password.");
        }
    }

    public void signupOnAction(ActionEvent e) throws IOException
    {
        Main m = new Main();
        m.changeScene1("fxml/signup_page.fxml");
        /*root=FXMLLoader.load(getClass().getResource("fxml/signup_page.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();*/
    }
}