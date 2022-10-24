package cleanTest.todoly;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.todoLy.*;
import singletonSession.Session;

public class TestBaseTodoLy {
    public MainPage mainPage=new MainPage();
    public LeftPanelSection leftPanelSection = new LeftPanelSection();
    public LoginModal loginModal= new LoginModal();
    public MenuSection menuSection= new MenuSection();
    public SettingsPage settingsPage = new SettingsPage();
    public RegisterModal registerModal = new RegisterModal();
    @BeforeEach
    public void setup(){
        // todo create properties file
        Session.getInstance().getBrowser().get("https://todo.ly/");
    }
    @AfterEach
    public void cleanup(){
        Session.getInstance().closeBrowser();
    }
}
