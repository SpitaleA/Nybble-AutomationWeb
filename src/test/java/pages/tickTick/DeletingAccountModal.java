package pages.tickTick;

import controlSelenium.Button;
import controlSelenium.CheckBox;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class DeletingAccountModal {
    public TextBox pwdConfirmTxtbox = new TextBox(By.id("password-input"));
    public CheckBox assureDeleteCheckbox = new CheckBox(By.id("check-data"));
    public CheckBox secondAssureCheckbox = new CheckBox(By.id("check-account"));
    public Button confirmBtn = new Button(By.xpath("//button[text()=\"Confirm\"]"));
}
