package pages.tickTick;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class MainPage {
    public Button singUpBtn = new Button(By.xpath("(//a[@href=\"/signup\"])[1]"));
    public Button singInBtn = new Button(By.xpath("(//a[@href=\"/signin\"])[1]"));

}
