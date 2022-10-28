package pages.tickTick;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class SingInPage {
    public TextBox emailTxtBox = new TextBox(By.id("emailOrPhone"));
    public TextBox pwdTxtBox = new TextBox(By.id("password"));
    public Button singInBtn = new Button(By.xpath("//button[text()=\"Sign In\"]"));

    public void singIn(String email,String pwd){
        this.emailTxtBox.setText(email);
        this.pwdTxtBox.setText(pwd);
        this.singInBtn.click();
    }
}
