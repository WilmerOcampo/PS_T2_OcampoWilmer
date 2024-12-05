package cucumber;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "@Test",
        plugin = {"pretty"},
        features = {"src/test/resources/features/post"},
        glue = {"cucumber.post.step"}
)
public class CucumberTestSuite {
}
