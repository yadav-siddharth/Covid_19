package covid_resource;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import java.io.IOException;

public class Doubt_Controller
{
    @FXML
    private Label answer;
    @FXML
    private TextField user_doubt;
    @FXML
    private Label status;
    @FXML
    private Button q1;
    @FXML
    private Button q2;
    @FXML
    private Button q3;
    @FXML
    private Button q4;
    @FXML
    private Button q5;
    @FXML
    private Button q6;
    @FXML
    private Button q7;
    @FXML
    private Button q8;

    public void doubt1(ActionEvent e) throws IOException
    {
        q1.setStyle("-fx-background-color: #febdbb; -fx-background-radius: 30");
        q2.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q3.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q4.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q5.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q6.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q7.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q8.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        answer.setText("COVID-19 has a higher rate of severe disease and mortality in nearly every age group, compared with influenza (flu).\n" +
                "John Hopkins Bloomberg School of Public Health reported that “COVID-19 has killed more people in the US than flu has in the last five years.”\n" +
                "In the UK, data revealed that between January-August, COVID-19 killed 3.4 times as many people in 2020 than flu and pneumonia combined.");
    }

    public void doubt2(ActionEvent e) throws IOException
    {
        q2.setStyle("-fx-background-color: #febdbb; -fx-background-radius: 30");
        q1.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q3.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q4.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q5.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q6.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q7.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q8.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        answer.setText("This depends very much on where people live and how old they are, with some parts of the world hit harder than others, " +
                "and some age groups being affected more, such as older people. However," +
                " even in countries where the COVID-19 death rate seems relatively low, the indirect impact on reduced health services, vaccine supply shortages, " +
                "and reluctance to seek medical treatment for fear of infection is having a drastic impact and putting tens of millions of people at risk – including children and newborns.");
    }

    public void doubt3(ActionEvent e)throws IOException
    {
        q3.setStyle("-fx-background-color: #febdbb; -fx-background-radius: 30");
        q1.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q2.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q4.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q5.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q6.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q7.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q8.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        answer.setText("Mask wearing is a very simple and effective way to reduce transmission and save lives. The degree of protection depends on the type of mask, how well they worn and on other factors such as the behaviour of people wearing them and the behaviour of air droplets in different settings.");
    }

    public void doubt4(ActionEvent e) throws  IOException
    {
        q4.setStyle("-fx-background-color: #febdbb; -fx-background-radius: 30");
        q1.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q2.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q3.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q5.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q6.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q7.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q8.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        answer.setText("Historically, the most successful way to achieve herd immunity is actually through mass vaccination. This is a much safer route as the alternative is for roughly 60% of the population to be infected with COVID-19 which essentially means leaving the virus unchecked.");
    }

    public void doubt5(ActionEvent e) throws  IOException
    {
        q5.setStyle("-fx-background-color: #febdbb; -fx-background-radius: 30");
        q1.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q2.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q3.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q4.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q6.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q7.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q8.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        answer.setText("COVID-19 vaccines have been developed and produced in record time, but it’s also involved unprecedented levels of funding and global cooperation to tackle a global threat. So far, all approved COVID-19 vaccines have undergone large clinical trials with rigorous safety protocols, and without major safety concerns raised.");
    }

    public void doubt6(ActionEvent e)throws IOException
    {
        q6.setStyle("-fx-background-color: #febdbb; -fx-background-radius: 30");
        q1.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q2.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q3.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q4.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q5.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q7.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q8.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        answer.setText("As with other coronaviruses, such as those that cause the common cold, SARS-CoV-2 can reinfect people. There have been multiple reports of reinfection, including a 25-year-old man in the US who tested positive twice. The Lancet reported that “the second infection was symptomatically more severe than the first.”\n" +
                "Even if you have had a test that detects antibodies, reinfection is still possible, although less likely.\n" +
                "Antibodies are only one part of the vast, complex immune response that is set in motion when a person becomes infected with a virus like SARS-CoV-2 so having antibodies isn’t enough to guarantee long-term protection.");
    }

    public void doubt7(ActionEvent e) throws IOException
    {
        q7.setStyle("-fx-background-color: #febdbb; -fx-background-radius: 30");
        q1.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q2.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q3.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q4.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q5.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q6.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q8.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        answer.setText("Even though regularly washing your hands is very important, as with masks it is not enough on its own. Public health guidelines all work in tandem to prevent the spread of germs.\n" +
                "Keep washing your hands for at least 20 seconds each time, keep carrying antibacterial gel when you’re travelling and remember to wear a mask and practice physical distancing.");
    }

    public void doubt8(ActionEvent e) throws IOException
    {
        q8.setStyle("-fx-background-color: #febdbb; -fx-background-radius: 30");
        q1.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q2.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q3.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q4.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q5.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q6.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        q7.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 30");
        answer.setText("Search for keywords like ‘fit,’ ‘healthy’ and ‘COVID’ and you will see countless headlines referring to people who have died or suffered from severe symptoms despite being otherwise healthy. So even if you are less at risk due to your age or BMI, that doesn’t guarantee that you won’t suffer from long-term symptoms like breathlessness, fatigue, a loss of smell and/or taste.");
    }

    public void post_doubt(ActionEvent e) throws  IOException
    {

        if(!user_doubt.getText().isBlank())
        {
            status.setTextFill(Color.GREEN);
            status.setText("Don't worry! We'll consult a doctor for your question. If urgent, we suggest you to visit our helpline number page.");
        }
        else
        {
            status.setTextFill(Color.RED);
            status.setText("Please enter a question.");
        }
    }
}
