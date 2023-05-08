package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
@FindBy(id = "FullName")
WebElement NameTextBox;

@FindBy(id = "Email")
WebElement EmailTextBox;

@FindBy(id = "Enquiry")
WebElement EnquiryTextBox;

@FindBy(css = "button.button-1.contact-us-button")
WebElement SubmitBtn;

@FindBy(css = "div.result")
public WebElement Result;



public void fillData(String name, String Email, String Enquiry)
{
	FillTextBox(NameTextBox, name);
	FillTextBox(EmailTextBox, Email);
	FillTextBox(EnquiryTextBox, Enquiry);
	clickButton(SubmitBtn);
}


}
