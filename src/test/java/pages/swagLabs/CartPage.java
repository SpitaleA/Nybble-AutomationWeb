package pages.swagLabs;

import controlSelenium.Label;
import org.openqa.selenium.By;

public class CartPage {
    public Label firstItemName = new Label(By.xpath("//div[@class=\"cart_list\"]//div[@class=\"inventory_item_name\"]"));
    public Label firstItemPrice = new Label(By.xpath("//div[@class=\"cart_list\"]//div[@class=\"inventory_item_price\"]"));
}
