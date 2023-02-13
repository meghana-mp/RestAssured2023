package restassured.day.one;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.module.jsv.JsonSchemaValidator.*;
import io.restassured.response.Response;

public class CookiesDemo {

	
//	@Test(priority=1)
	void testCookies() {
		
		given()
		
		.when()
			.get("https://www.google.co.in")
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	//@Test(priority=2)
	void getCookiesInfo() {
		
		Response rs=given()
		
		.when()
			.get("https://www.google.co.in");
		
		String	cookie_value=rs.getCookie("AEC");
		
		
		System.out.println("Cookie value is "+cookie_value);
		
	}
	
	@Test(priority=3)
	void getAllTheCookiesInfo() {
		
		Response rs=given()
		
		.when()
			.get("https://www.google.co.in");
		
		Map<String,String> cookiesvalue=rs.getCookies();
		
		System.out.println(cookiesvalue.keySet());
		
		for(String k:cookiesvalue.keySet()) {
			
			String cookies_value1=rs.getCookie(k);
			System.out.println(k +"  "+cookies_value1);
		}
	}

}
