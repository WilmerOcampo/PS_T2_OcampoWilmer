package cucumber;

import cucumber.utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class PostAPI {
    public static final String GET_POST_URL = Constants.BASE_URL + "/public/v2/posts";

    @Step("Get post")
    public void getPosts(Integer id, Integer userId, String title, String body) {
        SerenityRest.given()
                .queryParam("id", id)
                .queryParam("user_id", userId)
                .queryParam("title", title)
                .queryParam("body", body);
    }
}
