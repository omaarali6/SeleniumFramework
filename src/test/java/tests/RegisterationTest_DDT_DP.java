package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.RegisterationPage;

public class RegisterationTest_DDT_DP extends TestBase {

	HomePage HomePage1;
	RegisterationPage RegisterationPage1;
	LoginPage LoginPage1;
	
	@DataProvider(name="TestData")
	public static Object[][] getData()
	{
		return new Object[][] {{"Regina","Ph","test4@test.com","123456"},{"Ken","Adams","test3@test.com","678910"}};
	}
	
	
	
	@Test(priority=1,dataProvider = "TestData")
	public void testRegister(String fname,String lname,String email, String pass) throws InterruptedException
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
		LoginPage1.login("test4@test.com", "123456");
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
