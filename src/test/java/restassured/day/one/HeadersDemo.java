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

public class HeadersDemo {
	
	//@Test(priority=1)
	void testHeader() {
		
		
		given()
		
		.when()
			.get("https://www.google.co.in")
		
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.and()
			.header("Content-Encoding", "gzip")
			.and()
			.header("Server","gws")
			.log().all();
	}

	
	@Test(priority=2)
	void GetSingleHeaderInfo() {
		
		
		Response rep=when()
			.get("https://www.google.co.in");
		
		String headerValue=rep.getHeader("Content-Type");
		
		System.out.println("Header Content-Type value is "+headerValue);
		
	}
	
	@Test(priority=3)
	void GetMultipleHeaderInfo() {
		
		
		Response rep=when()
			.get("https://www.google.co.in");
		
		Headers list= rep.getHeaders();
		System.out.println(" Name of Header" +" "+"Value of Header");
		for(Header hd:list) {
			
			System.out.println(hd.getName() +" "+hd.getValue());
			
		}
	}
}
