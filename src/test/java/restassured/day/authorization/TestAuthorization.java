package restassured.day.authorization;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.List;
import org.testng.annotations.Test;

public class TestAuthorization {
	
	//Basic Authentication
//	@Test(priority=1)
	void testBasicAuth() {
		
		
		given()
			.auth().basic("postman", "password")
		
		.when()
			.get("https://postman-echo.com/basic-auth")
		
		
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
		
	}
	
	//Digest Auth
	//@Test(priority=2)
	void testDigestAuth() {
		
		
		given()
			.auth().digest("postman", "password")
		
		.when()
			.get("https://postman-echo.com/basic-auth")
		
		
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
		
	}
	
	//Preemptive Auth
	//	@Test(priority=3)
		void testPremptiveAuth() {
			
			
			given()
				.auth().preemptive().basic("postman", "password")
			
			.when()
				.get("https://postman-echo.com/basic-auth")
			
			
			.then()
				.statusCode(200)
				.body("authenticated", equalTo(true))
				.log().all();
			
		}
		
		//Bearer Token Athentication
	//	@Test(priority=4)
		void testBearerToken() {
			String bearerToken="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";
			
			given()
				.headers("Authorization", "Bearer "+bearerToken)
			
			.when()
				.get("https://api.github.com/user/repos")
			
			.then()
				.statusCode(200)
				.log().all();
		}

		//OAuth1.0 Auth
		//@Test
		void testOAuth1() {
			
			given()
				.auth().oauth("consumerKey", "consumerSecret", "accessToken", "secretToken")
			.when()
				.get("url")
			
			.then()
				.statusCode(200)
				.log().all();
			
		}
		
		//OAuth2.0 
		//@Test
void testOAuth2() {
			
			given()
				.auth().oauth2("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")
			.when()
				.get("https://api.github.com/user/repos")

			
			.then()
				.statusCode(200)
				.log().all();
			
		}


//API key authentication
@Test
void testAPIKey() {
	
	given()
		.queryParam("lat", "44.34")
		.queryParam("lon", "10.99")
		.queryParam("appid", "fb02704f058408833b2e8c1f0eb409ab")
	.when()
		.get("https://api.openweathermap.org/data/2.5/weather")
	
	.then()
		.log().all();
	
}

}
