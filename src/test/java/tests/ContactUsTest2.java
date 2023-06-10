package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest2 extends TestBase2 {

HomePage HomePage1;
ContactUsPage ContactUsPage1;
String name = "test1";
String email = "test2@test.com";
String enquiry = "test3";

@Test
public void testContactUs()
{
	HomePage1 = new HomePage(driver);
	HomePage1.openContactUsPage();
	ContactUsPage1 = new ContactUsPage(driver);
	ContactUsPage1.fillData(name, email, enquiry);
	//assertEquals(ContactUsPage1.Result.getText(), "Your enquiry has been successfully sent to the store owner.");
}
	
	
}
