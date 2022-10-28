package cleanTest.demoQA;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test1 extends TestBase{

    @Test
    public void test1() throws InterruptedException {
        selectablePage.lastItemList.click();

        selectablePage.lastItemList.waitUntilElementHasHtmlAttribute("class","active");
        selectablePage.lastItemList.hasAttributeValue("class","active");
        System.out.println(selectablePage.lastItemList.hasAttributeValue("class","active"));
        Thread.sleep(5000);
//        System.out.println(selectablePage.lastItemList.hasCssAttribute("class","active"));
//        Assertions.assertTrue(selectablePage.lastItemList.hasCssAttribute("class","active"));
    }
}
