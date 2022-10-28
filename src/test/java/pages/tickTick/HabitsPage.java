package pages.tickTick;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class HabitsPage {
    public Button addHabitButton = new Button(By.xpath("//*[@class=\"inline-block w-[18px] h-[18px] mr-[8px] cursor-pointer\"]"));
    public TextBox habitTitle = new TextBox(By.xpath("//input[@placeholder=\"Daily Check-in\"]"));
    public Button saveHabitBtn = new Button(By.xpath("//button[text()=\"Save\"]"));
    public Button editButtonBtnHover = new Button(By.xpath("//ul[@role=\"menu\"]/li"));
    public Button deleteButtonBtn = new Button(By.xpath("(//ul[@role=\"menu\"]/li/div)[last()]"));
    public Button deleteButtonConfirmBtn = new Button(By.xpath("//button[text()=\"Delete\"]"));
    public TextBox searchHabitsByName(String name){
        try{
            TextBox habitTxtBox = new TextBox(By.xpath("//div[@style]/div/div/p[text()='"+ name +"']"));
            return habitTxtBox;
        }catch (Exception e){
            return null;
        }
    }
}
