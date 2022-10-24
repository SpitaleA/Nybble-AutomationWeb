package pages.toDoIst;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class LoginPage {
    public TextBox emailTextBox = new TextBox(By.id("element-0"));
    public TextBox passwordTextBox = new TextBox(By.id("element-3"));
    public Button loginButton = new Button(By.xpath("//button[@type=\"submit\"]"));

    public void login(String user,String pwd){
        emailTextBox.setText(user);
        passwordTextBox.setText(pwd);
        loginButton.click();
    }
}
