package restassured.day.one;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator.*;
import io.restassured.response.Response;


public class ParsingJSONResponseData {
	//reqrestAPI
//	@Test
	void testJsonResponse() {
		given()
		
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.body("data[1].id",equalTo(8));
	}
	
	//@Test
	void testJsonResponse2() {
		given()
		
		
		.when()
			.get("http://localhost:3000/books")
		
		.then()
			.statusCode(200)
			.body("[1].id",equalTo(310));
	}
	
	//@Test
	void testJsonResponse3() {
		
		Response resp= 
				given()
					.pathParam("myparam", "books")
				
				.when()
					.get("http://localhost:3000/{myparam}");
		
		Assert.assertEquals(resp.getStatusCode(), 200);
		
		//Assert.assertEquals(resp.getContentType(), "application/json; charset=utf-");
		int id=resp.jsonPath().get("[0].id");
		
		System.out.println("The first id is "+id);
		
			}
	
	
	@Test
	void testReadAllBooks() {
		
		Response resp= 
				given()
					.pathParam("myparam", "books")
					.contentType(ContentType.JSON)
				
				.when()
					.get("http://localhost:3000/{myparam}");

		
		JSONObject json=new JSONObject(resp.toString());
		
		for(int i=0;i<json.getJSONArray("books").length();i++) {
			
			String suthor=json.getJSONArray("books").getJSONObject(i).get("author").toString();
			
			System.out.println(suthor);
		}
			
			}

}
