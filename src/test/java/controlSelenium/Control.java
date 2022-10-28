package controlSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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
    protected void findControls(){
        controls= Session.getInstance().getBrowser().findElements(this.locator);
    }
    public Integer findControlsQuantity(){
        return Session.getInstance().getBrowser().findElements(this.locator).size()-1;
    }
    public void makeRightClickAction()
    {
        this.findControl();
        Actions action = new Actions(Session.getInstance().getBrowser());
        action.contextClick(this.control).perform();
    }
    public void hover(){
        this.findControl();
        Actions action = new Actions(Session.getInstance().getBrowser());
        action.moveToElement(this.control).perform();
    }
    public void sendKeysAction(String text){
        this.findControl();
        Actions action = new Actions(Session.getInstance().getBrowser());
        action.sendKeys(text)
                .perform();
    }
    /**
     *
     */
    public void click(){
        waitPresence();
        this.findControl();
        control.click();

    }
    /** Verifica si el control en cuestion isDisplayed
     * @return  boolean
     */
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
    public boolean hasAttributeValue(String attribute,String value){
        this.findControl();
        return this.control.getAttribute(attribute).contains(value);

    }
    public String getCssAttributeValue(String style){
        this.findControl();
        return this.control.getCssValue(style);
    }

    /** Espera a que el control tenga dentro de un ATRIBUTO un texto especifico
    * @param attribute: es por ejemplo el CLASS en un elemento HTML
    * @param value: valor dentro del ATRIBUTO HTML
     */
    public void waitUntilElementHasHtmlAttribute(String attribute, String value){
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(this.locator,attribute,value));
    }

    /** Espera a que el control tenga dentro de un ATRIBUTO un texto especifico
     */
    public void waitClickable()
    {
        // todo --> factory para instanciar el wait una sola vez
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(this.locator));
    }
    /** Espera a que el control tenga dentro de un ATRIBUTO un texto especifico
     */
    public void waitInvisibility(){
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(this.locator));
    }
    public void waitVisibility(){
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.locator));
    }

    public void waitSelectable(){
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeSelected(this.locator));
    }
    public void waitPresence(){
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(this.locator));
    }
    /** Settea el attributo de la clase controls (que es un array de webelements)
     * y lo devuelve
     * @return  array de WebElements
     */
    public List<WebElement> getControls() {
        this.findControls();
        return controls;
    }
}
