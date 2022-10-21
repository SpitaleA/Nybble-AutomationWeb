package cleanTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.todoLy.MenuSection;
import pages.todoLy.SettingsPage;

public class ChangeNameTest extends  TestBaseTodoLy{


    @Test
    public void verifyChangeName(){
        mainPage.loginButton.click();
        loginModal.login("agusto15@nybble.com","123456");
        menuSection.settingsButton.click();
        settingsPage.nameTextBox.setText("nombre update");
        settingsPage.okButton.click();
        menuSection.settingsButton.click();

        //Validacion
        Assertions.assertEquals("nombre update",settingsPage.nameTextBox.getAttributeValue("value"),"ERROR no se edito el nombre");
    }
}
