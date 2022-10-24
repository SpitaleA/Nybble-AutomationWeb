package cleanTest.todoist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.toDoIst.*;
import singletonSession.Session;

public class TestBaseTodoIst {
    public MainPage mainPage=new MainPage();
    public LoginPage loginPage = new LoginPage();
    public LeftPanelSection leftPanel = new LeftPanelSection();
    public EditProjectModal editProjectModal = new EditProjectModal();
    public DeleteProjectModal deleteProjectModal = new DeleteProjectModal();
    @BeforeEach
    public void setup(){
        // todo create properties file
        Session.getInstance().getBrowser().get("https://todoist.com/es");
    }
    @AfterEach
    public void cleanup(){
        Session.getInstance().closeBrowser();
    }
}
