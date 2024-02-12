package marco.chaves.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {

    @Test
    public void teste() {

        //System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
        //System.setProperty("webdriver.Chrome.driver", "C:\\Chromedriver\\chrome-win64\\chrome.exe");
        System.setProperty("webdriver.gecko.driver", "C:/geckodriver/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        // WebDriver driver = new ChromeDriver();
        //WebDriver driver = new EdgeDriver();
        driver.manage().window().setPosition(new Point(100, 100));
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals("Google", driver.getTitle());
        driver.quit();
    }
}
