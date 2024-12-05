package cucumber.post.step;

import cucumber.PostAPI;
import cucumber.utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.*;

public class GetPostSteps {

    @Steps
    PostAPI postAPI;

    @Given("Post sin parámetros")
    public void postsWithoutParameters() {
        SerenityRest.given();
    }

    @When("Enviar solicitud del post")
    public void sendPostRequest() {
        SerenityRest.when().get(PostAPI.GET_POST_URL);
    }

    @And("Validar post con JSON schema")
    public void validatePostJsonSchema() {
        File jsonSchema = new File(Constants.JSON_SCHEMA + "/ResponsePostSchemaValid.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post con id {string}")
    public void postWithId(String id) {
        int pId = Integer.parseInt(id);
        postAPI.getPosts(pId, null, "", "");
    }

    @And("Validar el id del post sea {string}")
    public void validatePostId(String id) {
        int pId = Integer.parseInt(id);
        SerenityRest.then()
                .assertThat()
                .body("id", everyItem(equalTo(pId)));
    }

    @Given("Post con user_id {string}")
    public void postWithUserId(String userId) {
        int uId = Integer.parseInt(userId);
        postAPI.getPosts(null, uId, "", "");
    }

    @And("Validar el user_id del post sea {string}")
    public void validatePostUserId(String userId) {
        int uId = Integer.parseInt(userId);
        SerenityRest.then()
                .assertThat()
                .body("user_id", everyItem(equalTo(uId)));
    }

    @Given("Post con title {string}")
    public void postWithTitle(String title) {
        postAPI.getPosts(null, null, title, "");
    }

    @And("Validar el title del post sea {string}")
    public void validatePostTitle(String title) {
        SerenityRest.then()
                .assertThat()
                .body("title", everyItem(hasToString(title)));
    }

    @Given("Post con body {string}")
    public void postWithBodyContains(String body) {
        postAPI.getPosts(null, null, body, "");
    }

    @And("Validar el body del post contenga {string}")
    public void validatePostBodyContains(String body) {
        SerenityRest.then()
                .assertThat()
                .body("body", everyItem(containsStringIgnoringCase(body)));
    }

}
