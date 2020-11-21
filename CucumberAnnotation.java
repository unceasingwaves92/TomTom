package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;

public class CucumberAnnotation {
	
	@Before
	public void PreStep() {
		
		RestAssured.baseURI ="https://api.tomtom.com/geofencing/1/";
		
		//RestAssured.baseURI ="https://dev75045.service-now.com/api/now/table/change_request";
		//RestAssured.authentication=RestAssured.basic("admin", "UNceasing@1986");
	}
	
	@After
	public void PostStep(Scenario sc) {
		
		System.out.println(sc.getName() +" : " +sc.getStatus());
	}

}
