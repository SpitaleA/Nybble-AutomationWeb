package pages.toDoIst;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class DeleteProjectModal {
    public Button deleteButton = new Button(By.xpath("//span[text()=\"Eliminar\"]"));
}
