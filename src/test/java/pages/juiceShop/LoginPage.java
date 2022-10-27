package pages.juiceShop;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class LoginPage {
    public Button registerBtn = new Button(By.xpath("//a[@href=\"#/register\"]"));
    public Button loginBtn = new Button(By.id("loginButton"));
    public TextBox emailTxtBox = new TextBox(By.id("email"));
    public TextBox pwd = new TextBox(By.id("password"));
    public Label loginLabel = new Label(By.xpath("//h1[text()=\"Login\"]"));


}
