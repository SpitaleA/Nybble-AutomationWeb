package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class FullNameChange {

    WebDriver driver;
    @BeforeEach
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://todo.ly/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // click login
        driver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
        // set email
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("agusto15@nybble.com");
        // set pwd
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("123456");
        // click login
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

    }
    @AfterEach
    public void cleanUp(){
        driver.quit();
    }


    @Test
    public void createProject() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));

//        wait.until(elementToBeClickable(By.xpath("//a[@href=\"javascript:OpenSettingsDialog();\"]")));
        driver.findElement(By.xpath("//a[@href=\"javascript:OpenSettingsDialog();\"]")).click();

        wait.until(elementToBeClickable(By.id("FullNameInput")));
        driver.findElement(By.id("FullNameInput")).clear();
        driver.findElement(By.id("FullNameInput")).sendKeys("agusto update");

//        wait.until(elementToBeClickable(By.id("FullNameInput")));
        driver.findElement(By.xpath("//button//span[text()=\"Ok\"]")).click();
//        wait.until(elementToBeClickable(By.xpath("//a[@href=\"javascript:OpenSettingsDialog();\"]")));
        driver.findElement(By.xpath("//a[@href=\"javascript:OpenSettingsDialog();\"]")).click();

        //Validacion
        Assertions.assertEquals("agusto update",driver.findElement(By.id("FullNameInput")).getAttribute("value"),"ERROR no se edito el nombre");
    }
}
