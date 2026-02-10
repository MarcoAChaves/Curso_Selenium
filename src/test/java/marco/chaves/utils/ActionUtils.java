package marco.chaves.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ActionUtils {

    private static WebElement waitElement(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /* =========================
       TYPE
       ========================= */
    public static void type(WebDriver driver, By by, String text, String stepDesc) {
        try {
            WebElement element = waitElement(driver, by);
            element.click();
            element.clear();
            element.sendKeys(text);

            String shot = ScreenshotUtils.capture(driver, stepDesc);
            StepLogger.logStep(stepDesc, "PASS", shot);

        } catch (Exception e) {
            String shot = ScreenshotUtils.capture(driver, "ERRO_" + stepDesc);
            StepLogger.logStep(stepDesc, "FAIL", shot);
            throw e;
        }
    }

    /* =========================
       CLICK
       ========================= */
    public static void click(WebDriver driver, By by, String stepDesc) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
            element.click();

            String shot = ScreenshotUtils.capture(driver, stepDesc);
            StepLogger.logStep(stepDesc, "PASS", shot);

        } catch (Exception e) {
            String shot = ScreenshotUtils.capture(driver, "ERRO_" + stepDesc);
            StepLogger.logStep(stepDesc, "FAIL", shot);
            throw e;
        }
    }

    /* =========================
       GET VALUE (inputs)
       ========================= */
    public static String getValue(WebDriver driver, By by, String stepDesc) {
        try {
            WebElement element = waitElement(driver, by);
            String value = element.getAttribute("value");

            String shot = ScreenshotUtils.capture(driver, stepDesc);
            StepLogger.logStep(stepDesc + " -> " + value, "PASS", shot);

            return value;

        } catch (Exception e) {
            String shot = ScreenshotUtils.capture(driver, "ERRO_" + stepDesc);
            StepLogger.logStep(stepDesc, "FAIL", shot);
            throw e;
        }
    }

    /* =========================
       IS SELECTED (checkbox / radio)
       ========================= */
    public static boolean isSelected(WebDriver driver, By by, String stepDesc) {
        try {
            WebElement element = waitElement(driver, by);
            boolean selected = element.isSelected();

            String shot = ScreenshotUtils.capture(driver, stepDesc);
            StepLogger.logStep(stepDesc + " -> " + selected, "PASS", shot);

            return selected;

        } catch (Exception e) {
            String shot = ScreenshotUtils.capture(driver, "ERRO_" + stepDesc);
            StepLogger.logStep(stepDesc, "FAIL", shot);
            throw e;
        }
    }

    /* =========================
       SELECT BY VISIBLE TEXT
       ========================= */
    public static void selectByVisibleText(WebDriver driver, By by, String texto, String stepDesc) {
        try {
            WebElement element = waitElement(driver, by);
            Select select = new Select(element);
            select.selectByVisibleText(texto);

            String shot = ScreenshotUtils.capture(driver, stepDesc);
            StepLogger.logStep(stepDesc, "PASS", shot);

        } catch (Exception e) {
            String shot = ScreenshotUtils.capture(driver, "ERRO_" + stepDesc);
            StepLogger.logStep(stepDesc, "FAIL", shot);
            throw e;
        }
    }

    /* =========================
       GET SELECTED OPTION
       ========================= */
    public static String getSelectedOption(WebDriver driver, By by, String stepDesc) {
        try {
            WebElement element = waitElement(driver, by);
            Select select = new Select(element);
            String texto = select.getFirstSelectedOption().getText();

            String shot = ScreenshotUtils.capture(driver, stepDesc);
            StepLogger.logStep(stepDesc + " -> " + texto, "PASS", shot);

            return texto;

        } catch (Exception e) {
            String shot = ScreenshotUtils.capture(driver, "ERRO_" + stepDesc);
            StepLogger.logStep(stepDesc, "FAIL", shot);
            throw e;
        }
    }

    public static List<String> getAllOptionsFromCombo(WebDriver driver, By by, String stepDesc) {
        try {
            WebElement element = waitElement(driver, by);
            Select select = new Select(element);

            List<String> optionsText = new ArrayList<>();

            for (WebElement option : select.getOptions()) {
                optionsText.add(option.getText());
            }

            String shot = ScreenshotUtils.capture(driver, stepDesc);
            StepLogger.logStep(stepDesc + " -> " + optionsText, "PASS", shot);

            return optionsText;

        } catch (Exception e) {
            String shot = ScreenshotUtils.capture(driver, "ERRO_" + stepDesc);
            StepLogger.logStep(stepDesc, "FAIL", shot);
            throw e;
        }
    }

    private static final ThreadLocal<String> stepName = new ThreadLocal<>();

    public static void setStepName(String name) {
        stepName.set(name);
    }

    public static String getStepName() {
        return stepName.get();
    }

    public static void clear() {
        stepName.remove();
    }
}



