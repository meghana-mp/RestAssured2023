package restassured.chain.api;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;


public class DeleteUser {
	
	@Test
	void TestDeleteUser(ITestContext context) {
		
	//	int id=	(Integer) context.getAttribute("user_id"); //test level variable
		int id=	(Integer) context.getSuite().getAttribute("user_id");  //suite level variable
		
		String bearerToken="4301ad47e5762a07b31e8b67cbdd2cc8a79bcd020e2a0f2f58be0e1c953daa9a";
		
		
		given()
			.headers("Authorization","Bearer "+bearerToken)
			.pathParam("id", id)
		.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(204)
			.log().all();

	}


}
