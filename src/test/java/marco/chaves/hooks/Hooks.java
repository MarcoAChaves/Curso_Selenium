package marco.chaves.hooks;

import io.cucumber.java.*;
import marco.chaves.core.DriverFactory;
import marco.chaves.utils.ActionUtils;
import marco.chaves.utils.PDFReportUtils;
import marco.chaves.utils.ScreenshotUtils;
import marco.chaves.utils.StepLogger;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private ActionUtils StepContext;

    @Before
    public void setUp() {
        WebDriver driver = DriverFactory.getDriver();

        String basePath = System.getProperty("user.dir");
        String filePath = basePath + "/src/main/resources/componentes.html";

        driver.get("file:///" + filePath.replace("\\", "/"));
    }

    @BeforeStep
    public void beforeStep(Scenario scenario) {
        scenario.getSourceTagNames(); // força inicialização
    }

    @AfterStep
    public void afterStep(Scenario scenario) {

        String screenshotPath = ScreenshotUtils.takeScreenshot(
                scenario.getName()
        );

        StepLogger.setLastScreenshot(screenshotPath);
    }

    @After
    public void tearDown(Scenario scenario) {
        PDFReportUtils.generateReport(scenario.getName());
        DriverFactory.killDriver();
    }
}
