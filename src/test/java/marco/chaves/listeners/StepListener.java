package marco.chaves.listeners;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;

import marco.chaves.utils.StepLogger;

public class StepListener implements ConcurrentEventListener {

    private String currentStepText;

    @Override
    public void setEventPublisher(EventPublisher publisher) {

        publisher.registerHandlerFor(TestStepStarted.class, this::onStepStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::onStepFinished);
    }

    private void onStepStarted(TestStepStarted event) {

        if (event.getTestStep() instanceof PickleStepTestStep step) {
            currentStepText = step.getStep().getText();
        }
    }

    private void onStepFinished(TestStepFinished event) {

        if (!(event.getTestStep() instanceof PickleStepTestStep)) {
            return;
        }

        String status =
                event.getResult().getStatus() == Status.PASSED ? "PASS" : "FAIL";

        // ⚠️ screenshotPath será preenchido pelo Hooks
        StepLogger.logStep(
                currentStepText,
                status,
                StepLogger.getLastScreenshot()
        );
    }
}
