package cleanTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Date;

public class RegisterAndPwd extends TestBaseTodoLy{
    @Test
    public void register() throws InterruptedException {
        String email = "mail" + new Date().getTime() +"@hola.com";
        mainPage.registerButton.click();
        registerModal.register("roberto",email,"12345");
        menuSection.settingsButton.click();
        settingsPage.newPWD.setText("123456");
        settingsPage.oldPWD.setText("12345");
//        settingsPage.okButton.waitClickable();
        settingsPage.okButton.click();
//        menuSection.logoutButton.waitClickable();
        menuSection.logoutButton.click();
        mainPage.loginButton.waitClickable();
        mainPage.loginButton.click();
        loginModal.login(email,"123456");

        //Verificacion
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed());

    }

}
