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
        String randomEmail = "email" + new Date().getTime()+"@email.com";
        String pwd = "123456";
        String name = "carlos";
        mainPage.singUpBtn.click();
        registerPage.emailTxtBox.setText(randomEmail);
        registerPage.pwdTxtBox.setText(pwd);
        registerPage.userNameTxtBox.setText(name);
        registerPage.singUpBtn.click();

        Assertions.assertTrue(mainLoggedPage.skipIntroBtn.isControlDisplayed(),"ERROR user was not registered");
    }
    @Test
    public void login(){
        mainPage.singInBtn.click();
        singInPage.singIn(email,pwd);

        Assertions.assertTrue(mainLoggedPage.actualListName.isControlDisplayed(),"ERROR user was not logged in");
    }
    @Test
    public void createTask() throws InterruptedException {
        String randomNameTask = "task" + new Date().getTime();
        mainPage.singInBtn.click();
        singInPage.singIn(email,pwd);
        mainLoggedPage.addTaskTxtBox.waitPresence();
        mainLoggedPage.addTaskBtn.click();
        mainLoggedPage.addTaskTxtBox.setTextnoClear(randomNameTask + Keys.ENTER);

        Assertions.assertTrue(mainLoggedPage.searchForTaskByName(randomNameTask).isControlDisplayed(),
                "ERROR, task was not created");

        Thread.sleep(2000);

    }
    @Test
    public void createNewList() throws InterruptedException {
        String randomNameList = "list" + new Date().getTime();
        mainPage.singInBtn.click();
        singInPage.singIn(email,pwd);
        mainLoggedPage.addTaskTxtBox.waitPresence();
        mainLoggedPageLeftPanel.addNewListBtn.click();
        addListModal.listNameTextBox.setText(randomNameList);
        addListModal.saveListBtn.click();
//        Thread.sleep(3000);
        addListModal.saveListBtn.waitInvisibility();
        Assertions.assertEquals(randomNameList,mainLoggedPage.actualListName.getText(),"ERROR list was not created");
    }
    @Test
    public void CRUDTask() throws InterruptedException {
        String randomNameTask = "task" + new Date().getTime();
        mainPage.singInBtn.click();
        singInPage.singIn(email,pwd);
        mainLoggedPage.addTaskTxtBox.waitPresence();
        mainLoggedPage.addTaskBtn.click();
        mainLoggedPage.addTaskTxtBox.setTextnoClear(randomNameTask + Keys.ENTER);

        //EDIT
        mainLoggedPage.searchForTaskByName("task1666971737152").click();
        mainLoggedPage.taskNameTitleDetail.setTextnoClear("hola 22");
//        mainLoggedPage.searchForTaskByName("task1666971737152").setTextnoClear("nuevo nombre");
        Thread.sleep(2000);
    }
    @Test
    public void createAHabit(){

    }
}
