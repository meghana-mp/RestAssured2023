package restassured.chain.api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

public class CreateUser {
	
	@Test
	void testCreateUser(ITestContext context) {
		//Faker to generate random data
		
		Faker faker=new Faker();
		
		JSONObject data=new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken="4301ad47e5762a07b31e8b67cbdd2cc8a79bcd020e2a0f2f58be0e1c953daa9a";
		
		
		int id=given()
			.headers("Authorization","Bearer "+bearerToken)
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");
		
		System.out.println("Generated id " + id);
		
	//	context.setAttribute("user_id", id);  //Available at the the test level
		context.getSuite().setAttribute("user_id", id);  //Suite level variable
	}
}
