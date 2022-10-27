package pages.juiceShop;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class RegisterPage {
    public TextBox emailTxtBox = new TextBox(By.id("emailControl"));
    public TextBox pwdTxtBox = new TextBox(By.id("passwordControl"));
    public TextBox repeatPwdTxtBox = new TextBox(By.id("repeatPasswordControl"));
    public TextBox securityAnswerTxtBox = new TextBox(By.id("securityAnswerControl"));
    public Button registerBtn = new Button(By.id("registerButton"));
    public Button securityQuestionComboBoxBtn = new Button(By.xpath("//div[@class=\"security-container\"]/mat-form-field[@class]"));

    //3 a 16
    public Button selectSecurityQuestion(int position){
        Button selectBtn = new Button(By.id("mat-option-" + (position+2)));
        return selectBtn;
    }

}
