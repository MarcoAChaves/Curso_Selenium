package marco.chaves.test.java;

import marco.chaves.utils.ScreenshotUtils;
import marco.chaves.utils.StepLogger;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {


    @Test
    public void testeEvidencia() {
        driver.get("https://google.com");
        String shot = ScreenshotUtils.capture(driver, "Google");
        StepLogger.logStep("Abriu Google", "PASS", shot);
    }
}

