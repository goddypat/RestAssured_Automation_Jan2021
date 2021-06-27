package testCase;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Get_or_Read_A_Products<JsonPath> {

@Test
public void read_A_Products() {
	
SoftAssert softAssert = new SoftAssert();

//  https://techfios.com/api.prod/api/product
//  /read.php
Response response = 
         given()
              .baseUri("https://techfios.com/api.prod/api/product")
              .header("content-Type","application/json; charset=UTF-8")
              .queryParam("id", "1685")
         .when()
              .get("/read.php")
         .then().extract().response();
    
int statusCode = response.getStatusCode();
	System.out.println("Status code: "+ statusCode);
//	Hard Assert
	Assert.assertEquals(statusCode,  200);

	
	long actualResponseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
//	long expectedResponseTime = 200(TimeUnit.MILLISECONDS);
	System.out.println("ActualResponseTime: " + actualResponseTime);
	
	if (actualResponseTime<=200) {
		System.out.println("Response time is within range. ");
	} else {
		System.out.println("Response time is out of range. ");
	}	
	
	
	String responseBody = response.getBody().asString();
	System.out.println("Response body: " + responseBody);
      
//	JsonPath js = new JsonPath(responseBody);
	
//	String productName = js.getString("Name");
//	System.out.println("productName: "+ productName);
//	Assert.assertEquals(productName, "iPhone13.");

}
}



