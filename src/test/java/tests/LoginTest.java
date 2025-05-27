package tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {
    private LoginPage loginPage = new LoginPage();

    @Test
    @Description("Verificando pagina")
    public void case01(){
        loginPage.verifyPage();
    }


    @Test
    @Description("Verificando pagina")
    public void case02(){
        loginPage.verifyPage();
    }
}





