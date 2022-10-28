package pages.tickTick;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class MainLoggedPageLeftPanel {
    public Button listsButton = new Button(By.xpath("//ul[@id=\"project-ul\"]//p[contains(@class,\"text-s\")]"));

    public Button addNewListBtn = new Button(By.xpath("//p[text()=\"Lists\"]/following-sibling::button//*[contains(@class,\"icon-list-add\")]"));
    public Button searchListByname(String name){
        try {
            Button listBtn = new Button(
                    By.xpath("//ul[@id=\"project-ul\"]//p[contains(@class,\"text-s\") and text()='" + name +"']")
            );
            return listBtn;
        } catch (Exception e){
            return null;
        }
    }
}
