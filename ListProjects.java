package TomTom;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ListProjects {
	
	@Test
	public void listProjects() {
RestAssured.baseURI="https://api.tomtom.com/geofencing/1/projects";
		

		Response response = RestAssured
				.given()
				.log().all()
				.contentType("application/json")
				.queryParams("key", "OSXNWhAdFYDYlaQKlJOnyQOo9vIZoGR8")
				.get()
				
				
				;
		
				System.out.println(response.getStatusCode());
				
				
				response.prettyPrint();
				
				JsonPath jsonPath = response.jsonPath();
				List<String> proID = jsonPath.getList("projects.id");
				System.out.println(proID.get(0));
	}

}
