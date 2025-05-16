package Swiggy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CheckoutTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000"; // Mock API
    }

    @Test
    public void testPlaceOrder() {
        Map<String, Object> order = new HashMap<>();
        order.put("orderId", 1);
        order.put("userId", 1);
        order.put("items", new int[]{101, 102});
        order.put("totalAmount", 200);

        Response response = RestAssured.given()
            .contentType(ContentType.JSON)
            .body(order)
            .post("/orders");
        System.out.println("The items for checkout is: "+ response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test(dependsOnMethods = {"testPlaceOrder"})
    public void testGetOrders() {
        Response response = RestAssured.get("/orders");
        System.out.println("The items after adding in checkout is: "+ response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("").size() > 0, "Orders list is empty");
    }
}

