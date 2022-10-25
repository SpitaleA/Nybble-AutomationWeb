package cleanTest.yopMail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import singletonSession.Session;

import java.util.Date;


public class MailTest extends  TestBaseYopMail{

    @Test
    public void mailSendTest() throws InterruptedException {
        String randomEmail = "mail" + new Date().getTime();
        String randomSubject = "subject " + new Date().getTime();
        String randomBody = "body " + new Date().getTime();
        mainPage.newEmailTextBox.setText(randomEmail + Keys.ENTER);
        inboxPageTopBar.newMsgBtn.waitVisibility();
        inboxPageTopBar.newMsgBtn.click();

        Session.getInstance().getBrowser().switchTo().frame("ifmail");
        emailDetailPage.to.setText(randomEmail);
        emailDetailPage.subject.setText(randomSubject);
        emailDetailPage.msgBody.setText(randomBody);
        emailDetailPage.sendBtn.click();
        emailDetailPage.succesSent.waitVisibility();

        Session.getInstance().getBrowser().switchTo().defaultContent();
        inboxPageTopBar.refreshBtn.waitClickable();
        inboxPageTopBar.refreshBtn.click();
        emailDetailPage.succesSent.waitInvisibility();
        inboxPageTopBar.refreshBtn.waitClickable();
        inboxPageTopBar.refreshBtn.click();

        Session.getInstance().getBrowser().switchTo().frame("ifinbox");
        inboxSideBar.lastEmail.waitPresence();

        Assertions.assertEquals(randomSubject,inboxSideBar.lastEmail.getText(),"ERROR msg was not sent");

    }
}
