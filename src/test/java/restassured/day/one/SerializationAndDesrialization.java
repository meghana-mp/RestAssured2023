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
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.module.jsv.JsonSchemaValidator;

public class SerializationAndDesrialization {
	
	//@Test//Serialization
	void convertPOJOtoJSON() throws JsonProcessingException {
		
		//Created JAVA Object using POJO class
		POJO_PostRequest data= new POJO_PostRequest();
		
		data.setId(101);
		data.setPrice(258);
		data.setAuthor("kill");
		
		//Convert JAVA object to JSON object
		ObjectMapper obj=new ObjectMapper();
		
		String JsonData=obj.writer().withDefaultPrettyPrinter().writeValueAsString(data);
		
		System.out.println("Converted to JSON data "+JsonData);
		
	}
	
	@Test//De Serialization
	void convertJSONtoPOJO() throws JsonProcessingException {
		
		//JSON is in String format
		String jsondata="{\r\n" + 
				"  \"id\" : 101,\r\n" + 
				"  \"author\" : \"kill\",\r\n" + 
				"  \"price\" : 258\r\n" + 
				"}";
		
		//Convert JSON Data string into POJO object
		
		ObjectMapper obj1=new ObjectMapper();
		
		 POJO_PostRequest postPOJO=	obj1.readValue(jsondata, POJO_PostRequest.class);
		
	System.out.println(	 postPOJO.getId()+ "\n "+ postPOJO.getAuthor()+ "\n " +postPOJO.getPrice());
		
	}


}
