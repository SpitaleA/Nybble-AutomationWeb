package pages.tickTick;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class RegisterPage {
    public TextBox userNameTxtBox = new TextBox(By.id("name"));
    public TextBox emailTxtBox = new TextBox(By.xpath("//input[@placeholder=\"Email\"]"));
    public TextBox pwdTxtBox = new TextBox(By.id("password"));
    public Button singUpBtn = new Button(By.xpath("//button[text()=\"Sign Up\"]"));
}
