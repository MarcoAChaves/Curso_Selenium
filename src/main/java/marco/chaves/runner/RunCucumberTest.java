package marco.chaves.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {
                "marco.chaves.steps",
                "marco.chaves.hooks"
        },
        plugin = {"pretty"},
        monochrome = true
)
public class RunCucumberTest {
}
