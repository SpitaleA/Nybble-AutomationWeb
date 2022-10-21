package controlSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import singletonSession.Session;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Control {
    protected By locator;
    protected WebElement control;
    protected List<WebElement> controls = new ArrayList<>();

    public Control (By locator){
        this.locator=locator;
    }

    protected void findControl(){
        control= Session.getInstance().getBrowser().findElement(this.locator);
    }
    public void findControls(){
        controls= Session.getInstance().getBrowser().findElements(this.locator);
//        controls.get(controls.size()-1);
    }

    /**
     *
     */
    public void click(){
        this.findControl();
        control.click();
    }

    public boolean isControlDisplayed(){
        try {
            this.findControl();
            return control.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }


    public String getText(){
        this.findControl();
        return control.getText();
    }
    public String getAttributeValue(String attribute){
        this.findControl();
        return this.control.getAttribute(attribute);
    }

    public void waitClickable()
    {
        // todo --> factory para instanciar el wait una sola vez
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(this.locator));
    }
    public void waitInvisibility(){
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(this.locator));
    }

}