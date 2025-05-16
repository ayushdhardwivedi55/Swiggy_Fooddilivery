package Swiggy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CartTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000"; // Mock API
    }

    @Test
    public void testAddItemToCart() {
        Map<String, Object> cartItem = new HashMap<>();
        cartItem.put("restaurantId", 1);
        cartItem.put("itemId", 101);
        cartItem.put("quantity", 2);

        Response response = RestAssured.given()
            .contentType(ContentType.JSON)
            .body(cartItem)
            .post("/cart");
        System.out.println("The added item in cart is: "+ response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test(dependsOnMethods = {"testAddItemToCart"})
    public void testGetCartItems() {
        Response response = RestAssured.get("/cart");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("").size() > 0, "Cart is empty");
    }
}

