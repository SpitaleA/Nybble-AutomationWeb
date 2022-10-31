package pages.tickTick;

import controlSelenium.Button;
import controlSelenium.Label;
import org.openqa.selenium.By;

public class MainPage {
    public Button singUpBtn = new Button(By.xpath("//div[@class=\"navRow_236y3 container\"]//a[@href=\"/signup\"]"));
    public Button singInBtn = new Button(By.xpath("(//a[@href=\"/signin\"])[1]"));
    public Label bannerLabel = new Label(By.xpath("//h2[text()=\"Stay Organized \"]"));

}
