import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DemoCreateBooking {
	
	@Test
	void createBooking() {
		
		System.out.print("Create Booking");
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com/";
		  
		 //Request object
		  RequestSpecification httpRequest=RestAssured.given();
		  
		   
		  //Request paylaod sending along with post request
		  JSONObject requestParams=new JSONObject();
		  
		  requestParams.put("firstname","Jim");
		  requestParams.put("lastname","Brown");
		  requestParams.put("totalprice","111");
		  requestParams.put("depositpaid","true");
		  requestParams.put("bookingdates.checkin","2018-01-01");
		  requestParams.put("bookingdates.checkout","2019-01-01");
		  requestParams.put("additionalneeds","Breakfast");
		 
		 
		  
		  httpRequest.header("Content-Type","application/json");
		  
		  httpRequest.body(requestParams.toJSONString()); // attach above data to the request
		  
		  //Response object
		  Response response=httpRequest.request(Method.POST,"/booking");
		    
		  
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
