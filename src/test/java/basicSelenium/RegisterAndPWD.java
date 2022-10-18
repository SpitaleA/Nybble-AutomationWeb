package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RegisterAndPWD {

    public String email = getAlphaNumericString()+"@"+getAlphaNumericString()+".com";
    WebDriver driver;
    @BeforeEach
    public void register() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://todo.ly/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // click sing up
        driver.findElement(By.xpath("//img[@src='/Images/design/pagesignup.png']")).click();
        // set name
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_TextBoxFullName")).sendKeys("agusto");
        // set email
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_TextBoxEmail")).sendKeys(email);
        // set pwd
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_TextBoxPassword")).sendKeys("12345");
        //click on checkbox
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_CheckBoxTerms")).click();
        // click sing up
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_ButtonSignup")).click();

        //Verificacion
        Assertions.assertTrue(driver.findElement(By.id("CurrentProjectTitle")).isDisplayed());
    }
    @AfterEach
    public void cleanUp(){
        driver.quit();
    }
    @Test
    public void changePWD() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//a[@href=\"javascript:OpenSettingsDialog();\"]")).click();
        driver.findElement(By.id("TextPwOld")).sendKeys("12345");
        driver.findElement(By.id("TextPwNew")).sendKeys("123456");
        driver.findElement(By.xpath("//button//span[text()=\"Ok\"]")).click();
        driver.findElement(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).click();

        // click login
        driver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
        // set email
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys(email);
        // set pwd
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("123456");
        // click login
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

        //Verificacion
        Assertions.assertTrue(driver.findElement(By.id("CurrentProjectTitle")).isDisplayed());
    }
    static String getAlphaNumericString()
    {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(6);

        for (int i = 0; i < 6; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
}
