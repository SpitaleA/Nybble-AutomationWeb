package cleanTest.demoQA;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.demoQA.SelectablePage;
import singletonSession.Session;

public class TestBase {
    protected SelectablePage selectablePage = new SelectablePage();
    @BeforeEach
    public void setup(){
        // todo create properties file
        Session.getInstance().getBrowser().get("https://demoqa.com/selectable");
    }
    @AfterEach
    public void cleanup(){
        Session.getInstance().closeBrowser();
    }
}
