package TomTom;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RegisterAdminKey {
	
	
	@Test
	public void registerAdminKey() {
		
		RestAssured.baseURI="https://api.tomtom.com/geofencing/1/register";
		
		
		
		Response response = RestAssured
				.given()
				.log().all()
				.contentType("application/json")
				.queryParams("key", "OSXNWhAdFYDYlaQKlJOnyQOo9vIZoGR8")
				.body("{\"secret\": \"secret_key\"}")
				.post()
				
				
				;
		
				System.out.println(response.getStatusCode());
				
				
				response.prettyPrint();
	}

}
