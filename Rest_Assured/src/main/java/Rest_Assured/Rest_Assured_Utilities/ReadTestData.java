package Rest_Assured.Rest_Assured_Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadTestData {
	
public static FileReader fileread;

	
	public static String[] getkeyvalues(String scenario, String filename) throws IOException, ParseException{
		 JSONParser parser = new JSONParser();
			try {
				 fileread = new FileReader(System.getProperty("user.dir")+File.separator+"src//test//resources//TestData//"+ filename+".json");
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			Object obj = parser.parse(fileread);
			JSONObject jsonobj = (JSONObject) obj;
		 JSONArray entry = (JSONArray) jsonobj.get(scenario);
		  String[] values = new String[entry.size()] ;
		 for (int i = 0; i < entry.size(); i++) {
			 JSONObject jsonarr = (JSONObject) entry.get(i);
		        Object[] keyStr = jsonarr.keySet().toArray();
		        String keyvalue = jsonarr.get(keyStr[0]).toString();
		        values [i] = keyvalue; 

}
		return values;
	}
}
