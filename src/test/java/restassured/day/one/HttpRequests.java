package restassured.day.one;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
import io.restassured.module.jsv.JsonSchemaValidator.*;

import java.util.HashMap;
import org.testng.annotations.Test;



public class HttpRequests {
	int id;
	
	@Test(priority=1)
	void getUser() {
		
		String endpointurl="https://reqres.in/api/users?page=2";

		
	    given()
	    
	    .when()
	    	.get(endpointurl)
	    	
	    .then()
	    	.statusCode(200)
	    	.body("page", equalTo(2))
	    	.log().all();
		
	}

	@Test(priority=2)
	void createUser() {
		
		String Createuser_endpoint="https://reqres.in/api/users";
		
		HashMap data= new HashMap();
		
		data.put("name", "meghana");
		data.put("job", "trainer");

	    id =	given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post(Createuser_endpoint)
			.jsonPath().getInt("id");
		
			
			
	//	.then()
	//		.statusCode(201)
	//		.log().all();
		
	}
	
	@Test(priority=3, dependsOnMethods= {"createUser"})
	void updateUser() {
		
		String update_endpoint="https://reqres.in/api/users/";
		
		HashMap data= new HashMap();
		
		data.put("name", "mpm");
		data.put("job", "trainer");

		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put(update_endpoint+id)
			
		.then()
			.statusCode(200)
			.log().all();		
	}
	
	@Test(priority=4)
	void deleteUser() {
		
		String deleteEndpoint="https://reqres.in/api/users/";

		
		given()
		
		
		.when()
			.delete(deleteEndpoint+id)
		
		.then()
			.statusCode(204)
			.log().all();
		
	}
}

