package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CRUDProjectTest {

    WebDriver driver;
    @BeforeEach
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://todo.ly/");

        // click login
        driver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
        // set email
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("agusto15@nybble.com");
        // set pwd
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("123456");
        // click login
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterEach
    public void cleanUp(){
        driver.quit();
    }


    @Test
    public void createProject() throws InterruptedException {
        int largo = driver.findElements(By.xpath("//li//td[text()='nuevo projecto update']")).size();
        int largo2 = driver.findElements(By.xpath("//li//td[text()='nuevo projecto']")).size();

        //Boton add new project
        driver.findElement(By.cssSelector("#MainTable > tbody > tr > td.MainTableLeft > div:nth-child(6) > div")).click();
//        Thread.sleep(1000);
        driver.findElement(By.id("NewProjNameInput")).sendKeys("nuevo projecto");
        driver.findElement(By.id("NewProjNameButton")).click();
//        Thread.sleep(2000);

        //Verificacion
        Assertions.assertEquals(largo2+1,driver.findElements(By.xpath("//li//td[text()='nuevo " +
                "projecto']")).size(),"ERROR no se creo el proyecto");
//        Thread.sleep(1000);

        //Edit project
        driver.findElement(By.xpath("//li[last()]//td[text()='nuevo projecto']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[last()]//td[text()='nuevo projecto']//following-sibling::td//div[@style=\"display: block;\"]//img[@src=\"/Images/dropdown.png\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"projectContextMenu\"]/li[1]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("ItemEditTextbox")).sendKeys(" update");
        Thread.sleep(1000);
        driver.findElement(By.id("ItemEditSubmit")).click();
        Thread.sleep(1000);

        //Verificacion
        Assertions.assertEquals(largo+1,driver.findElements(By.xpath("//li//td[text()='nuevo " +
                "projecto update']")).size(),"ERROR no se le cambio el nombre al proyecto");
        Thread.sleep(1000);


        //Delete
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[last()]//td[text()='nuevo projecto update']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[last()]//td[text()='nuevo projecto update']//following-sibling::td//div[@style=\"display: block;\"]//img[@src=\"/Images/dropdown.png\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("ProjShareMenuDel")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        //Verificacion
        Assertions.assertEquals(largo,driver.findElements(By.xpath("//li//td[text()='nuevo " +
                "projecto update']")).size(),"ERROR no se borro el elemento");
        Thread.sleep(1000);
    }
}
