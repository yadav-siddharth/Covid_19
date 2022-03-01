package covid_resource;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Dashboard_Controller
{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label welcomeText;
    @FXML
    private BarChart barChart;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;

    @FXML
    private Label pass_name;
    @FXML
    private Label pass_gender;
    @FXML
    private Label pass_email;
    @FXML
    private Label pass_num;
    @FXML
    private Label pass_member;
    @FXML
    private Label pass_branch;
    @FXML
    private Label pass_vacc;
    @FXML
    private Label pass_doses;

    @FXML
    private Label user;

    private String temp_username;

    public void logoutOnAction(ActionEvent e) throws IOException
    {
        Main m = new Main();
        m.changeScene2("fxml/login_page.fxml");
        /*root=FXMLLoader.load(getClass().getResource("fxml/login_page.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();*/
    }

    public void accountOnAction(ActionEvent e) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/account_details.fxml"));
        root = loader.load();
        Details_Controller de = loader.getController();
        de.get_account_details(temp_username);
        stage=new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner((Stage)((Node)e.getSource()).getScene().getWindow());
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Covid Resources");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();

    }

    public void vacc_slotOnAction(ActionEvent e) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/vaccination_slot.fxml"));
        root = loader.load();
        Dashboard_Controller d = loader.getController();
        d.get_username1(temp_username);
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        /*Main m = new Main();
        m.changeScene1("fxml/vaccination_slot.fxml");
        root=FXMLLoader.load(getClass().getResource("fxml/vaccination_slot.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();*/
    }

    @FXML
    public void opencowinlink(ActionEvent e) throws URISyntaxException,IOException
    {
        Desktop.getDesktop().browse(new URI("https://www.cowin.gov.in/"));
    }

    @FXML
    public void opentseclink(ActionEvent e) throws URISyntaxException,IOException
    {
        Desktop.getDesktop().browse(new URI("https://tsec.edu/"));
    }

    public void dashboardOnAction(ActionEvent e) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/dashboard.fxml"));
        root = loader.load();
        Dashboard_Controller d = loader.getController();
        d.get_username1(temp_username);
        d.set_name(temp_username);
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        /*Main m = new Main();
        m.changeScene1("fxml/dashboard.fxml");*/
        /*root=FXMLLoader.load(getClass().getResource("fxml/dashboard.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();*/
    }

    public void helplineOnAction(ActionEvent e) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/helpline.fxml"));
        root = loader.load();
        Dashboard_Controller d = loader.getController();
        d.get_username1(temp_username);
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        /*Main m = new Main();
        m.changeScene1("fxml/helpline.fxml");*/
        /*root=FXMLLoader.load(getClass().getResource("fxml/helpline.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();*/
    }

    public void articlesOnAction(ActionEvent e) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/articles.fxml"));
        root = loader.load();
        Dashboard_Controller d = loader.getController();
        d.get_username1(temp_username);
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        /*Main m = new Main();
        m.changeScene1("fxml/articles.fxml");
        root=FXMLLoader.load(getClass().getResource("fxml/articles.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();*/
    }

    public void graphOnAction(ActionEvent e) throws IOException
    {
        root=FXMLLoader.load(getClass().getResource("fxml/graph.fxml"));
        stage=new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner((Stage)((Node)e.getSource()).getScene().getWindow());
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Covid Resources");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }

    public void about_usOnAction(ActionEvent e) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/about_us.fxml"));
        root = loader.load();
        Dashboard_Controller d = loader.getController();
        d.get_username1(temp_username);
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        /*Main m = new Main();
        m.changeScene1("fxml/about_us.fxml");
        root=FXMLLoader.load(getClass().getResource("fxml/articles.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();*/
    }

    public void ask_doubtOnAction(ActionEvent e) throws IOException
    {
        root=FXMLLoader.load(getClass().getResource("fxml/ask_doubt.fxml"));
        stage=new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner((Stage)((Node)e.getSource()).getScene().getWindow());
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Covid Resources");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }

    public void vacc_passOnAction(ActionEvent e) throws IOException
    {
        //System.out.println(temp_username);
        //root=FXMLLoader.load(getClass().getResource("fxml/vaccination_pass.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/vaccination_pass.fxml"));
        root = loader.load();
        Pass_Controller p = loader.getController();
        p.get_details(temp_username);
        stage=new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner((Stage)((Node)e.getSource()).getScene().getWindow());
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Covid Resources");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }

    public void get_username1(String username)
    {
        temp_username=username;
    }

    public void set_name(String username)
    {
        user.setText(temp_username);
    }
}
