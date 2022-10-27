package pages.juiceShop;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class MainPage {
    public Button accountBtn = new Button(By.id("navbarAccount"));
    public Button loginBtn = new Button(By.id("navbarLoginButton"));
    public Button dismissPopUpBtn = new Button(By.xpath("//Button[@color=\"primary\"]//span[text()=\"Dismiss\"]"));
    public Button logOutBtn = new Button(By.id("navbarLogoutButton"));
    public Button logoLinkBtn = new Button(By.xpath("//button[@routerlink=\"/search\"]"));
    public Button cartBtn = new Button(By.xpath("//button[@routerlink=\"/basket\"]"));
}
