package marco.chaves.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {
                "marco.chaves.steps",
                "marco.chaves.hooks"
        },
        plugin = {
                "pretty",
                "marco.chaves.listeners.StepListener"
        },
        tags = "@smoke"
)
public class RunCucumberTest {
}
