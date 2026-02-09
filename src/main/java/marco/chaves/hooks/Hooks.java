package marco.chaves.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import marco.chaves.core.DriverFactory;
import marco.chaves.utils.PDFReportUtils;
import marco.chaves.utils.ScreenshotUtils;
import marco.chaves.utils.StepLogger;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    public void setUp() {
        WebDriver driver = DriverFactory.getDriver();

        String basePath = System.getProperty("user.dir");
        String filePath = basePath + "/src/main/resources/componentes.html";

        driver.get("file:///" + filePath.replace("\\", "/"));
    }

    @AfterStep
    public void afterStep(Scenario scenario) {

        String stepName = scenario.getName(); // depois melhoramos isso

        String screenshotPath = ScreenshotUtils.takeScreenshot(stepName);

        StepLogger.logStep(
                scenario.getStatus().name(),
                scenario.isFailed() ? "FAIL" : "PASS",
                screenshotPath
        );
    }

    @After
    public void tearDown(Scenario scenario) {

        PDFReportUtils.generateReport(scenario.getName());
        DriverFactory.killDriver();
    }
}
