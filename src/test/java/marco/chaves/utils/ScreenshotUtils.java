package marco.chaves.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static marco.chaves.core.DriverFactory.driver;

public class ScreenshotUtils {

    public static String takeScreenshot(String stepName) {

        try {
            String baseDir = System.getProperty("user.dir");
            String dir = baseDir + "/reports/temp-screenshots/";
            new File(dir).mkdirs();

            String fileName = stepName.replace(" ", "_") + "_" +
                    LocalDateTime.now().format(
                            DateTimeFormatter.ofPattern("HHmmssSSS")
                    ) + ".png";

            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            File dest = new File(dir + fileName);
            FileUtils.copyFile(src, dest);

            return dest.getAbsolutePath();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String capture(WebDriver driver, String stepDesc) {
        return stepDesc;
    }

    public static String captureIfFailedOrAlways() {
        return null;
    }
}
