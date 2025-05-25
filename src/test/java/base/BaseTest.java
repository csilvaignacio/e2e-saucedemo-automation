package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    protected WebDriver driver;
    protected SoftAssert soft;

    public void setUp(){
        soft = new SoftAssert();
        driver = new EdgeDriver();
    }

    public void tearDown(){
        driver.quit();
    }
}
