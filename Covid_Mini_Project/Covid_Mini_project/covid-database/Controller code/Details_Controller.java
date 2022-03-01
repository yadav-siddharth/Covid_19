package covid_resource;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Details_Controller
{
    @FXML
    private Label acc_username;
    @FXML
    private TextField acc_password;
    @FXML
    private TextField acc_fname, acc_mname, acc_lname;
    @FXML
    private ToggleGroup acc_gender;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
    @FXML
    private RadioButton other;
    @FXML
    private TextField acc_email;
    @FXML
    private TextField acc_num;
    @FXML
    private Label acc_status;
    @FXML
    private Label pass_status;
    @FXML
    private Label name_status;
    @FXML
    private Label email_status;
    @FXML
    private Label num_status;
    @FXML
    private ToggleGroup acc_member;
    @FXML
    private RadioButton student;
    @FXML
    private RadioButton staff;
    @FXML
    private ToggleGroup acc_doses;
    @FXML
    private RadioButton zero;
    @FXML
    private RadioButton one;
    @FXML
    private RadioButton two;
    @FXML
    private ChoiceBox acc_branch;

    @FXML
    public void initialize()
    {
        acc_branch.getItems().removeAll(acc_branch.getItems());
        acc_branch.getItems().addAll("N/A", "Computer Engineering","I.T","A.I.D.S","EXTC","Chemical Engineering");
        //acc_branch.getSelectionModel().select("N/A");
    }

    public void get_account_details(String username)
    {
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid_resources", "root", "Faze1$");
            Statement stmt1 = connection.createStatement();
            String q1 = "SELECT * from members";
            ResultSet set = stmt1.executeQuery(q1);

            while(set.next())
            {
                if(username.equals(set.getString("username")))
                {
                    acc_username.setText(set.getString("username"));
                    acc_password.setText(set.getString("password"));

                    acc_fname.setText(set.getString("first_name"));
                    acc_mname.setText(set.getString("middle_name"));
                    acc_lname.setText(set.getString("last_name"));

                    if(male.getText().equals(set.getString("gender")))
                    {
                        acc_gender.selectToggle(male);
                    }
                    else if(female.getText().equals(set.getString("gender")))
                    {
                        acc_gender.selectToggle(female);
                    }
                    else if(other.getText().equals(set.getString("gender")))
                    {
                        acc_gender.selectToggle(other);
                    }

                    acc_email.setText(set.getString("email_id"));

                    acc_num.setText(set.getString("phone_no"));

                    if(student.getText().equals(set.getString("member_type")))
                    {
                        acc_member.selectToggle(student);
                    }
                    else if(staff.getText().equals(set.getString("member_type")))
                    {
                        acc_member.selectToggle(staff);
                    }

                    acc_branch.getSelectionModel().select(set.getString("branch"));

                    if(zero.getText().equals(set.getString("no_of_doses")))
                    {
                        acc_doses.selectToggle(zero);
                    }
                    else if(one.getText().equals(set.getString("no_of_doses")))
                    {
                        acc_doses.selectToggle(one);
                    }
                    else if(two.getText().equals(set.getString("no_of_doses")))
                    {
                        acc_doses.selectToggle(two);
                    }

                }
            }

            connection.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void change_details(ActionEvent e) throws IOException
    {
        int flag=0;
        acc_status.setText("");

        if(!acc_password.getText().isBlank() && !acc_fname.getText().isBlank() && !acc_mname.getText().isBlank() && !acc_lname.getText().isBlank() && !acc_email.getText().isBlank() && !acc_num.getText().isBlank() && acc_gender.getSelectedToggle()!=null && acc_member.getSelectedToggle()!=null && acc_doses.getSelectedToggle()!=null)
        {
            if(!acc_password.getText().isBlank())
            {
                String regex = "[a-zA-Z0-9$&*#@]+";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(acc_password.getText());
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

            if(!acc_fname.getText().isBlank()&&!acc_mname.getText().isBlank()&&!acc_lname.getText().isBlank())
            {
                String regex = "[a-zA-Z]+";
                Pattern p = Pattern.compile(regex);
                Matcher m1 = p.matcher(acc_fname.getText());
                Matcher m2 = p.matcher(acc_mname.getText());
                Matcher m3 = p.matcher(acc_lname.getText());
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

            if(!acc_email.getText().isBlank())
            {
                String regex = "^[a-zA-Z0-9+._]+@[a-zA-Z]+[.][a-zA-Z]+$";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(acc_email.getText());
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

            if(!acc_num.getText().isBlank())
            {
                String regex = "^[6-9][0-9]{9}$";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(acc_num.getText());
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
            acc_status.setTextFill(Color.RED);
            acc_status.setText("Please fill up all details.");
        }

        if(flag==4)
        {
            RadioButton user_gender = (RadioButton) acc_gender.getSelectedToggle();
            RadioButton member_type = (RadioButton) acc_member.getSelectedToggle();
            RadioButton no_of_doses = (RadioButton) acc_doses.getSelectedToggle();
            String brch = (String) acc_branch.getSelectionModel().getSelectedItem();

            try
            {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid_resources", "root", "Faze1$");

                String q = "UPDATE members SET password = ?, first_name = ?, middle_name = ?, last_name = ?, gender = ?, email_id = ?, phone_no = ?, member_type = ?, no_of_doses = ?, branch = ? WHERE username = ?";
                PreparedStatement stmt2 = connection.prepareStatement(q);

                stmt2.setString(1, acc_password.getText());
                stmt2.setString(2, acc_fname.getText());
                stmt2.setString(3, acc_mname.getText());
                stmt2.setString(4, acc_lname.getText());
                stmt2.setString(5, user_gender.getText());
                stmt2.setString(6, acc_email.getText());
                stmt2.setString(7, acc_num.getText());
                stmt2.setString(8, member_type.getText());
                stmt2.setString(9, no_of_doses.getText());
                stmt2.setString(10, brch);
                stmt2.setString(11, acc_username.getText());

                stmt2.executeUpdate();

                acc_status.setTextFill(Color.GREEN);
                acc_status.setText("You have successfully updated your details.");

                connection.close();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
}


