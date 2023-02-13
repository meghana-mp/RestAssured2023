package restassured.day.one;
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
import java.util.Map;

import org.json.JSONObject;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class ValidateSchema {

	@Test
	void validateJSONSchema() throws IOException {
		
		
		  byte[] b = Files.readAllBytes(Paths.get(".//Reqrespostbody.json"));

	      //convert byte array to string
	      String data = new String(b);

		given()
			.contentType("application/json")
			.body(data.toString())

		.when()
			.post("https://reqres.in/api/users")
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("SchemaReqres.json"));
	}
}
