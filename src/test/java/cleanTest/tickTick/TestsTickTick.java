package cleanTest.tickTick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import pages.tickTick.MainLoggedPage;

import java.util.Date;

public class TestsTickTick extends TestBaseTickTick{
    String email = "hola@hola.com";
    String pwd = "123456";
    @Test
    public void register() throws InterruptedException {
        String randomEmail = getAlphaNumericString(5)+"@email.com";
        String pwd = "123456";
        String name = "carlos";
        mainPage.singUpBtn.click();
        registerPage.emailTxtBox.setText(randomEmail);
        registerPage.pwdTxtBox.setText(pwd);
        registerPage.userNameTxtBox.setText(name);
        registerPage.singUpBtn.waitClickable();
        registerPage.singUpBtn.click();

        Assertions.assertTrue(mainLoggedPage.skipIntroBtn.isControlDisplayed(),"ERROR user was not registered");
    }
    @Test
    public void registerAndDelete() throws InterruptedException {
        String randomEmail = getAlphaNumericString(6)+"@email.com";
        String pwd = "123456";
        String name = "carlos";

        //REGISTER
        mainPage.singUpBtn.click();
        registerPage.emailTxtBox.setText(randomEmail);
        registerPage.pwdTxtBox.setText(pwd);
        registerPage.userNameTxtBox.setText(name);
        registerPage.singUpBtn.waitClickable();
        registerPage.singUpBtn.click();

        //DELETE ACCOUNT
        mainLoggedPageLeftPanel.accountBtn.waitClickable();
        mainLoggedPage.skipIntroBtn.click();
        mainLoggedPageLeftPanel.accountBtn.click();
        mainLoggedPageLeftPanel.settingsBtn.click();
        settingsPage.accountAndSecurityBtn.click();
        settingsPage.deleteAccountBtn.click();
        deletingAccountModal.pwdConfirmTxtbox.setText(pwd);
        deletingAccountModal.assureDeleteCheckbox.check();
        deletingAccountModal.secondAssureCheckbox.check();
        deletingAccountModal.confirmBtn.click();

        //LOGING WITH INEXISTENT ACCOUNT
        mainPage.singInBtn.click();
        singInPage.singIn(randomEmail,pwd);
        singInPage.singInBtn.waitClickable();

        Assertions.assertTrue(singInPage.singInBtn.isControlDisplayed(),"ERROR user was not deleted");
    }
    @Test
    public void loginAndLogut(){
        mainPage.singInBtn.click();
        singInPage.singIn(email,pwd);
        mainLoggedPageLeftPanel.accountBtn.click();
        mainLoggedPageLeftPanel.logoutBtn.click();

        Assertions.assertTrue(mainPage.bannerLabel.isControlDisplayed(),"ERROR user was not logged out");
    }
    @Test
    public void createTask() throws InterruptedException {
        String randomNameTask = "task" + new Date().getTime();

        //LOGIN
        mainPage.singInBtn.click();
        singInPage.singIn(email,pwd);

        //CREATE TASK
        mainLoggedPage.addTaskTxtBox.waitPresence();
        mainLoggedPage.addTaskBtn.click();
        mainLoggedPage.addTaskTxtBox.setTextnoClear(randomNameTask + Keys.ENTER);

        Assertions.assertTrue(mainLoggedPage.searchForTaskByName(randomNameTask).isControlDisplayed(),
                "ERROR, task was not created");
    }
    @Test
    public void createNewList() throws InterruptedException {
        String randomNameList = "list" + new Date().getTime();

        //LOGIN
        mainPage.singInBtn.click();
        singInPage.singIn(email,pwd);

        //CREATE LIST
        mainLoggedPage.addTaskTxtBox.waitPresence();
        mainLoggedPageLeftPanel.addNewListBtn.click();
        addListModal.listNameTextBox.setText(randomNameList);
        addListModal.saveListBtn.click();

        addListModal.saveListBtn.waitInvisibility();
        Assertions.assertEquals(randomNameList,mainLoggedPage.actualListName.getText(),"ERROR list was not created");
    }
    @Test
    public void createAHabit() throws InterruptedException {
        String randomNameHabit = "habit" + new Date().getTime();

        //LOGIN
        mainPage.singInBtn.click();
        singInPage.singIn(email,pwd);

        //GO TO HABITS PAGE
        mainLoggedPage.addTaskTxtBox.waitPresence();
        mainLoggedPageLeftPanel.habitsPageBtn.click();

        //CREATE HABIT
        habitsPage.addHabitButton.waitClickable();
        habitsPage.addHabitButton.click();
        habitsPage.habitTitle.setText(randomNameHabit);
        habitsPage.saveHabitBtn.click();
        habitsPage.addHabitButton.waitClickable();

        //DELETE HABIT
        habitsPage.searchHabitsByName(randomNameHabit).makeRightClickAction();
        habitsPage.addHabitButton.waitClickable();
        habitsPage.deleteButtonBtn.click();
        habitsPage.deleteButtonConfirmBtn.waitClickable();
        habitsPage.deleteButtonConfirmBtn.click();

        Assertions.assertFalse(habitsPage.searchHabitsByName(randomNameHabit).isControlDisplayed(),"ERROR habit was not created");
//        Thread.sleep(3000);
    }

    static String getAlphaNumericString(int n) {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }
}
