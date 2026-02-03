package marco.chaves.test.java;


import marco.chaves.utils.ActionUtils;
import marco.chaves.utils.StepLogger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import marco.chaves.utils.PDFReportUtils;

import java.time.Duration;

import static marco.chaves.utils.PDFReportUtils.*;

public class BaseTest {

    protected WebDriver driver;
    protected ActionUtils acao;

    @Rule
    public TestName testName = new TestName();

    public void setup() {
        driver = new ChromeDriver();   // ← AQUI o driver nasce
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {

        String testName = this.getClass().getSimpleName(); // nome da classe de teste

        PDFReportUtils.generateReport(testName);

        if (driver != null) {
            driver.quit();
            System.out.println("Driver finalizado");
        }
    }
}

