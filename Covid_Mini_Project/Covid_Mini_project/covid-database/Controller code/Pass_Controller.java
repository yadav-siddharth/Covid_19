package covid_resource;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Pass_Controller extends Login_Controller
{
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

    public void get_details(String username)
    {
        String full_name;
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
                    full_name=set.getString("first_name").concat(" ").concat(set.getString("middle_name").concat(" ").concat(set.getString("last_name")));
                    pass_name.setText(full_name);

                    pass_gender.setText(set.getString("gender"));

                    pass_email.setText(set.getString("email_id"));

                    pass_num.setText(set.getString("phone_no"));

                    pass_member.setText(set.getString("member_type"));

                    pass_branch.setText(set.getString("branch"));

                    if(set.getString("no_of_doses").equals("1")||set.getString("no_of_doses").equals("2"))
                    {
                        pass_vacc.setText("YES");
                    }
                    else
                    {
                        pass_vacc.setText("NO");
                    }

                    pass_doses.setText(set.getString("no_of_doses"));
                }
            }

            connection.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
