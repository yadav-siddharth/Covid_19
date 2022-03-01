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
import java.io.IOException;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup_Controller
{
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private TextField f_name, m_name, l_name;
    @FXML
    private ToggleGroup gender;
    @FXML
    private TextField email;
    @FXML
    private TextField c_num;
    @FXML
    private Label signup_status;
    @FXML
    private Label username_status;
    @FXML
    private Label pass_status;
    @FXML
    private Label name_status;
    @FXML
    private Label email_status;
    @FXML
    private Label num_status;
    @FXML
    private ToggleGroup member;
    @FXML
    private ToggleGroup num_doses;
    @FXML
    private ChoiceBox branch;


    @FXML
    public void initialize()
    {
        branch.getItems().removeAll(branch.getItems());
        branch.getItems().addAll("N/A", "Computer Engineering","I.T","A.I.D.S","EXTC","Chemical Engineering");
        branch.getSelectionModel().select("N/A");
    }

    public void goTologinOnAction(ActionEvent e) throws IOException
    {
        Main m = new Main();
        m.changeScene1("fxml/login_page.fxml");
        /*root=FXMLLoader.load(getClass().getResource("fxml/login_page.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        ^(?=.{3,10}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$*/
    }

    public void registerOnAction(ActionEvent e) throws IOException
    {
        int flag=0;
        signup_status.setText("");

        if(!username.getText().isBlank() && !password.getText().isBlank() && !f_name.getText().isBlank() && !m_name.getText().isBlank() && !l_name.getText().isBlank() && !email.getText().isBlank() && !c_num.getText().isBlank() && gender.getSelectedToggle()!=null && member.getSelectedToggle()!=null && num_doses.getSelectedToggle()!=null)
        {
            if(!username.getText().isBlank())
            {
                String regex = "[A-Za-z0-9_]+";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(username.getText());
                boolean b = m.matches();

                if(!b)
                {
                    username_status.setTextFill(Color.RED);
                    username_status.setText("Please enter a valid username.");
                }
                else if(b)
                {
                    username_status.setText("");
                    flag=flag+1;
                }
            }

            if(!password.getText().isBlank())
            {
                String regex = "[a-zA-Z0-9$&*#@]+";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(password.getText());
                boolean b = m.matches();

                if(!b)
                {
                    pass_status.setTextFill(Color.RED);
                    pass_status.setText("Please enter a valid password.");
                }
                else if(b)
                {
                    pass_status.setText("");
                    flag=flag+1;
                }
            }

            if(!f_name.getText().isBlank()&&!m_name.getText().isBlank()&&!l_name.getText().isBlank())
            {
                String regex = "[a-zA-Z]+";
                Pattern p = Pattern.compile(regex);
                Matcher m1 = p.matcher(f_name.getText());
                Matcher m2 = p.matcher(m_name.getText());
                Matcher m3 = p.matcher(l_name.getText());
                boolean b1 = m1.matches();
                boolean b2 = m2.matches();
                boolean b3 = m3.matches();

                if(!b1)
                {
                    name_status.setTextFill(Color.RED);
                    name_status.setText("Please enter a valid name.");
                }
                else if(!b2)
                {
                    name_status.setTextFill(Color.RED);
                    name_status.setText("Please enter a valid name.");
                }
                else if(!b3)
                {
                    name_status.setTextFill(Color.RED);
                    name_status.setText("Please enter a valid name.");
                }
                else
                {
                    name_status.setText("");
                    flag=flag+1;
                }
            }

            if(!email.getText().isBlank())
            {
                String regex = "^[a-zA-Z0-9+._]+@[a-zA-Z]+[.][a-zA-Z]+$";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(email.getText());
                boolean b = m.matches();

                if(!b)
                {
                    email_status.setTextFill(Color.RED);
                    email_status.setText("Please enter a valid email.");
                }
                else if(b)
                {
                    email_status.setText("");
                    flag=flag+1;
                }
            }

            if(!c_num.getText().isBlank())
            {
                String regex = "^[6-9][0-9]{9}$";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(c_num.getText());
                boolean b = m.matches();

                if(!b)
                {
                    num_status.setTextFill(Color.RED);
                    num_status.setText("Please enter a valid number.");
                }
                else if(b)
                {
                    num_status.setText("");
                    flag=flag+1;
                }
            }
        }
        else
        {
            flag=0;
            signup_status.setTextFill(Color.RED);
            signup_status.setText("Please fill up all details.");
        }

        if(flag==5)
        {
            RadioButton user_gender = (RadioButton) gender.getSelectedToggle();
            RadioButton member_type = (RadioButton) member.getSelectedToggle();
            RadioButton no_of_doses = (RadioButton) num_doses.getSelectedToggle();
            String brch = (String) branch.getSelectionModel().getSelectedItem();

            try
            {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid_resources", "root", "Faze1$");

                Statement stmt1 = connection.createStatement();
                String q1 = "SELECT * FROM members";
                ResultSet set1 = stmt1.executeQuery(q1);

                int flag2=0;

                while(set1.next())
                {
                    if (username.getText().equals(set1.getString("username"))) {
                        username_status.setTextFill(Color.RED);
                        username_status.setText("Username already exists.");
                        flag2=1;
                    }
                }

                if(flag2==0)
                {
                    String q2 = "INSERT INTO members(username,password,first_name,middle_name,last_name,gender,email_id,phone_no,member_type,no_of_doses,branch) values (?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement stmt2 = connection.prepareStatement(q2);

                    stmt2.setString(1, username.getText());
                    stmt2.setString(2, password.getText());
                    stmt2.setString(3, f_name.getText());
                    stmt2.setString(4, m_name.getText());
                    stmt2.setString(5, l_name.getText());
                    stmt2.setString(6, user_gender.getText());
                    stmt2.setString(7, email.getText());
                    stmt2.setString(8, c_num.getText());
                    stmt2.setString(9, member_type.getText());
                    stmt2.setString(10, no_of_doses.getText());
                    stmt2.setString(11, brch);

                    stmt2.executeUpdate();

                    signup_status.setTextFill(Color.GREEN);
                    signup_status.setText("You have successfully registered.");
                }

                connection.close();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
}



