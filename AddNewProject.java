package TomTom;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AddNewProject {
	
	@Test
	public void addNewProject() {
		
		
RestAssured.baseURI="https://api.tomtom.com/geofencing/1/projects/project";
		

		Response response = RestAssured
				.given()
				.log().all()
				.contentType("application/json")
				.queryParams("key", "OSXNWhAdFYDYlaQKlJOnyQOo9vIZoGR8")
				.queryParams("adminKey", "BvVATJtb1uyLOKDkxLQLoJc9va0NNdLbFGLEcsYumDwg4W93")
				.body("{\"name\": \"My project4\"}")
				.post()
				
				
				;
		
				System.out.println(response.getStatusCode());
				
				
				response.prettyPrint();
	}

}
