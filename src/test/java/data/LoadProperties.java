package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

	public static Properties userData = loadProperties("C:\\Users\\Lenovo\\Documents\\Eclipse_Github_Clonetest\\SeleniumFramework\\src\\main\\java\\properties\\userdata.properties");
	//public static Properties SauceData = loadProperties(System.getProperty("user.dir")+"src\\main\\java\\properties\\SauceLabs.properties");
	public static Properties SauceData = loadProperties("C:\\Users\\Lenovo\\Documents\\Eclipse_Github_Clonetest\\SeleniumFramework\\src\\main\\java\\properties\\SuaceLabs.properties");
	
private static Properties loadProperties(String path)
{
	Properties pro = new Properties();
	try {
		FileInputStream stream = new FileInputStream(path);
		pro.load(stream);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return pro;
}
}
