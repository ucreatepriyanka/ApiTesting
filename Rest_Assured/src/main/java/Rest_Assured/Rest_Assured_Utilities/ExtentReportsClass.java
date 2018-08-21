package Rest_Assured.Rest_Assured_Utilities;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsClass{
 
	public void Extentreports(Boolean result, String content, String TestCase) throws IOException {    
        ExtentHtmlReporter reporter = new ExtentHtmlReporter("./connected_2.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
      
        	ExtentTest logger = extent.createTest(TestCase);
            
            if (result= true) {
                //logger.log(Status.INFO, content);
                logger.log(Status.PASS, content);
            }
            else if(result=false)
            {
                logger.log(Status.FAIL, content);
                       
        	
        }
        	
        extent.flush();
    }


}
