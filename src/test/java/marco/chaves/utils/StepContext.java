package marco.chaves.utils;

public class StepContext {

    private static final ThreadLocal<String> CURRENT_STEP =
            new ThreadLocal<>();

    private StepContext() {
        // evita instância
    }

    public static void setStepName(String stepName) {
        CURRENT_STEP.set(stepName);
    }

    public static String getStepName() {
        return CURRENT_STEP.get();
    }

    public static void clear() {
        CURRENT_STEP.remove();
    }
}
