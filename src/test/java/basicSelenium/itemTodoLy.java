package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class itemTodoLy {
    WebDriver driver;
    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://todo.ly/");
        //implicit wait --> generico
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterEach
    public void cleanUp(){
        driver.quit();
    }

    @Test
    public void crudTest() throws InterruptedException {
        // click login
        driver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
        // set email
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("agusto15@nybble.com");
        // set pwd
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("123456");
        // click login
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        //Thread.sleep(2000);
        // Explicit Wait --- Button -> Logout

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(elementToBeClickable(By.xpath("//a[text()='Logout']")));
        Actions acciones = new Actions(driver);

        Assertions.assertTrue(driver.findElement(By.xpath("//a[text()='Logout']")).isDisplayed(),
                "ERROR!! no se pudo iniciar sesion");

        /*
         * CREATE
         * */
        String nameProj="AUTO"+new Date().getTime();

        driver.findElement(By.xpath("//td[text()='Add New Project']")).click();
        driver.findElement(By.id("NewProjNameInput")).sendKeys(nameProj);
        driver.findElement(By.id("NewProjNameButton")).click();
        //Thread.sleep(2000);
        wait.until(ExpectedConditions.textToBe(By.xpath("//li[last()]//td[text()='"+nameProj+"']"),nameProj));
        String actualResult= driver.findElement(By.xpath("//li[last()]//td[text()='"+nameProj+"']")).getText();
        String expectedResult=nameProj;
        Assertions.assertEquals(expectedResult,actualResult,"ERROR no se creo el project");

        //CREO NUEVO ITEM EN PROYECTO

        wait.until(ExpectedConditions.textToBe(By.id("CurrentProjectTitle"), nameProj));
        driver.findElement(By.id("NewItemContentInput")).sendKeys("nuevo item" + Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("NewItemAddButton")));
        Assertions.assertEquals("nuevo item",driver.findElement(By.xpath("//div[text()='nuevo item']")).getText(),"ERROR no se edito el item");


        //EDITO EL ITEM CREADO ANTERIORMENTE

//        wait.until(ExpectedConditions.textToBe(By.xpath("//div[text()='nuevo item']"), "nuevo item"));
        driver.findElement(By.xpath("//div[text()='nuevo item']")).click();
        driver.findElement(By.xpath("//textarea[@id='ItemEditTextbox']")).sendKeys(" update" + Keys.ENTER);
        wait.until(ExpectedConditions.not(visibilityOf(driver.findElement(By.xpath("//img[@id=\"LoaderImg\" and contains(concat(' ', @style, ' '), ' display: block;')]")))));
        Assertions.assertEquals("nuevo item update",driver.findElement(By.xpath("//div[text()='nuevo item update']")).getText(),"ERROR no se edito el item");


        //BORRO ELEMENTO CREADO ANTERIORMENTE
        acciones.moveToElement(driver.findElement(By.xpath("//div[text()='nuevo item update']"))).pause(Duration.ofSeconds(1)).perform();
        driver.findElement(By.xpath("//div[@class=\"ItemIndicator\"]//img[@src=\"/Images/dropdown.png\" and @style=\"display: inline;\"]")).click();
        acciones.moveToElement(driver.findElement(By.xpath("//ul[@id=\"itemContextMenu\"]//a[@href=\"#delete\"]"))).pause(Duration.ofSeconds(1)).perform();
        driver.findElement(By.xpath("//ul[@id=\"itemContextMenu\"]//a[@href=\"#delete\"]")).click();
        wait.until(elementToBeClickable(By.xpath("//span[@id='InfoMessageText']")));
        Assertions.assertEquals("Item has been Deleted",driver.findElement(By.xpath("//span[@id='InfoMessageText']")).getText(),"ERROR no se borro el item");
    }
}
