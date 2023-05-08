package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterationPage;

public class RegisterationTest_Properties extends TestBase {

	HomePage HomePage1;
	RegisterationPage RegisterationPage1;
	LoginPage LoginPage1;
	
	String fname = LoadProperties.userData.getProperty("fname");
	String lname = LoadProperties.userData.getProperty("lname");
	String email = LoadProperties.userData.getProperty("email");
	String pass = LoadProperties.userData.getProperty("pass");
	@Test(priority=1)
	public void testRegister() throws InterruptedException
	{
		HomePage1 = new HomePage(driver);
		HomePage1.openRegisterationPage();
		RegisterationPage1 = new RegisterationPage(driver);
		RegisterationPage1.register(fname, lname, email, pass, pass);
		assertEquals(RegisterationPage1.RegisterResult.getText(), "Your registration completed");
	}
	@Test(dependsOnMethods = {"testRegister"})
	public void userCanLogin() throws InterruptedException
	{
		HomePage1 = new HomePage(driver);
		HomePage1.openLoginPage();
		LoginPage1 = new LoginPage(driver);
		LoginPage1.login("Test6@gmail.com", "123456");
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
