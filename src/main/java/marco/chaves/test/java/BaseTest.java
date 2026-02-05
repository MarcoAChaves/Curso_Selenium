package marco.chaves.test.java;

import marco.chaves.utils.PDFReportUtils;
import marco.chaves.utils.StepLogger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected WebDriver driver;

    @Before
    public void setup() {
        StepLogger.clear();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("file:///C:/WorkSpace/CursoSelenium/src/main/resources/componentes.html");
    }


    @After
    public void tearDown() {

        // 1️⃣ GERA O PDF PRIMEIRO (com driver ainda vivo)
        PDFReportUtils.generateReport(this.getClass().getSimpleName());

        // 2️⃣ DEPOIS fecha o navegador
        if (driver != null) {
            driver.quit();
        }
    }

}
