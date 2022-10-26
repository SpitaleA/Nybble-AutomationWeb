package cleanTest.swagLabs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortandCarryTest extends TestBaseSwagLabs{
    @Test
    public void sortAndBuyTest() throws InterruptedException {
        String firstItemNameInCart;
        String firstItemNameAfterSortLoHi;
        loginPage.userName.setText("standard_user");
        loginPage.pwd.setText("secret_sauce");
        loginPage.loginBtn.click();


        landingPage.lowHighBtn.click();
        firstItemNameAfterSortLoHi = landingPage.firstProductName.getText();
        landingPage.firstProductBtn.click();
        landingPage.goToCartBtn.click();
        Thread.sleep(2000);

        firstItemNameInCart = cartPage.firstItemName.getText();

        Assertions.assertEquals("dadd",firstItemNameInCart,"ERROR the product selected its not the same in the cart");

    }
}
