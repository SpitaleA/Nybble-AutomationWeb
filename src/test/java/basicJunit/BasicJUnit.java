package basicJunit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicJUnit {
    WebDriver driver;
    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://todo.ly/");

    }
    @AfterEach
    public void cleanUp(){
        driver.quit();
    }

    @Test
    public void loginTodoLyTest() throws InterruptedException {

        // click login
        driver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
        // set email
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("selenium@selenium2022.com");
        // set pwd
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        // click login
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

        Thread.sleep(2000);
        // verificacion

        Assertions.assertTrue(driver.findElement(By.xpath("//a[text()='Logout']")).isDisplayed(),"ERROR!! no se pudo iniciar sesion");

    }
}
