package marco.chaves.utils;

import java.util.ArrayList;
import java.util.List;

public class StepLogger {

    private static final List<Step> steps = new ArrayList<>();

    public static class Step {
        private String description;
        private String status;
        private String screenshotPath;

        public Step(String description, String status, String screenshotPath) {
            this.description = description;
            this.status = status;
            this.screenshotPath = screenshotPath;
        }

        public String getDescription() { return description; }
        public String getStatus() { return status; }
        public String getScreenshotPath() { return screenshotPath; }
    }

    public static void logStep(String description, String status, String screenshotPath) {
        steps.add(new Step(description, status, screenshotPath));
    }

    public static List<Step> getSteps() {
        return steps;
    }

    public static void clear() {
        steps.clear();
    }
}
