package pages.yopMail;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class InboxPageTopBar {
    public Button newMsgBtn = new Button(By.id("newmail"));
    public Button refreshBtn = new Button(By.id("refresh"));

}
