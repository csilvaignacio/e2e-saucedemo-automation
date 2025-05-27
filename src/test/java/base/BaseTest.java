package base;

import java.lang.reflect.Method;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Logs;
import utilities.WebDriverProvider;


public class BaseTest {

    protected final String smoke = "regression";
    protected final String regression = "regression";
    protected WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void masterSetUp(Method method) {
        Logs.debug("Inicializando Driver");
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");

        driver = new ChromeDriver(options);

        Logs.debug("Maximizando la pantalla");
        driver.manage().window().maximize();

        Logs.debug("Borrando las cookies");
        driver.manage().deleteAllCookies();

        new WebDriverProvider().set(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void masterTearDown(ITestResult result) {
        Logs.debug("Cerrando Driver");
        //driver.quit();

        // Se registra el resultado del test
        String testName = result.getMethod().getMethodName();
        if (result.getStatus() == ITestResult.SUCCESS) {
            Logs.info("Test PASADO: " + testName);
        } else if (result.getStatus() == ITestResult.FAILURE) {
            Logs.error("Test FALLADO: " + testName);
        } else if (result.getStatus() == ITestResult.SKIP) {
            Logs.warning("Test OMITIDO: " + testName);
        }
    }
}
