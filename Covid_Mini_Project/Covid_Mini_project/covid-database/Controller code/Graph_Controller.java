package covid_resource;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;


import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Graph_Controller implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private BarChart barChart;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;
    @FXML
    private Label std_unvacc_count;
    @FXML
    private Label std_halfvacc_count;
    @FXML
    private Label std_fullvacc_count;
    @FXML
    private Label stf_unvacc_count;
    @FXML
    private Label stf_halfvacc_count;
    @FXML
    private Label stf_fullvacc_count;


    private int student_unvacc_count=0;
    private int student_halfvacc_count=0;
    private int student_fullvacc_count=0;
    private int staff_unvacc_count=0;
    private int staff_halfvacc_count=0;
    private int staff_fullvacc_count=0;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid_resources", "root", "Faze1$");
            Statement stmt1 = connection.createStatement();
            String q1 = "SELECT * from members";
            ResultSet set = stmt1.executeQuery(q1);

            while(set.next())
            {
                if("Student".equals(set.getString("member_type")))
                {
                    if("0".equals(set.getString("no_of_doses")))
                    {
                        student_unvacc_count = student_unvacc_count+1;
                    }
                    else if("1".equals(set.getString("no_of_doses")))
                    {
                        student_halfvacc_count = student_halfvacc_count+1;
                    }
                    else if("2".equals(set.getString("no_of_doses")))
                    {
                        student_fullvacc_count = student_fullvacc_count+1;
                    }
                }

                else if("Staff".equals(set.getString("member_type")))
                {
                    if("0".equals(set.getString("no_of_doses")))
                    {
                        staff_unvacc_count = staff_unvacc_count+1;
                    }
                    else if("1".equals(set.getString("no_of_doses")))
                    {
                        staff_halfvacc_count = staff_halfvacc_count+1;
                    }
                    else if("2".equals(set.getString("no_of_doses")))
                    {
                        staff_fullvacc_count = staff_fullvacc_count+1;
                    }
                }
            }
            connection.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        std_unvacc_count.setText(Integer.toString(student_unvacc_count));
        std_halfvacc_count.setText(Integer.toString(student_halfvacc_count));
        std_fullvacc_count.setText(Integer.toString(student_fullvacc_count));

        stf_unvacc_count.setText(Integer.toString(staff_unvacc_count));
        stf_halfvacc_count.setText(Integer.toString(staff_halfvacc_count));
        stf_fullvacc_count.setText(Integer.toString(staff_fullvacc_count));

        XYChart.Series set1=new XYChart.Series();
        set1.setName("Student");
        set1.getData().add(new XYChart.Data("Unvaccinated",student_unvacc_count));
        set1.getData().add(new XYChart.Data("Partially Vaccinated",student_halfvacc_count));
        set1.getData().add(new XYChart.Data("Fully Vaccinated",student_fullvacc_count));


        XYChart.Series set2=new XYChart.Series();
        set2.setName("Staff");
        set2.getData().add(new XYChart.Data("Unvaccinated",staff_unvacc_count));
        set2.getData().add(new XYChart.Data("Partially Vaccinated",staff_halfvacc_count));
        set2.getData().add(new XYChart.Data("Fully Vaccinated",staff_fullvacc_count));


        barChart.getData().addAll(set1,set2);
    }
}

