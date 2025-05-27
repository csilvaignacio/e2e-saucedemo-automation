package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By userNameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");

    @Override
    public void waitPageLoad() {
        waitPage(userNameInput,this.getClass().getName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(isDisplayed(userNameInput));
        softAssert.assertTrue(isDisplayed(passwordInput));
        softAssert.assertTrue(isDisplayed(loginButton));
        softAssert.assertAll();
    }
}
