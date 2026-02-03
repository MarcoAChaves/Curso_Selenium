package marco.chaves.utils;

import java.util.ArrayList;
import java.util.List;

public class StepLogger {
    private static List<String[]> steps = new ArrayList<>();

    public static void logStep(String description, String status, String screenshotPath) {
        steps.add(new String[]{description, status, screenshotPath});
    }

    public static List<String[]> getSteps() {
        return steps;
    }

    public static void clearSteps() {
        steps.clear();
    }
}


