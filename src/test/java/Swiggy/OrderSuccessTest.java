package Swiggy;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class OrderSuccessTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000"; // Your mock server base URL
    }

    @Test
    public void testCheckoutSuccessMessage() {
        // Prepare order data
        Map<String, Object> orderData = new HashMap<>();
        orderData.put("userId", 1);
        orderData.put("restaurantId", 1);
        orderData.put("items", new int[]{101, 102});
        orderData.put("totalPrice", 200);
        orderData.put("status", "Order Placed");

        // Make the POST request to place the order
        Response response = given()
            .contentType(ContentType.JSON)
            .body(orderData)
            .when()
            .post("/SuccessfullOrders")
            .then()
            .statusCode(201)
            .extract().response();
        System.out.println("The Sucess order API response is: " + response.asPrettyString());
        // Assert the success message or status in the response
        String status = response.jsonPath().getString("status");
        System.out.println("The order status is: " +status); 
        Assert.assertEquals(status, "Order Placed", "Checkout success message did not match");
    }
}

