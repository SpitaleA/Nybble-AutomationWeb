package cleanTest.todoIstExam;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.todoIstExam.*;
import singletonSession.Session;

public class TestBaseTodoIstExam {
    public MainPage mainPage=new MainPage();
    public LoginPage loginPage = new LoginPage();
    public LeftPanelSection leftPanel = new LeftPanelSection();
    public EditProjectModal editProjectModal = new EditProjectModal();
    public TopBarPage topBarPage = new TopBarPage();
    public CenterTaskAreaPage centerTaskAreaPage = new CenterTaskAreaPage();
    public EditTaskModal editTaskModal = new EditTaskModal();
    public DeleteModal deleteModal = new DeleteModal();
    public String priority1 = "rgba(209, 69, 59, 1)";
    public String priority2 = "rgba(235, 137, 9, 1)";
    public String priority3 = "rgba(36, 111, 224, 1)";
    public String priority4 = "rgba(128, 128, 128, 1)";
    public Integer numberOfTasksBefore;
    public Integer numberOfTasksAfter;
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
