package pages.todoIstExam;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class EditProjectModal {

    public Button addButton = new Button(By.xpath("//button[@type=\"submit\"]"));
    public TextBox inputProjectTextBox = new TextBox(By.id("edit_project_modal_field_name"));



}
