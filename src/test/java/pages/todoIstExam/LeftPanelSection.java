package pages.todoIstExam;

import controlSelenium.Button;
import controlSelenium.Label;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class LeftPanelSection {
    public Button newProjectButton = new Button(By.xpath("//button[contains(@aria-label,\"adir proyecto\")]"));

    public Button editProject = new Button(By.xpath("//li[contains(@role,\"menuitem\")]//div[text()=\"Editar proyecto\"]"));
    public Button deleteProject = new Button(By.xpath("//div[text()=\"Eliminar proyecto\"]"));
    public List<Label> listaProyectos= new ArrayList<>();
    public  Label projectList = new Label(By.xpath("//ul[@id=\"projects_list\"]/li"));


    public Button opcProjectFindWithName(String projectName){
        Button optionsProject = new Button(By.xpath("//a[contains(@aria-label,'" + projectName +"')]/following-sibling::div/button[contains(@type,'button')]"));
        return optionsProject;
    }
    public boolean projectWithNameExist(String name){
        Label deleteProject = new Label(By.xpath("//span[text()='"+name+ "']"));
        if(deleteProject.isControlDisplayed())
            return true;
        else
            return false;
    }
}
