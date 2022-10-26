package pages.todoIstExam;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class MainPage {
    public Button loginButton= new Button(By.xpath("//ul/li/a[contains(text(),'Iniciar ses') and @href=\"/auth/login\"]"));
    public Button registerButton= new Button(By.xpath("//img[@src='/Images/design/pagesignup.png']"));

}
