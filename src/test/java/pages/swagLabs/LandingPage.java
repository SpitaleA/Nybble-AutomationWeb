package pages.swagLabs;

import controlSelenium.Button;
import controlSelenium.Label;
import org.openqa.selenium.By;

public class LandingPage {
    public Button lowHighBtn = new Button(By.xpath("//select[@class=\"product_sort_container\"]//option[@value=\"lohi\"]"));
    public Label firstProductName = new Label(By.xpath("//div[@id=\"inventory_container\"]//div[@class=\"inventory_item_name\"]"));
    public Label firstProductPrice = new Label(By.xpath("//div[@id=\"inventory_container\"]//div[@class=\"inventory_item_price\"]"));
    public Button firstProductBtn = new Button(By.xpath("//div[@id=\"inventory_container\"]//button[@class]"));
    public Button goToCartBtn = new Button(By.xpath("//div[@id=\"shopping_cart_container\"]/a"));

}
