package TomTom;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RegenerateAdminKey {
	
	@Test
	public void regenerateAdminKey() {
		
		
RestAssured.baseURI="https://api.tomtom.com/geofencing/1/regenerateKey";
		
		
		
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

