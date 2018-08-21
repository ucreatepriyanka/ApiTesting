package Rest_Assured.Rest_Assured;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import Rest_Assured.Rest_Assured_Utilities.ReadTestData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class Login {

   
    @Test
    public void Loginvalid() throws IOException, ParseException {
       
    	ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/connected_2.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        String[] credentials = ReadTestData.getkeyvalues("validdetails", "login");
        JSONObject requestparm = new JSONObject();
        for(int i=2;i<=6;i++) {      
        requestparm.put("email", credentials[i]);
        requestparm.put("password", credentials[0]);
        request.body(requestparm.toJSONString());
        Response response = request.post(credentials[1]);
        int res = response.getStatusCode();
        String res1 = response.asString();
       
        System.out.println(credentials[i]);
        if (res <300 && res >100) {	
        	ExtentTest logger = extent.createTest("Login");
        	 logger.log(Status.PASS, "Success");
        } else if (res <500 && res > 400 )	
        {
        ExtentTest logger1 = extent.createTest("fail ");
       	 logger1.log(Status.FAIL, "fail");	 
        }
        else if (res == 500) { 
        ExtentTest logger2 = extent.createTest("gjhj");
       	 logger2.log(Status.FAIL, "internal sever error");
        }
       extent.flush();
    }
    }
  }


