package RestAssuredFramework.Connected2.Drivers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;


public class DriversTest {
	public void AppyforJobsLicensedates() {
	int response = put("https://uat-connected-2-api.herokuapp.com/sessions/admin").getStatusCode();				
	RequestSpecification request =  given();
	request.header("Context-Type","application/json");
     JSONObject json =new JSONObject();
	 json.put("validFrom", "test3@ucreate.it");
	 json.put("validUntil", "connecting-admins");
	 json.put("licenceId", "connecting-admins");
	 request.body(json.toJSONString());
	 int respone=	request.post("https://uat-connected-2-api.herokuapp.com/sessions/admin").getStatusCode();
	 System.out.println(respone);
	}
	
}


