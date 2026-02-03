package marco.chaves.utils;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;

public class ScreenshotUtils {

    public static String capture(WebDriver driver, String stepName) {
        try {

            String dir = System.getProperty("user.dir") + "/reports/screenshots/";
            new File(dir).mkdirs();

            String safeName = stepName.replaceAll("[^a-zA-Z0-9-_]", "_");
            String path = dir + System.currentTimeMillis() + "_" + safeName + ".png";

            // 🔥 captura em BASE64
            String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            byte[] decoded = Base64.getDecoder().decode(base64);

            FileOutputStream fos = new FileOutputStream(path);
            fos.write(decoded);
            fos.close();

            File f = new File(path);
            if (f.exists() && f.length() > 0) {
                System.out.println("✅ Screenshot REAL salvo: " + path);
                return f.getAbsolutePath();
            } else {
                System.out.println("❌ Screenshot não foi gravado no disco.");
                return null;
            }

        } catch (Exception e) {
            System.out.println("❌ ERRO ao tirar screenshot:");
            e.printStackTrace();
            return null;
        }
    }
}


