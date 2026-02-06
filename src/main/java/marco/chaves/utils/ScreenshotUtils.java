package marco.chaves.utils;


import marco.chaves.core.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static marco.chaves.core.DriverFactory.driver;


public class ScreenshotUtils {

        public static String takeScreenshot(String name) {

            WebDriver driver = DriverFactory.getDriver();

            try {
                File src = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

                String baseDir = System.getProperty("user.dir");
                String dir = baseDir + "/reports/screenshots/";
                new File(dir).mkdirs();

                String fileName = name.replace(" ", "_")
                        + "_" + System.currentTimeMillis() + ".png";

                File dest = new File(dir + fileName);
                FileUtils.copyFile(src, dest);

                System.out.println("📸 Screenshot salvo em: " + dest.getAbsolutePath());
                return dest.getAbsolutePath();

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

    public static String capture(WebDriver driver, String stepDesc) {
        return stepDesc;
    }
}



