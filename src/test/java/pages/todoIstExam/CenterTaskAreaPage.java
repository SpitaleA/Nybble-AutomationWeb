package pages.todoIstExam;

import controlSelenium.Button;
import controlSelenium.CheckBox;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class CenterTaskAreaPage {
    public Button addTaskBtn = new Button(By.xpath("//button[@class=\"plus_add_button\"]"));
    public TextBox titleTaskEditTextBox = new TextBox(By.xpath("//div[@class=\"notranslate public-DraftEditor-content\"]"));
    public Button setDatebtn = new Button(By.xpath("//button[@class=\"item_due_selector icon_pill\"]"));
    public TextBox setDateTextBox = new TextBox(By.xpath("//div[@class=\"scheduler-input\"]/input[@value]"));
    public Button setPriorityBtn = new Button(By.xpath("//button[@class=\"item_action item_actions_priority\"]"));
    public Button confirmAddTaskbtn = new Button(By.xpath("//button[@data-testid=\"task-editor-submit-button\"]"));
    public CheckBox checkBoxLastTask = new CheckBox(By.xpath("(//button//div[@class=\"task_checkbox__circle\"])[last()]"));
    public Button tasks = new Button(By.xpath("//ul[@class=\"items\"]/li"));

    public Button selectTaskByName(String taskName){
        try {
            Button taskByNameBtn = new Button(By.xpath("//div[text()=\"" + taskName + "\"][last()]"));
            return taskByNameBtn;
        } catch (Exception e){
            return null;
        }
    }
    public Button setPriority(String priorityNumber){
        Button prioritySet = new Button(By.xpath("//span[@class=\"priority_picker_item_name\" and text()=\"Prioridad " + priorityNumber +"\"]"));
        return prioritySet;
    }

}
