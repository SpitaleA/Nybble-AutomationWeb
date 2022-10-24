package cleanTest.todoly;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends  TestBaseTodoLy{
    @Test
    public void verifyLoginSuccessfully(){
        mainPage.loginButton.click();
        loginModal.emailTextBox.setText("selenium@selenium2022.com");
        loginModal.passwordTextBox.setText("12345");
        loginModal.loginButton.click();
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR login was not successfully");

    }
}
