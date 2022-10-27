package cleanTest.juiceShop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class LoginTest extends TestBaseJuice{

    @Test
    public void registerLoginLogout() throws InterruptedException {
        String randomEmail = "email-" + new Date().getTime() + "@email.com";
        String pwd = "123456";
        String securityAns = "123456";

        //REGISTER
        mainPage.dismissPopUpBtn.click();
        mainPage.accountBtn.click();
        mainPage.loginBtn.click();
        loginPage.registerBtn.click();
        registerPage.emailTxtBox.setText(randomEmail);
        registerPage.pwdTxtBox.setText(pwd);
        registerPage.repeatPwdTxtBox.setText(pwd);
        mainPage.logoLinkBtn.waitClickable();
        registerPage.securityQuestionComboBoxBtn.click();
        registerPage.selectSecurityQuestion(1).waitPresence();
        registerPage.selectSecurityQuestion(1).waitVisibility();
        registerPage.selectSecurityQuestion(1).click();
        registerPage.securityAnswerTxtBox.setText(securityAns);
        registerPage.registerBtn.click();

        Assertions.assertFalse(loginPage.loginLabel.isControlDisplayed(),"ERROR user was not registered");

        //LOGIN
        loginPage.emailTxtBox.setText(randomEmail);
        loginPage.pwd.setText(pwd);
        loginPage.loginBtn.click();

        Assertions.assertTrue(mainPage.cartBtn.isControlDisplayed(),"ERROR user was not logged in");

        //LOGOUT
        mainPage.accountBtn.click();
        mainPage.logOutBtn.click();

        Assertions.assertFalse(mainPage.cartBtn.isControlDisplayed(),"ERROR user was not logged out");

//        Thread.sleep(3000);
    }
}
