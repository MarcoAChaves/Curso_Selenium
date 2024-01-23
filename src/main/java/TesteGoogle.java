import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {

    public static void main(String[] args) {

        //System.setProperty("webdriver.gecko.driver", "C:\\WorkSpace\\Programas\\geckodriver-v0.34.0-win-aarch64.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://google.com");
        System.out.println(driver.getTitle());
    }
}
