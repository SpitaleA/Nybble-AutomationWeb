package pages.demoQA;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class SelectablePage {
    public Button lastItemList = new Button(By.xpath("//ul[@id=\"verticalListContainer\"]/li[last()]"));

}
