package pages.todoIstExam;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class EditTaskModal {
    public Button comboBoxPriorityBtn = new Button(By.xpath("//div[text()=\"Prioridad\"]/following-sibling::div//div/button[@aria-haspopup=\"listbox\"]"));

    public Button setDateBtn = new Button(By.xpath("//div[text()=\"Fecha de vencimiento\"]/following-sibling::div//button"));
    public TextBox setDateTextBox = new TextBox(By.xpath("//input[@placeholder=\"Introduce una fecha de vencimiento\"]"));
    public Button closeModalBtn = new Button(By.xpath("//button[@aria-label=\"Cerrar ventana\"]"));
    public Button moreOptions = new Button(By.xpath("//div[@class=\"f9408a0e f53218d5\"]/button[contains(@aria-label,\"s acciones\")]"));
    public Button deleteTaskBtn = new Button(By.xpath("//div[contains(text(),\"Eliminar tar\")]"));
    public Button setPriority(String priorityNumber){
        Button prioritySet = new Button(By.xpath("//span[@class=\"priority_picker_item_name\" and text()=\"Prioridad " + priorityNumber +"\"]"));
        return prioritySet;
    }

}
