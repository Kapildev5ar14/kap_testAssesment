import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FeedbackTests extends BaseTest {

    @Test
    public void testCreateFeedback() {
        String feedbackPayload = "{ \"comment\": \"Great service!\", \"rating\": \"Very Happy\", \"email\": \"customer@example.com\" }";

        given()
                .contentType(ContentType.JSON)
                .body(feedbackPayload)
                .when()
                .post("/feedback")
                .then()
                .statusCode(201)
                .body("message", equalTo("Successfully received feedback"));
    }

    @Test
    public void testGetFeedbackById() {
        String feedbackId = "12345"; // Use a valid feedback ID for the test

        given()
                .pathParam("feedbackId", feedbackId)
                .when()
                .get("/{feedbackId}")
                .then()
                .statusCode(200)
                .body("id", equalTo(feedbackId));
    }

    @Test
    public void testFeedbackResponseSchema() {
        String feedbackId = "12345"; // Use a valid feedback ID for the test

        given()
                .pathParam("feedbackId", feedbackId)
                .when()
                .get("/{feedbackId}")
                .then()
                .statusCode(200)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("feedbackResponseSchema.json"));
    }

    private Matcher<?> matchesJsonSchemaInClasspath(String s) {
        return null;
    }
}

