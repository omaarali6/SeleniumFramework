package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterationPage;

public class RegisterationTest_Excel extends TestBase {

	HomePage HomePage1;
	RegisterationPage RegisterationPage1;
	LoginPage LoginPage1;
	
	@DataProvider(name="ExceldataReader")
	public Object[][] getUserData() throws IOException
	{
		ExcelReader er = new ExcelReader();
		return er.getExcelData();
	}
	
	@Test(priority=1, dataProvider = "ExceldataReader")
	public void testRegister(String fname, String lname, String email, String pass)
	{
		HomePage1 = new HomePage(driver);
		HomePage1.openRegisterationPage();
		RegisterationPage1 = new RegisterationPage(driver);
		RegisterationPage1.register(fname,lname,email,pass,pass);
		assertEquals(RegisterationPage1.RegisterResult.getText(), "Your registration completed");
	}
	@Test(dependsOnMethods = {"testRegister"})
	public void userCanLogin() throws InterruptedException
	{
		HomePage1 = new HomePage(driver);
		HomePage1.openLoginPage();
		LoginPage1 = new LoginPage(driver);
		LoginPage1.login("Test9@gmail.com", "Omar12345");
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
