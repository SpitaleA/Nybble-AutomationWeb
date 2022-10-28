package cleanTest.todoIstExam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.util.Date;

public class CRUDTodoIstExam extends TestBaseTodoIstExam{

    @RepeatedTest(2)
    public void CRUDTaskTest() throws InterruptedException {
        String projectName = "name " + new Date().getTime();
        String tareaNueva = "task 1";



        //LOGIN
        mainPage.loginButton.click();
        loginPage.login("agustin_spitale@hotmail.com","Nybble12345");


        //CREATE PROJECT
        leftPanel.newProjectButton.click();
        editProjectModal.inputProjectTextBox.setText(projectName);
        editProjectModal.addButton.click();
        numberOfTasksBefore = centerTaskAreaPage.tasks.findControlsQuantity();

        //CREATE TASK
        centerTaskAreaPage.addTaskBtn.click();
        centerTaskAreaPage.setDatebtn.click();
        centerTaskAreaPage.setDateTextBox.setText("24/10/22" + Keys.ENTER);
        centerTaskAreaPage.setPriorityBtn.click();
        centerTaskAreaPage.setPriority("4").click();
        centerTaskAreaPage.titleTaskEditTextBox.setTextnoClear(tareaNueva);
        centerTaskAreaPage.confirmAddTaskbtn.waitClickable();
        centerTaskAreaPage.confirmAddTaskbtn.click();


        Assertions.assertTrue(centerTaskAreaPage.selectTaskByName(tareaNueva).isControlDisplayed(),"ERROR no se creo la task");

        //EDIT TASK
        centerTaskAreaPage.selectTaskByName(tareaNueva).click();
        editTaskModal.comboBoxPriorityBtn.click();
        editTaskModal.setPriority("3").click();
        editTaskModal.setDateBtn.click();
        editTaskModal.setDateTextBox.setText("25/10/22" + Keys.ENTER);
        editTaskModal.closeModalBtn.click();


        Assertions.assertEquals(priority3,centerTaskAreaPage.checkBoxLastTask.getCssAttributeValue("color"),"ERROR edit was not succesful");

        //DELETE TASK
        centerTaskAreaPage.selectTaskByName(tareaNueva).click();
        editTaskModal.moreOptions.click();
        editTaskModal.deleteTaskBtn.waitPresence();
        editTaskModal.deleteTaskBtn.click();
        deleteModal.deleteTaskBtn.click();

        numberOfTasksAfter = centerTaskAreaPage.tasks.findControlsQuantity();

        Assertions.assertEquals(numberOfTasksBefore,numberOfTasksAfter,"ERROR no se borro la tarea");

        Thread.sleep(4000);


    }
}
