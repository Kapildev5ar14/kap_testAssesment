**This test automation framework contains classes as follows:-**

The **BaseTest class** is made to make it easier to set up HTTP requests in a Java SpringBoot application's test suite using Rest-Assured. It uses the @BeforeAll annotation to perform the setup() function prior to the execution of any test methods. The base URI for HTTP requests is set to http://localhost:8080 inside setup(), guaranteeing that all tests of API endpoints begin from this shared foundation. By doing away with the need for redundant base URI specifications across test methods, this technique improves code readability and maintenance effectiveness.

The tests in this **FeedbackTests class** use Rest-Assured to confirm that the REST API of a Java SpringBoot application complies with the given OpenAPI specification (openapi-spec.yaml) and is functioning. It consists of the three unique test procedures listed below:
1. A POST request is sent by the **testCreateFeedback() method** to confirm the establishment of a new feedback entry.
2. Using a GET request to feedbackId, the **testGetFeedbackById() method** verifies the retrieval of feedback by its ID. It verifies that the response body has an ID that matches the supplied feedbackId and that the API returns a status code of 200 (OK).
3. The purpose of the **testFeedbackResponseSchema() method** is to verify the feedbackID response.
