package utilities; // Paquete donde se agrupa esta clase utilitaria

import org.openqa.selenium.WebDriver; // Importamos la interfaz principal de Selenium

public class WebDriverProvider {

    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public void set(WebDriver driver) {
        threadLocal.set(driver);
    }

    public WebDriver get() {
        return threadLocal.get();
    }
}
