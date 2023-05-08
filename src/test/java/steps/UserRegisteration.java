package steps;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegisterationPage;
import tests.TestBase;

public class UserRegisteration extends TestBase {

	HomePage HomePage1;
	RegisterationPage RegisterationPage1;
	@Given("the user is in the home page")
	public void the_user_is_in_the_home_page() {
	    HomePage1 = new HomePage(driver);
	    HomePage1.openRegisterationPage();
	}
	@When("the user clicks on the registeration button")
	public void the_user_clicks_on_the_registeration_button() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	/*
	@When("the user fill the data")
	public void the_user_fill_the_data() {
	    RegisterationPage1 = new RegisterationPage(driver);
	    RegisterationPage1.register("Omar", "Ali", "test@test.com", "123456", "123456");
	}
	*/

	@When("the user enters {string},{string},{string},{string}")
	public void the_user_enters(String fname, String lname, String email, String pass) {
		RegisterationPage1 = new RegisterationPage(driver);
	    RegisterationPage1.register(fname,lname,email,pass,pass);
	}
	
	
	@Then("The user is prompted to the successful registeration page")
	public void the_user_is_prompted_to_the_successful_registeration_page() {
		assertEquals(RegisterationPage1.RegisterResult.getText(), "Your registration completed");
	}	
	
}
