package cleanTest.tickTick;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.tickTick.*;
import singletonSession.Session;

public class TestBaseTickTick {
    MainLoggedPage mainLoggedPage = new MainLoggedPage();
    MainPage mainPage = new MainPage();
    RegisterPage registerPage = new RegisterPage();
    SingInPage singInPage = new SingInPage();
    AddListModal addListModal = new AddListModal();
    MainLoggedPageLeftPanel mainLoggedPageLeftPanel = new MainLoggedPageLeftPanel();
    @BeforeEach
    public void setup(){
        Session.getInstance().getBrowser().get("https://ticktick.com/");
    }
    @AfterEach
    public void cleanup(){
        Session.getInstance().closeBrowser();
    }
}
