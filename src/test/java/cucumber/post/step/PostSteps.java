package cucumber.post.step;

import cucumber.PostAPI;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class PostSteps {
    @Steps
    PostAPI postAPI;

    @Then("Debería retornar el status code {int}")
    public void itShouldReturnStatusCode(int statusCode) {
        SerenityRest.then().assertThat().statusCode(statusCode);
    }
}
