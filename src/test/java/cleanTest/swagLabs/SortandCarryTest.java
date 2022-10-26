package cleanTest.swagLabs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class SortandCarryTest extends TestBaseSwagLabs{
    @RepeatedTest(2)
    public void sortAndBuyTest() throws InterruptedException {
        String firstItemNameInCart;
        String firstItemNameAfterSortLoHi;

        //LOGIN
        loginPage.userName.setText("standard_user");
        loginPage.pwd.setText("secret_sauce");
        loginPage.loginBtn.click();

        //SELECT ITEM IN MAIN PAGE
        landingPage.lowHighBtn.click();
        firstItemNameAfterSortLoHi = landingPage.firstProductName.getText();
        landingPage.firstProductBtn.click();
        landingPage.goToCartBtn.click();

        //CART
        firstItemNameInCart = cartPage.firstItemName.getText();

        //VERIFICATION
        Assertions.assertEquals(firstItemNameAfterSortLoHi,firstItemNameInCart,"ERROR the product selected its not the same in the cart");

    }
}
