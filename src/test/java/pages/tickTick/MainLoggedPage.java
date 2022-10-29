package pages.tickTick;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class MainLoggedPage {
    public Label loadingPage = new Label(By.xpath("//*[@id=\"loading-view\"]"));
    public Button skipIntroBtn = new Button(By.xpath("//span[text()=\"Skip\"]"));
    public Button addTaskBtn = new Button(By.id("add-task"));
    public TextBox addTaskTxtBox = new TextBox(By.xpath(
            "//*[@id=\"add-task\"]//textarea[@autocorrect=\"off\"]"));
    public TextBox tasksTextContainers = new TextBox(By.xpath("//div[@id=\"task-list-content\"]/ul//span[text() and contains(@class,\"inline_3zuKd\")]"));
    public Label actualListName = new Label(By.id("project-name-bar"));
    public Label noDateLabel = new Label(By.xpath("//h6[contains(text(),\"No Date\")]"));

    public TextBox getTaskEditTextbox = new TextBox(By.xpath("//li//textarea[@autocorrect=\"off\" and @autocapitalize=\"off\"]"));
    public Button openDueDateCalendar = new Button(By.xpath("//span[@id='preview']/span/a[2]/span/span"));
    public Button setTomorrowDueDate = new Button(By.xpath("//div[contains(@class,\"avoid-event\")]//div/*[contains(@class,\"icon-quick-tomorrow\")]/*"));
    public TextBox descriptionEditTextbox = new TextBox(By.xpath("//span[text()='Description']"));
    public TextBox getTaskDescriptionEditTextbox = new TextBox(By.xpath("//*[@id=\"taskcontent\"]/div/div/div/div/textarea"));
    public TextBox searchForTaskByName(String name){
        try {
            TextBox taskTextBox = new TextBox(By.xpath("//div[@id=\"task-list-content\"]/ul//span[contains(@class,\"inline_3zuKd\") and text()=\""+ name +"\"]"));
            return taskTextBox;
        }catch (Exception e){
            return  null;
        }
    }

}
