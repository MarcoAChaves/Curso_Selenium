package marco.chaves.utils;




import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtils {

    public static String capture(WebDriver driver, String name) {
        try {
            String baseDir = System.getProperty("user.dir");
            String dir = baseDir + "/reports/screenshots/";
            new File(dir).mkdirs();

            String path = dir + name + "_" + System.currentTimeMillis() + ".png";

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(), new File(path).toPath(), StandardCopyOption.REPLACE_EXISTING);

            System.out.println("📸 Screenshot salvo em: " + path);
            return path;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}



