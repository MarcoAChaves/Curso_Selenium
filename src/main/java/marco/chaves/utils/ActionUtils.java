package marco.chaves.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionUtils {

    private WebDriver driver;

    public ActionUtils(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver getDriver() {
        if (driver == null) {
            throw new RuntimeException("Driver está NULL dentro do ActionUtils");
        }
        return driver;
    }

    public void open(String url, String descricao) {
        getDriver().get(url);
        registrar(descricao);
    }

    public void click(By locator, String descricao) {
        getDriver().findElement(locator).click();
        registrar(descricao);
    }

    public void type(By locator, String texto, String descricao) {
        getDriver().findElement(locator).sendKeys(texto);
        registrar(descricao);
    }

    private void registrar(String descricao) {

        String nomeSeguro = descricao.replaceAll("[^a-zA-Z0-9-_]", "_");

        String shot = ScreenshotUtils.capture(getDriver(), nomeSeguro);

        StepLogger.logStep(descricao, "PASS", shot);
    }
}
