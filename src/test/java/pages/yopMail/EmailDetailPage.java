package pages.yopMail;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class EmailDetailPage {
    public TextBox to = new TextBox(By.id("msgto"));
    public TextBox subject = new TextBox(By.id("msgsubject"));
    public TextBox msgBody = new TextBox(By.id("msgbody"));
    public Button sendBtn = new Button(By.id("msgsend"));
    public Label succesSent = new Label(By.id("msgpopmsg"));
}
