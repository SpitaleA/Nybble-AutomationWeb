package pages.swagLabs;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class LoginPage {
    public TextBox userName = new TextBox(By.id("user-name"));
    public TextBox pwd = new TextBox(By.id("password"));
    public Button loginBtn = new Button(By.id("login-button"));


}
