package Swiggy;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestaurantsTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000"; // Mock API
    }

    @Test
    public void testGetRestaurants() {
        Response response = RestAssured.get("/restaurants");
        System.out.println("The restaurants are: "+ response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("").size() > 0, "Restaurants list is empty");
    }
}

