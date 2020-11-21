package TomTom;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AddNewFence {
	

	@DataProvider(name = "fetchData")
	public String[] getData() {
		
		String[] data = new String[1];
		data[0] = "./data/tomtom.json";
		
		return data;
	}
	
	
	
	@Test(dataProvider = "fetchData")
	public void addNewFence(String filePath) {
		
		RestAssured.baseURI="https://api.tomtom.com/geofencing/1/projects/470fc00e-617d-4ebd-b577-2e59396be72a/fence";
		
		File file = new File(filePath);
		
		Response response = RestAssured
				.given()
				.log().all()
				.contentType("application/json")
				.queryParams("key", "OSXNWhAdFYDYlaQKlJOnyQOo9vIZoGR8")
				.queryParams("adminKey", "Z34DNvr2py8gxQhVODEG4AYLnEkuj570TZ8jrIAE038wsu3Z")
				.body(file)
				.post()
				
				
				;
		
		System.out.println(response.getStatusCode());
		
		
		response.prettyPrint();
		
	}

}
