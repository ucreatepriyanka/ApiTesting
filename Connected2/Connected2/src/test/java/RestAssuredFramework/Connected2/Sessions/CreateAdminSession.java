package RestAssuredFramework.Connected2.Sessions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class CreateAdminSession {
	@Test
	public void testResponse() {
//		int code = post("https://uat-connected-2-api.herokuapp.com/sessions/admin").getStatusCode();			
//		System.out.println(code);	
		RequestSpecification request =  given();
		 request.header("Context-Type","application/json");
		 JSONObject json =new JSONObject();
		 json.put("email", "test3@ucreate.it");
		 json.put("password", "connecting-admins");
		 request.body(json.toJSONString());
		 int respone=	request.post("https://uat-connected-2-api.herokuapp.com/sessions/admin").getStatusCode();
		 System.out.println(respone);
	}

}