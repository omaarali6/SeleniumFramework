package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader {
public String fname, lname,email,pass;


public void JsonReader() throws FileNotFoundException, IOException, ParseException
{
	String path = System.getProperty("user.dir")+"\\src\\test\\java\\data\\Userdata.json";
	File file = new File(path);
	JSONParser jp = new JSONParser();
	JSONArray jarr = (JSONArray) jp.parse(new FileReader(file));
	
	
	for (Object Job : jarr)
	{
		JSONObject person = (JSONObject) Job;
		fname = (String) person.get("fname");
		lname = (String) person.get("lname");
		email = (String) person.get("email");
		pass = (String) person.get("pass");
	}
}
}
