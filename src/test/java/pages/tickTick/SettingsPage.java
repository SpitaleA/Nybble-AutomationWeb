package pages.tickTick;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class SettingsPage {
    public Button deleteAccountBtn = new Button(By.xpath("//a[text()=\"Delete Account\"]"));
    public Button accountAndSecurityBtn = new Button(By.xpath("//span[text()=\"Account and Security\"]"));
}
