package tests;

//import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.RegisterationPage;

public class RegisterationTest_CSV extends TestBase {

	HomePage HomePage1;
	RegisterationPage RegisterationPage1;
	LoginPage LoginPage1;
	CSVReader reader;
	
	@Test(priority=1)
	public void testRegister() throws InterruptedException, CsvValidationException, IOException
	{
		String FilePath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\Userdata.csv";
		reader = new CSVReader(new FileReader(FilePath));
		
		String[] row;
		
		while( (row = reader.readNext()) != null )
		{
			String fname= row[0];
			String lname= row[1];
			String email= row[2];
			String pass= row[3];
		
		
		
		HomePage1 = new HomePage(driver);
		HomePage1.openRegisterationPage();
		RegisterationPage1 = new RegisterationPage(driver);
		RegisterationPage1.register(fname,lname,email,pass,pass);
		//assertEquals(RegisterationPage1.RegisterResult.getText(), "Your registration completed");
		}
	}
	@Test(dependsOnMethods = {"testRegister"})
	public void userCanLogin() throws InterruptedException
	{
		HomePage1 = new HomePage(driver);
		HomePage1.openLoginPage();
		LoginPage1 = new LoginPage(driver);
		LoginPage1.login("fname1@test.com", "123456");
		assertTrue( !(driver.findElements(By.linkText("Log out")).size()==0) );
	}
	
	@Test(dependsOnMethods = {"userCanLogin"})
	public void userCanLogOut()
	{
		HomePage1 = new HomePage(driver);
		HomePage1.logOut();
		assertTrue( !(driver.findElements(By.linkText("Log in")).size()==0) );
	}
	
}
