package pages.tickTick;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class AddListModal {
    public TextBox listNameTextBox = new TextBox(By.id("edit-project-name"));
    public Button saveListBtn = new Button(By.xpath("//button[contains(text(),\"Save\")]"));

}
