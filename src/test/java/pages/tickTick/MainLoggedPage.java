package pages.tickTick;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class MainLoggedPage {
    public Button skipIntroBtn = new Button(By.xpath("//span[text()=\"Skip\"]"));
    public Button addTaskBtn = new Button(By.id("add-task"));
    public TextBox addTaskTxtBox = new TextBox(By.xpath(
            "//*[@id=\"add-task\"]//textarea[@autocorrect=\"off\"]"));
    public TextBox tasksTextContainers = new TextBox(By.xpath("//div[@id=\"task-list-content\"]/ul//span[text() and contains(@class,\"inline_3zuKd\")]"));
    public Label actualListName = new Label(By.id("project-name-bar"));

    public TextBox task4Textbox = new TextBox(By.xpath("(//div[contains(@class,\"text-def\")])[4]"));
    public TextBox getTask4EditTextbox = new TextBox(By.xpath("(//textarea[@autocorrect=\"off\" and @autocapitalize=\"off\"])[2]"));
    public TextBox searchForTaskByName(String name){
        try {
            TextBox taskTextBox = new TextBox(By.xpath("//div[@id=\"task-list-content\"]/ul//span[contains(@class,\"inline_3zuKd\") and text()=\""+ name +"\"]"));
            return taskTextBox;
        }catch (Exception e){
            return  null;
        }
    }
}
