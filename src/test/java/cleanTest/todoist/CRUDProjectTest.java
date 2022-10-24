package cleanTest.todoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Date;

public class CRUDProjectTest extends TestBaseTodoIst{
    @Test
    public void CRUDProject() throws InterruptedException {
        String projectName = "name " + new Date().getTime();
        String projectNameUpdate = "name update " + new Date().getTime();
        Integer projectsQuantity;


        //LOGIN
        mainPage.loginButton.click();
        loginPage.login("agustin_spitale@hotmail.com","Nybble12345");

        Assertions.assertTrue(leftPanel.newProjectButton.isControlDisplayed(),"ERROR no se logeo");



        leftPanel.projectList.findControls();
        projectsQuantity = leftPanel.projectList.getControls().size();



        //CREATE PROJECT
        leftPanel.newProjectButton.waitClickable();
        leftPanel.newProjectButton.click();
        editProjectModal.inputProjectTextBox.setText(projectName);
        editProjectModal.addButton.click();

        Assertions.assertTrue(leftPanel.projectWithNameExist(projectName),"ERROR no se creo el proyecto");

        //EDIT PROJECT
        leftPanel.opcProjectFindWithName(projectName).click();
        leftPanel.editProject.click();
        editProjectModal.inputProjectTextBox.setText(projectNameUpdate);
        editProjectModal.addButton.click();

        Assertions.assertTrue(leftPanel.projectWithNameExist(projectNameUpdate),"ERROR no se edito el proyecto");

        //DELETE PROJECT
        leftPanel.opcProjectFindWithName(projectNameUpdate).click();
        leftPanel.deleteProject.click();
        deleteProjectModal.deleteButton.click();

//        Assertions.assertFalse(leftPanel.projectWithNameExist(projectNameUpdate),"ERROR no se elimino el proyecto");
        leftPanel.projectList.findControls();
        Assertions.assertTrue(projectsQuantity.equals(leftPanel.projectList.getControls().size()));

    };
}
