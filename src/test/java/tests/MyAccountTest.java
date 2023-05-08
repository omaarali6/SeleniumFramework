package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegisterationPage;

public class MyAccountTest extends TestBase {


	HomePage HomePage1;
	RegisterationPage RegisterationPage1;
	LoginPage LoginPage1;
	MyAccountPage MyAccPage1;
	@Test(priority=1)
	public void testRegister() throws InterruptedException
	{
		HomePage1 = new HomePage(driver);
		HomePage1.openRegisterationPage();
		RegisterationPage1 = new RegisterationPage(driver);
		RegisterationPage1.register("Omar", "Ali", "test21@gmail.com", "Omar12345", "Omar12345");
		assertEquals(RegisterationPage1.RegisterResult.getText(), "Your registration completed");
	}
	@Test(priority=2)
	public void userCanLoginFirstTime()
	{
		HomePage1 = new HomePage(driver);
		HomePage1.openLoginPage();
		LoginPage1 = new LoginPage(driver);
		LoginPage1.login("Test21@gmail.com", "Omar12345");
		assertTrue( !(driver.findElements(By.linkText("Log out")).size()==0) );
	}
	@Test(priority=3)
	public void userCanChangePassword() throws InterruptedException
	{
		HomePage1 = new HomePage(driver);
		HomePage1.openMyAccount();
		MyAccPage1 = new MyAccountPage(driver);
		MyAccPage1.goToChangePassword();
		MyAccPage1.changePassword("Omar12345", "Omar54321");
		MyAccPage1.dismissMsg();
		assertTrue(MyAccPage1.ChngPasswordResult.getText().contains("changed"));
	}
	@Test(priority=4)
	public void userCanLogOut()
	{
		MyAccPage1 = new MyAccountPage(driver);
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(MyAccPage1.LogOutLink));
		MyAccPage1.logOut();
		assertTrue( !(driver.findElements(By.linkText("Log in")).size()==0) );
	}
	@Test(priority=5)
	public void userCanLoginWithNewassword()
	{
		HomePage1 = new HomePage(driver);
		HomePage1.openLoginPage();
		LoginPage1 = new LoginPage(driver);
		LoginPage1.login("Test21@gmail.com", "Omar54321");
		assertTrue( !(driver.findElements(By.linkText("Log out")).size()==0) );
	}
	
}
