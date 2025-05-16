package Swiggy;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.lessThan;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class LoginTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000"; // Your running mock JSON server
    }

    @Test
    public void ValidtestUserLogin() {
        Response response = given()
            .param("email", "test@swiggy.com")
            .param("password", "1234")
            .when()
            .get("/users")
            .then()
            .statusCode(200)
            .extract().response();
        
        System.out.println("The users are: " + response.asPrettyString());
        // Verify user exists and password matches
        List<Map<String, String>> users = response.jsonPath().getList("");
        boolean isUserFound = users.stream()
            .anyMatch(user -> "test@swiggy.com".equals(user.get("email")) &&
                              "1234".equals(user.get("password")));

        Assert.assertTrue(isUserFound, "User not found or invalid credentials");
    }
    @Test
    public void InValidtestUserLogin() {
        Response response = given()
            .param("email", "test@swigg.com")
            .param("password", "1234")
            .when()
            .get("/users")
            .then()
            .statusCode(200)
            .extract().response();
        
        System.out.println("The users are: " + response.asPrettyString());
        // Verify user exists and password matches
        List<Map<String, String>> users = response.jsonPath().getList("");
        boolean isUserFound = users.stream()
            .anyMatch(user -> "test@swiggy.com".equals(user.get("email")) &&
                              "1234".equals(user.get("password")));

        Assert.assertFalse(isUserFound, "User not found or invalid credentials");
    }
}
