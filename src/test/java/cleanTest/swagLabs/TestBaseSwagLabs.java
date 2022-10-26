package cleanTest.swagLabs;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.swagLabs.CartPage;
import pages.swagLabs.LandingPage;
import pages.swagLabs.LoginPage;
import singletonSession.Session;

public class TestBaseSwagLabs {
    CartPage cartPage = new CartPage();
    LandingPage landingPage = new LandingPage();
    LoginPage loginPage = new LoginPage();
    @BeforeEach
    public void setup(){
        // todo create properties file
        Session.getInstance().getBrowser().get("https://www.saucedemo.com/");
    }
    @AfterEach
    public void cleanup(){
        Session.getInstance().closeBrowser();
    }
}
