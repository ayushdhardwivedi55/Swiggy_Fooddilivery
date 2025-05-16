package Swiggy;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class HomeTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://www.swiggy.com/api/instamart";
    }

    @Test
    public void testInstamartHomeAPI() {
        Response response = RestAssured.given()
            .queryParam("clientId", "INSTAMART-APP")
            .when()
            .get("/home")
            .then()
            .statusCode(200)
            .extract().response();

        String responseBody = response.getBody().asPrettyString();
        System.out.println("Response: " + responseBody);

        assertEquals(response.statusCode(), 200);
        // Add more asserts based on response structure if you want
    }
}

