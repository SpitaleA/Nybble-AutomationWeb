package cleanTest.yopMail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.yopMail.EmailDetailPage;
import pages.yopMail.InboxPageTopBar;
import pages.yopMail.InboxSideBar;
import pages.yopMail.MainPage;
import singletonSession.Session;

public class TestBaseYopMail {
    MainPage mainPage = new MainPage();
    InboxSideBar inboxSideBar = new InboxSideBar();
    InboxPageTopBar inboxPageTopBar = new InboxPageTopBar();
    EmailDetailPage emailDetailPage = new EmailDetailPage();
    @BeforeEach
    public void setup(){
        // todo create properties file
        Session.getInstance().getBrowser().get("https://yopmail.com/en/");

    }
    @AfterEach
    public void cleanup(){
        Session.getInstance().closeBrowser();
    }
}
