import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TesteGoogle {

    @Test
    public void teste() {

        //System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
        //System.setProperty("webdriver.Chrome.driver", "C:\\Chromedriver\\chromedriver-win64.exe");
        //System.setProperty("webdriver.gecko.driver", "C:/geckodriver/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        //WebDriver driver = new ChromeDriver();
        //WebDriver driver = new EdgeDriver();
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals("Google", driver.getTitle());
    }
}
