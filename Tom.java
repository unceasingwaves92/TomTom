package stepsTom;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Matchers;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Tom {
	public RequestSpecification requestSpecification;
	public Response response;
	

	
	@And("set the Content type")
	public void setContentType() {
		
		requestSpecification = RestAssured.given().log().all().contentType(ContentType.JSON)
				.queryParams("key", "OSXNWhAdFYDYlaQKlJOnyQOo9vIZoGR8");
	}
	
	@When("place the post request as (.*)$")
	public void createAdminKey(String path) {
		
		File json = new File(path);
		response = requestSpecification
					.body(json)
					.post("/register");
		response.prettyPrint();
		
	}
	

	@Then("verify the status code as 200")
	public void verifyStatusCode() {
		
		if(response.getStatusCode() == 200) {
			System.out.println("The status code is 200");
		} else {
			System.out.println("The status code is not 200");
		}
		
		
	}
	
	@And("verify the Content type as json")
	public void verifyContentType() {
		response.then().assertThat().contentType(ContentType.JSON);
		
	}
	
	
	@And("set the Content type registered admin key")
	public void setContentTypeRegAdminKey() {
		
		requestSpecification = RestAssured.given().log().all().contentType(ContentType.JSON)
				.queryParams("key", "OSXNWhAdFYDYlaQKlJOnyQOo9vIZoGR8")
				.queryParams("adminKey", "Z34DNvr2py8gxQhVODEG4AYLnEkuj570TZ8jrIAE038wsu3Z");
	}
	
	@When("place the post request with admin key (.*)$")
	public void createNewProject(String path) {
		
		File json = new File(path);
		response = requestSpecification
					.body(json)
					.post("/projects/project");
		response.prettyPrint();
		
	}
	
	@Then("verify the status code as 201")
	public void verifyStatusAddNewProject() {
		
		if(response.getStatusCode() == 201) {
			System.out.println("The status code is 201");
		} else {
			System.out.println("The status code is not 201");
		}
		
		
	}
	
	@When("place the get request without body")
	public void getListProjects() {
		

		response = requestSpecification.get("/projects")
				.then()
				.assertThat()
				.body("projects[0].id", Matchers.equalTo("470fc00e-617d-4ebd-b577-2e59396be72a"))
				.extract().response();
		response.prettyPrint();
		
	}
		
	@And("verify the response")
	public void getVerifyResponse() {
		

		JsonPath jsonPath = response.jsonPath();
		List<String> proID = jsonPath.getList("projects.id");
		System.out.println(proID.get(0));
		
	}

	@And("regenerate admin key (.*)$")
	public void createRegenerateAdminKey(String path) {
		
		File json = new File(path);
		response = requestSpecification
					.body(json)
					.post("/regenerateKey");
		response.prettyPrint();
		
	}
	
	@And("set the Content type regenerate admin key")
	public void addNewFence() {
		
		requestSpecification = RestAssured.given().log().all().contentType(ContentType.JSON)
				.queryParams("key", "OSXNWhAdFYDYlaQKlJOnyQOo9vIZoGR8")
				.queryParams("adminKey", "7Xo6zI5gsXtixBi2xysn5VTRg9bduNBwEOBFTPiwbw0qCQgu");
	}
	
	@When("place the post request with regenerate key (.*)$")
	public void addNewFenceKey(String path) {
		
		File json = new File(path);
		response = requestSpecification
					.body(json)
					.post("/projects/470fc00e-617d-4ebd-b577-2e59396be72a/fence");
		response.prettyPrint();
		
	}
	
	@When("place the get fence transitions without body")
	public void getFenceTransitions() {
		

		response = requestSpecification.get("/projects/470fc00e-617d-4ebd-b577-2e59396be72a/fences")
				.then()
				.assertThat()
				.body("fences[0].id", Matchers.equalTo("2f601634-4821-4845-8b58-2cb046b90763"))
				.extract().response();
		response.prettyPrint();
		
	}
		
	@And("verify the response of transitions")
	public void getVerifyResponseTransitions() {
		

		JsonPath jsonPath = response.jsonPath();
		List<String> fenID = jsonPath.getList("fences.id");
		System.out.println(fenID.get(0));
		
	}


	
}


