package TomTom;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetFenceTransitions {
	
	
	@Test
	public void getFenceTransitions() {
		
		RestAssured.baseURI="https://api.tomtom.com/geofencing/1/projects/470fc00e-617d-4ebd-b577-2e59396be72a/fences";
		
		Response response = RestAssured
				.given()
				.log().all()
				.contentType("application/json")
				.queryParams("key", "OSXNWhAdFYDYlaQKlJOnyQOo9vIZoGR8")
				.get()
				.then()
				.assertThat()
				.body("fences[0].id", Matchers.equalTo("2f601634-4821-4845-8b58-2cb046b90763"))
				.statusCode(200)
				.extract().response()
				
				
				
				;
		
		System.out.println(response.getStatusCode());
		
		
		response.prettyPrint();
		
		JsonPath jsonPath = response.jsonPath();
		List<String> fenID = jsonPath.getList("fences.id");
		System.out.println(fenID.get(0));
		
		
	}

}
