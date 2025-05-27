package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utilities.Logs;
import utilities.WebDriverProvider;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    protected SoftAssert softAssert;
    private static final int defaultTimeOut = 7;
    private final int timeOut;

    public BasePage(int timeOut){
        softAssert = new SoftAssert();
        this.timeOut = timeOut;
    }

    public BasePage(){
        this(defaultTimeOut);
    }

    protected WebDriver getDriver(){
        return new WebDriverProvider().get();
    }

    protected WebDriverWait getWait(){
        return new WebDriverWait(getDriver(),Duration.ofSeconds(timeOut));
    }

    protected void waitPage(By locator, String pageName){
        final var wait = getWait();

        Logs.info("Esperando a que cargue la pagina ",pageName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Logs.info("Ha cargado la pagina correctamente ",pageName);
    }

    protected WebElement findElement(By locator){
        return getDriver().findElement(locator);
    }

    protected List<WebElement> findElements(By locator){
        return getDriver().findElements(locator);
    }

    protected String getText(WebElement element){
        return element.getText();
    }

    protected String getText(By locator){
        return getDriver().findElement(locator).getText();
    }

    protected Boolean isDisplayed(By locator){
        try {
            final var wait = getWait();
            final var element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public abstract void waitPageLoad();

    public abstract void verifyPage();
}
