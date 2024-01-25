import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {

    public static void main(String[] args) {

        //System.setProperty("webdriver.gecko.driver", "C:/geckodriver/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
    }
}
