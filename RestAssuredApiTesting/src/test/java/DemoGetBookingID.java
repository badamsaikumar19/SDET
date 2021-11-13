import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DemoGetBookingID {
	
	
	@Test
	 void getbookingid()
	 {
	  //Specify base URI
	  RestAssured.baseURI="https://restful-booker.herokuapp.com/booking";
	  
	  //Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  //Response object
	  Response response=httpRequest.request(Method.GET,"/1");
	  
	  JsonPath jsonpath = response.jsonPath();
	  System.out.println(jsonpath.get("firstname"));
	  
	  System.out.println(jsonpath.get("bookingdates.checkin"));
	  
	  System.out.println(jsonpath.get("bookingdates.checkout"));
	  
	  //print response in console window
	  
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody);
	   
	  //status code validation
	  int statusCode=response.getStatusCode();
	  System.out.println("Status code is: "+statusCode);
	  Assert.assertEquals(statusCode, 200);
	  
	  //status line verification
	  String statusLine=response.getStatusLine();
	  System.out.println("Status line is:"+statusLine);
	  Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	  
	 }

}
