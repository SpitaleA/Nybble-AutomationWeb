package cleanTest.juiceShop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.juiceShop.LoginModal;

import pages.juiceShop.MainPage;
import pages.juiceShop.RegisterPage;
import singletonSession.Session;

public class TestBaseJuice {

    LoginModal loginPage = new LoginModal();
    MainPage mainPage = new MainPage();
    RegisterPage registerPage = new RegisterPage();


    @BeforeEach
    public void setup(){
        // todo create properties file
        Session.getInstance().getBrowser().get("http://localhost:3000/#/");
    }
    @AfterEach
    public void cleanup(){
        Session.getInstance().closeBrowser();
    }
}
