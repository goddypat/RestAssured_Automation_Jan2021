 package testCase;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Post_or_Create_A_Products<JsonPath> {

@Test
public void read_All_Products() {

String payloadPath = "./src/main/java/data/payload.json";	


//	"name" : "iphone 13.0",
//	"price": "1299"
//    "description" : "The kind of OK product"
//   "catergory_id" : 2
//	
	
//	HashMap <String, String> payload = new HashMap <String, String>();
//	payload.put("name" , "fundamntals for QA People");
//	payload.put("price" , "149");
//	payload.put("description" , "one of the best book");
//	payload.put("catergory_id" , "6");
	
	
Response response =
         given()
              .log().all()
              .baseUri("https://techfios.com/api.prod/api/product")
              .header("content-Type","application/json")
              .body(new File(payloadPath))
         .when()
              .post("/create.php")
         .then()
               .log().all()
               .extract().response();
    
//init statusCode = response.getStatusCode();
//	System.out.println("Status code: "+ statusCode);
//	Assert.assertEquals(statusCode, 200);
//	
//	long actualResponseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
//	long expectedResponseTime = 200(TimeUnit.MILLISECONDS);
//	System.out.println("Response time: " + responseTime);
//	
//	if (actualResponseTime<=200 {
//		System.out.println("Response time is within range. ");
//	} else {
//		System.out.println("Response time is out of range. ");
//	}	
//	
//	
//	String responseBody = response.getBody().asString();
//	System.out.println("Response body: " + responseBody);
//      
//	JsonPath jp = new JsonPath(responseBody);
//	String successMessage = jp.getString("message");
//	System.out.println("successMessage: "+ successMessage);
//	Assert.assertEquals(successMessage, "Product was created");
//    
}
}



