package Swiggy;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MenuTests {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000"; // Mock API
    }

    @Test
    public void testGetMenuByRestaurant() {
        int restaurantId = 1;
        Response response = RestAssured.get("/menus?restaurantId=" + restaurantId);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("[0].items").size() > 0, "Menu items empty");
    }
    @Test
    public void NottestGetMenuByRestaurant() {
        int restaurantId = 10;
        Response response = RestAssured.get("/menus?restaurantId=" + restaurantId);

        Assert.assertEquals(response.getStatusCode(), 200);
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody == null || responseBody.trim().isEmpty() || responseBody.equals("[]"),
                "Expected empty or not found in the MOCK API");
    }
}

