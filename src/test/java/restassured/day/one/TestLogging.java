package restassured.day.one;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator.*;
import io.restassured.response.Response;

public class TestLogging {
//	@Test
	void testlogsOnlyHeaders() {
		given()
		
		.when()
			.get("https://www.google.co.in")
		
		.then()
			.log().headers();// only headers
	}
	
	//@Test
	void testlogsOnlyBody() {
		given()
		
		.when()
			.get("https://www.google.co.in")
		
		.then()
			.log().body();// only body
	}
	
	@Test
	void testlogsOnlyCookies() {
		given()
		
		.when()
			.get("https://www.google.co.in")
		
		.then()
			.log().cookies();// only cookies
	}
	
	
}
