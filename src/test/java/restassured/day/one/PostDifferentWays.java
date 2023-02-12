package restassured.day.one;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
import io.restassured.module.jsv.JsonSchemaValidator.*;

import org.json.JSONTokener;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

public class PostDifferentWays {

	
	//@Test
	void PostUsingHashMap() {
		
		HashMap data=new HashMap();
		
		data.put("id", "01");
		data.put("author", "abc");
		data.put("price", 850);
		
		String url="http://localhost:3000/books";
		
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post(url)
		
		.then()
			.statusCode(201)
			.body("id", equalTo("01"))
			.body("author", equalTo("abc"))
			.body("price", equalTo(850))
			.header("content-type", "application/json; charset=utf-8")
			.log().all();
	}
	
	//@Test(priority=2)
	void deleteUser()
	{
		
		String delete_url="http://localhost:3000/books/204";
		given()
			
		.when()
			.delete(delete_url)
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	//Second Method: Post using JSON data Object
	
	//@Test
	void PostUsingJsonLibrary() {
		
		String posturl="http://localhost:3000/books";
		//JsonObject data=new JsonObject();
		
		JSONObject data= new JSONObject();
		
		data.put("id", 12);
		data.put("author", "kbc");
		data.put("price", 471);
		
		
		given()
			.contentType("application/json")
			.body(data.toString())
				
		.when()
			.post(posturl)
		
		.then()
			.statusCode(201)
			.log().all();
		
	}
	
	//third method: Using POJO Classs
//@Test	
void PostUsingPOJOClass() {
		
		String posturl1="http://localhost:3000/books";
		
		POJO_PostRequest data=new POJO_PostRequest();
		
		data.setId(125465);
		data.setAuthor("aqesr");
		data.setPrice(80);
		
		
		given()
			.contentType("application/json")
			.body(data)
				
		.when()
			.post(posturl1)
		
		.then()
			.statusCode(201)
			.log().all();
		
	}

//4th method: Using external Json file
@Test	
void PostUsingExternalJsonFile() throws IOException {
		
		String posturl2="http://localhost:3000/books";
		
		   byte[] b = Files.readAllBytes(Paths.get(".//body.json"));

		      //convert byte array to string
		      String data = new String(b);
		
		
		given()
			.contentType("application/json")
			.body(data.toString())
				
		.when()
			.post(posturl2)
		
		.then()
			.statusCode(201)
			.log().all();
		
	}

	
}
